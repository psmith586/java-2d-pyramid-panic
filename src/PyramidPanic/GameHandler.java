package PyramidPanic;

import PyramidPanic.entities.EntityManager;
import PyramidPanic.gamefx.GameCam;
import PyramidPanic.gamefx.GameWorld;
import PyramidPanic.states.State;
import PyramidPanic.util.KeyManager;
import PyramidPanic.util.MouseManager;

public class GameHandler {

    private Game game;
    private GameWorld world;

    public GameHandler(Game game){
        this.game = game;
    }

    public int getWidth(){ return game.getWidth(); }

    public int getHeight(){ return game.getHeight(); }

    public Game getGame(){ return game; }

    public void setGame(Game game){ this.game = game; }

    public GameWorld getWorld(){ return world; }

    public void setWorld(GameWorld world){ this.world = world; }

    public GameCam getGameCam(){
        return game.getGameCam();
    }

    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public MouseManager getMouseManager(){ return game.getMouseManager(); }

}
