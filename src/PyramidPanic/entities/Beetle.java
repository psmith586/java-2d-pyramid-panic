package PyramidPanic.entities;

import PyramidPanic.GameHandler;
import PyramidPanic.gamefx.AssetManager;
import PyramidPanic.tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Beetle extends Entity {

    private boolean switchDir;
    private int counter, switchCount;
    private Rectangle bounds;

    public Beetle(GameHandler handler, float x, float y) {
        super(handler, x, y, Entity.DEFAULT_ENEMY_WIDTH, Entity.DEFAULT_ENEMY_HEIGHT);

        switchDir = true;
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

        g.drawImage(getBeetleFrame(), (int) (x - handler.getGameCam().getxOff()),
                (int) (y - handler.getGameCam().getyOff()), width, height, null);

    }

    @Override
    public void death() {
        active = false;
    }

    private BufferedImage getBeetleFrame(){
        if(switchDir){
            return AssetManager.beetle_up;
        }else{
            return AssetManager.beetle_down;
        }
    }


    public void move(float spd) {

        /*up*/
        if(spd < 0){
            int vy = (int) (y + spd + bounds.y) / Tile.TILEHEIGHT;

            if(!collidedWithTile( (int) (x + bounds.x) / Tile.TILEWIDTH, vy) && !collidedWithTile( (int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, vy)){

                y += spd;

            }else{
                y = vy * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;

            }
            /*down*/
        }else if(spd > 0){

            int vy = (int) (y + spd + bounds.y + bounds.height) / Tile.TILEHEIGHT;

            if(!collidedWithTile( (int) (x + bounds.x) / Tile.TILEWIDTH, vy) && !collidedWithTile( (int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, vy)){

                y += spd;

            }else{
                y = vy * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;

            }
        }
    }
}
