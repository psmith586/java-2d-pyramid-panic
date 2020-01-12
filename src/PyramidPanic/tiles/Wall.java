package PyramidPanic.tiles;


import PyramidPanic.gamefx.AssetManager;

public class Wall extends Tile {

    public Wall(int id) {
        super(AssetManager.wall, id);
    }

    @Override
    public boolean isSolid(){ return true;}
}
