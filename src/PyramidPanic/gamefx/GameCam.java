package PyramidPanic.gamefx;

import PyramidPanic.GameHandler;
import PyramidPanic.entities.Entity;
import PyramidPanic.tiles.Tile;

public class GameCam {

    private GameHandler handler;
    private float xOff, yOff;

    public GameCam(GameHandler handler, float xOff, float yOff){
        this.handler = handler;
        this.xOff = xOff;
        this.yOff = yOff;
    }

    public void checkBorder(){
        if(xOff < 0){
            xOff = 0;
        }else if(xOff > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()){
            xOff = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
        }

        if(yOff < 0){
            yOff = 0;
        }else if(yOff > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()){
            yOff = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
        }
    }

    public void centerOnEnt(Entity e){
        xOff =  (e.getX() - handler.getWidth() / 2 + e.getWidth()) / 2;
        yOff =  (e.getY() - handler.getHeight() / 2 + e.getHeight() /2);

        checkBorder();
    }

    public void move(float x, float y){
        xOff += x;
        yOff += y;
        checkBorder();
    }

    public float getxOff() {
        return xOff;
    }

    public void setxOff(float xOff) {
        this.xOff = xOff;
    }

    public float getyOff() {
        return yOff;
    }

    public void setyOff(float yOff) {
        this.yOff = yOff;
    }
}
