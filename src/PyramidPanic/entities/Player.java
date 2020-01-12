package PyramidPanic.entities;

import PyramidPanic.GameHandler;
import PyramidPanic.gamefx.AssetManager;
import PyramidPanic.states.EndState;
import PyramidPanic.states.State;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Character {

    BufferedImage player_up, player_down, player_left, player_right;

    private ArrayList<String> items;

    public boolean hasAnubis, hasAmulet, hasSword, hasScarab;

    public Player(GameHandler handler, float x, float y){
        super(handler, x, y, Character.DEFAULT_CHAR_WIDTH, DEFAULT_CHAR_HEIGHT);

        bounds.x = 4;
        bounds.y = 4;
        bounds.width = 24;
        bounds.height = 24;

        player_up = AssetManager.player_up;
        player_down = AssetManager.player_down;
        player_left = AssetManager.player_left;
        player_right = AssetManager.player_right;

        items = new ArrayList<>();

        hasAnubis = false;
        hasAmulet = false;
        hasScarab = false;
        hasSword = false;

        hp = DEFAULT_HP;

    }

    public void die(){
        handler.getGame().endState.setWin(false);
        State.setCurrentState(handler.getGame().endState);
    }

    public void update(){
        getInput();
        move();

        if (items != null) {
            checkItems();
        }

        handler.getGameCam().centerOnEnt(this);

        if(hp <= 0){
            die();
        }
    }

    public void render(Graphics g){
        g.drawImage(getPlayerFrame(), (int) (x - handler.getGameCam().getxOff()), (int) (y - handler.getGameCam().getyOff()), width, height, null);
    }

    private BufferedImage getPlayerFrame(){
        if(xMove < 0){
            return player_left;
        }else if(xMove > 0){
            return player_right;
        }else if(yMove < 0){
            return player_up;
        }else{
            return player_down;
        }
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up){
            yMove = -spd;
        }

        if(handler.getKeyManager().down){
            yMove = spd;
        }

        if(handler.getKeyManager().left){
            xMove = -spd;
        }

        if(handler.getKeyManager().right){
            xMove = spd;
        }
    }

    public void addItem(String item){
        items.add(item);
    }

    private void checkItems(){
        for (String item : items) {
            if (item.equals("scarab")) {
                this.hasScarab = true;
            }

            if (item.equals("sword")) {
                this.hasSword = true;
            }

            if (item.equals("anubis")) {
                this.hasAnubis = true;
            }

            if (item.equals("amulet")) {
                this.hasAmulet = true;
            }
        }
    }

    public boolean isHasAnubis() {
        return hasAnubis;
    }

    public boolean isHasAmulet() {
        return hasAmulet;
    }

    public boolean isHasSword() {
        return hasSword;
    }

    public boolean isHasScarab() {
        return hasScarab;
    }
}
