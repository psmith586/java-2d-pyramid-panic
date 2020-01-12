package PyramidPanic.tiles;

import PyramidPanic.gamefx.AssetManager;

public class DoorBlock extends Tile {

    public DoorBlock(int id){
        super(AssetManager.background, id);
    }

    @Override
    public boolean isSolid() {
        return false;
    }
}
