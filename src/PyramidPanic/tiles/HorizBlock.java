package PyramidPanic.tiles;

import PyramidPanic.gamefx.AssetManager;

public class HorizBlock extends Tile{

    public HorizBlock(int id){
        super(AssetManager.background, id);
    }

    @Override
    public boolean isSolid(){ return false; }
}
