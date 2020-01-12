package PyramidPanic.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    public static Tile[] tiles = new Tile[256];
    public static Tile bgTile = new BGTile(0);
    public static Tile borderTile = new BorderTile(3);
    public static Tile horizBlock = new HorizBlock(5);
    public static Tile vertBlock = new VertBlock(6);
    public static Tile wallTile = new Wall(1);
    public static Tile swordBlock = new DoorBlock(4);

    public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    public boolean isSolid(){
        return false;
    }

    public int getId(){
        return id;
    }
}
