package PyramidPanic.states;

import PyramidPanic.GameHandler;

import java.awt.*;

import PyramidPanic.gamefx.AssetManager;
import PyramidPanic.util.ImageButton;
import PyramidPanic.util.UIManager;

public class MenuState extends State{

    private UIManager uiManager;

    public MenuState(GameHandler handler){
        super(handler);
        uiManager = new UIManager(handler);
        /*start*/
        uiManager.addObj(new ImageButton(525, 500, 150, 50, AssetManager.start, () -> {
            handler.getMouseManager().setUiManager(null);
            State.setCurrentState(handler.getGame().gameState);
        }));
        /*help*/
        uiManager.addObj(new ImageButton(525, 575, 150, 50, AssetManager.help, () -> {
            handler.getMouseManager().setUiManager(null);
            State.setCurrentState(handler.getGame().gameState);
        }));
        /*quit*/
        uiManager.addObj(new ImageButton(525, 650, 150, 50, AssetManager.quit, () -> {
            handler.getMouseManager().setUiManager(null);
            State.setCurrentState(handler.getGame().gameState);
        }));
    }

    @Override
    public void update() {

        uiManager.update();

        if(handler.getMouseManager().isLeftClick() || handler.getMouseManager().isRightClick()) {
        handler.getMouseManager().setUiManager(null);
        State.setCurrentState(handler.getGame().gameState);
        }
    }

    @Override
    public void render(Graphics g) {

        g.drawImage(AssetManager.menuBG, 0, 0, handler.getWidth(), handler. getHeight(), null);
        g.drawImage(AssetManager.titleImg,  300, 100, 600, 200, null);
        uiManager.render(g);
    }

    @Override
    public void setWin(boolean b) {

    }
}
