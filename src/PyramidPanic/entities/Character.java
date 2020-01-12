package PyramidPanic.entities;

import PyramidPanic.GameHandler;
import PyramidPanic.tiles.Tile;

import java.awt.*;

public class Character extends Entity {

    public static final float DEFAULT_SPD = 1f;
    public static final int DEFAULT_CHAR_WIDTH = 32, DEFAULT_CHAR_HEIGHT = 32;

    protected float spd;
    protected float xMove, yMove;

    public Character(GameHandler handler, float x, float y, int width, int height){
        super(handler, x, y, width, height);

        spd = DEFAULT_SPD;
        xMove = 0;
        yMove = 0;

    }

    @Override
    public void update() {}

    @Override
    public void render(Graphics g) {}

    @Override
    public void death() {}


    public boolean collidedWithTile(int x, int y){
        return handler.getWorld().getTile(x, y).isSolid();
    }

    public void move(){
        if(!isCollision(xMove, 0f)) {
            moveX();
        }

        if(!isCollision(0f, yMove)) {
            moveY();
        }

        /*test*/
        //moveX();
        //moveY();
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public int getHp(){
        return hp;
    }

    public void setHp(int hp){
        this.hp = hp;
    }

    public float getSpd() {
        return spd;
    }

    public void setSpd(float spd) {
        this.spd = spd;
    }

    public void moveX(){
        /*right*/
        if(xMove > 0){
            int vx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;

            if(!collidedWithTile(vx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                !collidedWithTile(vx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){

                x += xMove;

            }else{
                x = vx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
            }
        /*left*/
        }else if(xMove < 0){

            int vx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;

            if(!collidedWithTile(vx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                    !collidedWithTile(vx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){

                x += xMove;

            }else{
                x = vx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
            }

        }
    }

    public void moveY(){
        /*up*/
        if(yMove < 0){
            int vy = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;

            if(!collidedWithTile( (int) (x + bounds.x) / Tile.TILEWIDTH, vy) && !collidedWithTile( (int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, vy)){

                y += yMove;

            }else{
                y = vy * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;

            }
        /*down*/
        }else if(yMove > 0){

            int vy = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;

            if(!collidedWithTile( (int) (x + bounds.x) / Tile.TILEWIDTH, vy) && !collidedWithTile( (int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, vy)){

                y += yMove;

            }else{
                y = vy * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;

            }
        }
    }
}
