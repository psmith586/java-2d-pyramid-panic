package PyramidPanic.states;

import PyramidPanic.GameHandler;
import PyramidPanic.GameLauncher;
import PyramidPanic.gamefx.AssetManager;

import java.awt.*;

public class EndState extends State {
    private boolean win;

    public EndState(GameHandler handler) {
        super(handler);

        win = false;
    }

    @Override
    public void update() {

        /*if(handler.getMouseManager().isLeftClick() || handler.getMouseManager().isRightClick()) {

            State.setCurrentState(handler.getGame().menuState);
            win = false;

        }*/
    }

    @Override
    public void render(Graphics g) {
        if(win){
            g.drawImage(AssetManager.winImg, 0, 0,
                    handler.getWidth(), handler.getHeight(), null);
        }else{
            g.drawImage(AssetManager.loseImg, 0, 0,
                    handler.getWidth(), handler.getHeight(), null);
        }
    }

    public void setWin(boolean win){
        this.win = win;
    }

}
