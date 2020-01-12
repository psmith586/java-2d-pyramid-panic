package PyramidPanic.entities;

import PyramidPanic.GameHandler;
import PyramidPanic.gamefx.AssetManager;
import PyramidPanic.tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class Scorpion extends Entity {

    private boolean switchDir;
    private int counter;
    private int switchCount;
    private Rectangle bounds;

    public Scorpion(GameHandler handler, float x, float y) {
        super(handler, x, y, Entity.DEFAULT_ENEMY_WIDTH, Entity.DEFAULT_ENEMY_HEIGHT);

        switchDir = false;

        counter = 0;
        switchCount = 500;

        bounds = new Rectangle();
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = DEFAULT_ENEMY_WIDTH;
        bounds.height = DEFAULT_ENEMY_HEIGHT;

    }

    @Override
    public void update() {

        if(switchDir){
            move(-1.0f);
        }else{
            move(1.0f);
        }
        counter++;

        if(counter == switchCount){
            switchDir = !switchDir;
            counter = 0;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getScorpionFrame(), (int) (x - handler.getGameCam().getxOff()),
                (int) (y - handler.getGameCam().getyOff()), width, height, null);
    }

    @Override
    public void death(){
        active = false;
    }

    private BufferedImage getScorpionFrame(){
        if (switchDir){
            return AssetManager.scorpion_left;
        }else{
            return AssetManager.scorpion_right;
        }
    }

    public void move(float spd){
            /*right*/
            if(spd > 0){
                int vx = (int) (x + spd + bounds.x + bounds.width) / Tile.TILEWIDTH;

                if(!collidedWithTile(vx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                        !collidedWithTile(vx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){

                    x += spd;

                }else{
                    x = vx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
                }
                /*left*/
            }else if(spd < 0){

                int vx = (int) (x + spd + bounds.x) / Tile.TILEWIDTH;

                if(!collidedWithTile(vx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                        !collidedWithTile(vx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){

                    x += spd;

                }else{
                    x = vx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
                }

            }
    }
}
