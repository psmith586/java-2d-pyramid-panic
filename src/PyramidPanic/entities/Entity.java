package PyramidPanic.entities;

import PyramidPanic.GameHandler;
import PyramidPanic.states.EndState;
import PyramidPanic.states.State;

import java.awt.*;

public abstract class Entity {

    public static final int DEFAULT_HP = 10;
    protected GameHandler handler;
    protected float x, y;
    protected int width, height;
    protected int hp;
    protected boolean active = true;
    protected Rectangle bounds;

    protected static final int DEFAULT_ENEMY_WIDTH = 40;
    protected static final int DEFAULT_ENEMY_HEIGHT = 40;

    public Entity(GameHandler handler, float x, float y, int width, int height){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        hp = DEFAULT_HP;

        bounds = new Rectangle(0, 0, width, height);
    }

    public abstract void update();

    public abstract void render(Graphics g);

    public abstract void death();

    public boolean collidedWithTile(int x, int y){
        return handler.getWorld().getTile(x, y).isSolid();
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void damage(int d){
        hp -= d;

        if(hp <= 0){
            active = false;
            death();
        }
    }

    public void heal(int h){
        hp += h;
    }

    public Rectangle getHitBox(float xOff, float yOff){
        return new Rectangle((int) (x + bounds.x + xOff), (int) (y + bounds.y + yOff),
                bounds.width, bounds.height);
    }

    public boolean isCollision(float xOff, float yOff){
        for(Entity i : handler.getWorld().getEntityManager().getEntities()){
            /*make sure entity does not check collision on itself*/
            if(i.equals(this)){
                continue;
            }

            if(i.getHitBox(0f, 0f).intersects(getHitBox(xOff, yOff))){
                /*collision happens
                * check if its a move block or enemy
                */

                if(i instanceof MovableBlock) {

                    /*test*/
                    //System.out.print("collided with movable block");

                    /*hblock moves on x axis, vblock moves on y axis*/

                    if (xOff > 0 && i instanceof HBlock) {
                        ((HBlock) i).move(1f, 0f);
                    }

                    if(xOff < 0 && i instanceof HBlock){
                        ((HBlock) i).move(-1f, 0f);
                    }

                    if (yOff > 0 && i instanceof VBlock) {
                        ((VBlock) i).move(0f, 1f);
                    }

                    if(yOff < 0 && i instanceof VBlock){
                        ((VBlock) i).move(0f, -1f);
                    }

                }

                if(i instanceof Door){
                    if(handler.getWorld().getEntityManager().getPlayer().isHasAnubis() && handler.getWorld().getEntityManager().getPlayer().isHasAmulet()
                        && handler.getWorld().getEntityManager().getPlayer().isHasSword() && handler.getWorld().getEntityManager().getPlayer().isHasScarab()){

                        handler.getGame().endState.setWin(true);
                        State.setCurrentState(handler.getGame().endState);
                    }
                }

                if(i instanceof Scorpion){
                    if(handler.getWorld().getEntityManager().getPlayer().isHasAnubis()){
                        i.death();
                        handler.getWorld().getEntityManager().getEntities().remove(i);
                    }else{
                        handler.getWorld().getEntityManager().getPlayer().damage(1);
                    }
                }

                if(i instanceof Beetle){
                    if(handler.getWorld().getEntityManager().getPlayer().isHasScarab()){
                        i.death();
                        handler.getWorld().getEntityManager().getEntities().remove(i);
                    }else{
                        handler.getWorld().getEntityManager().getPlayer().damage(1);
                    }
                }

                if(i instanceof Mummy){
                    if(handler.getWorld().getEntityManager().getPlayer().isHasSword()){
                        i.death();
                        handler.getWorld().getEntityManager().getEntities().remove(i);
                    }else{
                        handler.getWorld().getEntityManager().getPlayer().damage(1);
                    }

                }

                return true;
            }
        }

        return false;
    }


}
