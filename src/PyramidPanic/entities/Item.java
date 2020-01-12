package PyramidPanic.entities;

import PyramidPanic.GameHandler;

import java.awt.*;

public class Item extends Entity {

    public Item(GameHandler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);

        bounds = new Rectangle((int) x, (int) y, width, height);
    }

    @Override
    public void update() {

        /*if collision add string to item array to add effects*/
        if(handler.getWorld().getEntityManager().getPlayer().getHitBox(0f, 0f).intersects(bounds)){
            active = false;

            grabbed();
        }
    }

    @Override
    public void render(Graphics g) {}

    @Override
    public void death() {}

    /*override to add item to item array*/
    public void grabbed(){}
}
