package PyramidPanic;

import PyramidPanic.Display.DisplayWindow;
import PyramidPanic.gamefx.AssetManager;
import PyramidPanic.gamefx.GameCam;
import PyramidPanic.states.EndState;
import PyramidPanic.states.GameState;
import PyramidPanic.states.MenuState;
import PyramidPanic.states.State;
import PyramidPanic.util.KeyManager;
import PyramidPanic.util.MouseManager;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    private DisplayWindow display;
    int width, height;
    public String title;
    private BufferStrategy bs;
    private Graphics g;
    private boolean running = false;
    private Thread thread;

    public State gameState;
    public State menuState;
    public State endState;

    private GameHandler handler;

    private KeyManager keyManager;
    private MouseManager mouseManager;
    private GameCam gameCam;

    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();

    }

    private void init(){
        display = new DisplayWindow(title, width, height);
        AssetManager.init();
        handler = new GameHandler(this);
        gameCam = new GameCam(handler, 0, 0);


        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addKeyListener(keyManager);
        display.getCanvas().addKeyListener(keyManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);


        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        endState = new EndState(handler);
        State.setCurrentState(menuState);


    }

    private void update(){

        keyManager.update();

        if(State.getCurrentState() != null){
            State.getCurrentState().update();
        }
    }

    private void render(){
        bs = display.getCanvas().getBufferStrategy();

        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);

        if(State.getCurrentState() != null){
            State.getCurrentState().render(g);
        }

        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();

        int fps = 60;
        double timePerUpdate = 1000000000.0 / fps, delta = 0;
        long curr, last = System.nanoTime(), timer = 0;
        int updates = 0;

        while(running){
            curr = System.nanoTime();
            delta += (curr - last) / timePerUpdate;
            timer += curr - last;

            if(delta >= 1){
                update();
                render();
                updates ++;
                delta --;
            }

            if(timer >= 1000000000){
                updates = 0;
                timer = 0;
            }
        }

        stop();
    }

    public synchronized void start(){
        if(running){
            return;
        }

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){

        if(!running){
            return;
        }

        try{
            thread.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }



    public int getWidth(){ return width; }
    public int getHeight(){ return height; }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public GameCam getGameCam() {
        return gameCam;
    }
}
