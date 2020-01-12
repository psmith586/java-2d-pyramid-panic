package PyramidPanic.states;

import PyramidPanic.GameHandler;
import PyramidPanic.gamefx.GameWorld;

import java.awt.*;


public class GameState extends State {

    private GameWorld world;

    public GameState(GameHandler handler){
        super(handler);
        world = new GameWorld(handler, "resources/world");
        handler.setWorld(world);
    }

    @Override
    public void update() {
        world.update();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
    }

    @Override
    public void setWin(boolean b) {

    }
}
