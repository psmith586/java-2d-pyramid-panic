package PyramidPanic.gamefx;

import PyramidPanic.GameHandler;
import PyramidPanic.entities.*;
import PyramidPanic.util.Utilities;
import PyramidPanic.tiles.Tile;

import java.awt.*;

public class GameWorld {

    private GameHandler handler;
    private int width, height;
    private int[][] tiles;

    private EntityManager entityManager;
    private int player_spawnX, player_spawnY;

    public GameWorld(GameHandler handler, String path){
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler, 800, 64));

        loadWorld(path);

        entityManager.getPlayer().setX(player_spawnX);
        entityManager.getPlayer().setY(player_spawnY);

        /*add in enemies*/

        /*add in items*/
        entityManager.addEnt(new Amulet(handler, 192, 2176));
        entityManager.addEnt(new Anubis(handler, 1600, 512));
        entityManager.addEnt(new Scarab(handler, 288,1312));
        entityManager.addEnt(new Sword(handler, 928,754));

        /*add enemies*/
        entityManager.addEnt(new Mummy(handler, 1024, 1312));
        entityManager.addEnt(new Mummy(handler, 1000, 1612));
        entityManager.addEnt(new Scorpion(handler, 786, 320));
        entityManager.addEnt(new Scorpion(handler, 480, 1536));
        entityManager.addEnt(new Beetle(handler, 352, 1052));
        entityManager.addEnt(new Beetle(handler, 1140, 1984));

        //loadEntities(tiles);

    }

    public void update(){
        entityManager.update();
    }

    public void render(Graphics g){

        int xStart = (int) Math.max(0, handler.getGameCam().getxOff() / Tile.TILEWIDTH);
        int yStart = (int) Math.max(0, handler.getGameCam().getyOff() / Tile.TILEHEIGHT);
        int xEnd = (int) Math.min(width, (handler.getGameCam().getxOff() + handler.getWidth()) / Tile.TILEWIDTH + 1);
        int yEnd = (int) Math.min(height, (handler.getGameCam().getyOff() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

        for(int j = yStart; j < yEnd; j++){
            for(int i = xStart; i < xEnd; i++) {
                getTile(i, j).render(g, (int) (i * Tile.TILEWIDTH - handler.getGameCam().getxOff()),
                        (int) (j * Tile.TILEHEIGHT - handler.getGameCam().getyOff()));

            }

        }

        entityManager.render(g);
    }

    public void loadWorld(String path){
        String file = Utilities.loadFileToString(path);
        String[] tokens = file.split("\\s+");
        width = Utilities.safeParse(tokens[0]);
        height = Utilities.safeParse(tokens[1]);
        player_spawnX = Utilities.safeParse(tokens[2]);
        player_spawnY = Utilities.safeParse(tokens[3]);

        tiles = new int[width][height];

        /*test*/
        //int totalEnts = 0;

        for (int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                tiles[x][y] = Utilities.safeParse(tokens[x + y * width + 4]);

                if(tiles[x][y] == 5){
                    /*test*/
                    //System.out.print("HBlock: " + tiles[x][y] + " ");
                    //totalEnts++;

                    entityManager.addEnt(new HBlock(handler, x * 32, y * 32));

                    //System.out.print("Hblock created\n");
                }

                if(tiles[x][y] == 6){

                    /*test*/
                    //System.out.print("VBlock: " + tiles[x][y] + " ");
                    //totalEnts++;

                    entityManager.addEnt(new VBlock(handler, x * 32, y * 32));
                   // System.out.print("vert made\n");
                }

                if(tiles[x][y] == 4){
                    entityManager.addEnt(new Door(handler, x * 32, y * 32));
                }
            }
        }

        /*test*/
        //System.out.print("\n" + "total ents: " + totalEnts);
    }

    /*public void loadEntities(int[][] map){

        for (int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){

                if(map[x][y] == 5){
                    MovableBlock temp = new MovableBlock(handler, x * 32, y * 32, 32, 32);
                    temp.setHorizontal();
                    entityManager.addEnt(temp);
                }else if(map[x][y] == 6){
                    MovableBlock temp = new MovableBlock(handler, x * 32, y * 32, 32, 32);
                    temp.setVertical();
                    entityManager.addEnt(new MovableBlock(handler, x * 32, y * 32, 32, 32));
                }
            }
        }

    }*/

    public GameHandler getHandler() {
        return handler;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setHandler(GameHandler handler){
        this.handler = handler;
    }

    public Tile getTile(int x, int y){
        if (x < 0 || y < 0 || x >= width || y >= height){
            return Tile.bgTile;
        }

        Tile t = Tile.tiles[tiles[x][y]];

        if(t == null) {
            return Tile.bgTile;
        }

        return t;
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }
}
