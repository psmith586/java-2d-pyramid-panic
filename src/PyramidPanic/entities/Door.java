package PyramidPanic.entities;

import PyramidPanic.GameHandler;
import PyramidPanic.gamefx.AssetManager;
import PyramidPanic.tiles.Tile;

import java.awt.*;

public class Door extends Entity {


    public Door(GameHandler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(AssetManager.sword_block, (int) (x - handler.getGameCam().getxOff()),
                (int) (y - handler.getGameCam().getyOff()), width, height, null);
    }

    @Override
    public void death() {

    }
}
