package PyramidPanic.entities;

import PyramidPanic.GameHandler;
import PyramidPanic.gamefx.AssetManager;
import PyramidPanic.tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Mummy extends Entity {


    private boolean move_left, move_right, move_up, move_down;
    private int counter, moveRight, moveDown, moveUp, moveLeft;
    private Rectangle bounds;

    private BufferedImage currentFrame;

    public Mummy(GameHandler handler, float x, float y) {
        super(handler, x, y, Entity.DEFAULT_ENEMY_WIDTH, Entity.DEFAULT_ENEMY_HEIGHT);


        move_left = true;
        move_right = false;
        move_up = false;
        move_down = false;

        bounds = new Rectangle();
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = DEFAULT_ENEMY_WIDTH;
        bounds.height = DEFAULT_ENEMY_HEIGHT;

        counter = 0;
        moveDown = 500;
        moveRight = 1000;
        moveUp = 1500;
        moveLeft = 2000;

    }

    @Override
    public void update() {
        if(move_left && counter < moveDown){
            moveX(-2.0f);
            move_down = true;
            currentFrame = getMummyFrame(1);
        }

        if(move_down && counter > moveDown && counter < moveRight){
            moveY(2.0f);
            move_right = true;
            currentFrame = getMummyFrame(2);
        }

        if(move_right && counter > moveRight && counter < moveUp){
            moveX(2.0f);
            move_up = true;
            currentFrame = getMummyFrame(3);
        }

        if(move_up && counter > moveUp && counter < moveLeft){
            moveY(-2.0f);
            move_left = true;
            currentFrame = getMummyFrame(4);
        }

        counter++;

        if(counter == moveLeft){
            counter = 0;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(currentFrame, (int) (x - handler.getGameCam().getxOff()),
                (int) (y - handler.getGameCam().getyOff()), width, height, null);
    }

    @Override
    public void death() {
        active = false;
    }

    private BufferedImage getMummyFrame(int frame){
        if(frame == 3){
            return AssetManager.mummy_right;
        }else if(frame == 2){
            return AssetManager.mummy_down;
        }else if(frame == 1){
            return AssetManager.mummy_left;
        }else{
            return AssetManager.mummy_up;
        }
    }

    public void moveY(float spd) {

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

    public void moveX(float spd){
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
