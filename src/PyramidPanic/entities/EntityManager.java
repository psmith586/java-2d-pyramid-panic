package PyramidPanic.entities;

import PyramidPanic.GameHandler;

import java.awt.*;
import java.util.ArrayList;


public class EntityManager {

    private GameHandler handler;
    private Player player;

    private ArrayList<Entity> entities;


    public EntityManager(GameHandler handler, Player player){

        this.handler = handler;
        this.player = player;

        entities = new ArrayList<>();

        entities.add(player);
    }

    public void update(){

        for(int i = 0; i < entities.size(); i++){
            Entity e = entities.get(i);

            e.update();

            if(!e.isActive()){
                entities.remove(e);
            }
        }

        player.update();
    }

    public void render(Graphics g){

        for (Entity e : entities) {
            e.render(g);

            //System.out.print(e.toString() + " is rendered\n");
        }

        player.render(g);
    }

    public void addEnt(Entity e){
        entities.add(e);
    }

    public GameHandler getHandler() {
        return handler;
    }

    public void setHandler(GameHandler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
