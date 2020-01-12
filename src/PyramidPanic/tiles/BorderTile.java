package PyramidPanic.tiles;

import PyramidPanic.gamefx.AssetManager;

public class BorderTile extends Tile{

    public BorderTile(int id){
        super(AssetManager.border, id);
    }

    @Override
    public boolean isSolid(){ return true;}
}
