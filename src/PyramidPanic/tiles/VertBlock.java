package PyramidPanic.tiles;

import PyramidPanic.gamefx.AssetManager;

public class VertBlock extends Tile{

    public VertBlock(int id){
        super(AssetManager.background, id);
    }

    @Override
    public boolean isSolid(){ return false; }
}
