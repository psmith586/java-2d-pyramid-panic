package PyramidPanic.tiles;

import PyramidPanic.gamefx.AssetManager;

public class BGTile extends Tile{
    public BGTile(int id){
        super(AssetManager.background, id);
    }

    @Override
    public boolean isSolid(){ return false; }
}
