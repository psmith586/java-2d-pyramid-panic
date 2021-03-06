package PyramidPanic.entities;

import PyramidPanic.GameHandler;
import PyramidPanic.gamefx.AssetManager;

import java.awt.*;

public class Sword extends Item {
    public Sword(GameHandler handler, float x, float y) {

        super(handler, x, y, 32, 32);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(AssetManager.sword, (int) (x - handler.getGameCam().getxOff()),
                (int) (y - handler.getGameCam().getyOff()), width, height, null);
    }

    @Override
    public void grabbed(){
        handler.getWorld().getEntityManager().getPlayer().addItem("sword");
    }
}
