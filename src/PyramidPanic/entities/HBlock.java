package PyramidPanic.entities;

import PyramidPanic.GameHandler;
import PyramidPanic.gamefx.AssetManager;

import java.awt.*;

public class HBlock extends MovableBlock {


    public HBlock(GameHandler handler, float x, float y) {
        super(handler, x, y);
    }

    @Override
    public void update() {}

    @Override
    public void render(Graphics g) {
        g.drawImage(AssetManager.horiz_block, (int) (x - handler.getGameCam().getxOff()),
                (int) (y - handler.getGameCam().getyOff()), width, height, null);
    }
}
