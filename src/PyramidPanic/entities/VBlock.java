package PyramidPanic.entities;

import PyramidPanic.GameHandler;
import PyramidPanic.gamefx.AssetManager;

import java.awt.*;

public class VBlock extends MovableBlock {

    public VBlock(GameHandler handler, float x, float y) {
        super(handler, x, y);
    }

    @Override
    public void update() {}

    @Override
    public void render(Graphics g) {
        g.drawImage(AssetManager.vert_block, (int) (x - handler.getGameCam().getxOff()),
                (int) (y - handler.getGameCam().getyOff()), width, height, null);

        //System.out.print("V render call");
    }
}
