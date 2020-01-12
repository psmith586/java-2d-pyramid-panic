package PyramidPanic.entities;

import PyramidPanic.GameHandler;
import PyramidPanic.tiles.Tile;

import java.awt.*;

public class MovableBlock extends Entity {


    public MovableBlock(GameHandler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
    }

    @Override
    public void update() {


    }

    @Override
    public void render(Graphics g) {}

    @Override
    public void death() {}


    public void move(float vx, float vy){
        moveY(vy);
        moveX(vx);

    }

    public void moveX(float xMove){
        /*right*/
        if(xMove > 0){
            int vx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;

            if(!collidedWithTile(vx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && !collidedWithTile(vx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {

                x += xMove;
            }
            /*left*/
        }else if(xMove < 0){

            int vx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;

            if(!collidedWithTile(vx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && !collidedWithTile(vx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {

                x += xMove;
            }
        }

    }

    public void moveY(float yMove) {
        /*up*/
        if (yMove < 0) {
            int vy = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;

            if (!collidedWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, vy) && !collidedWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, vy)) {
                y += yMove;


            }

            /*down*/
        } else if (yMove > 0) {

            int vy = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;

            if (!collidedWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, vy) && !collidedWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, vy)) {
                    y += yMove;
            }
        }
    }
}
