package PyramidPanic.util;

import PyramidPanic.GameHandler;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UIManager {

    private GameHandler handler;
    private ArrayList<UIObject> objs;

    public UIManager(GameHandler handler){
        this.handler = handler;
        objs = new ArrayList<>();
    }

    public void update(){
        for(UIObject i : objs){
            i.update();
        }
    }

    public void render(Graphics g){
        for(UIObject i : objs){
            i.render(g);
        }
    }

    public void onMouseMove(MouseEvent event){
        for(UIObject i : objs){
            i.onMouseMove(event);
        }
    }

    public void onMouseRelease(MouseEvent event){
        for(UIObject i : objs){
            i.onMouseRelease(event);
        }
    }

    public GameHandler getHandler() {
        return handler;
    }

    public void setHandler(GameHandler handler) {
        this.handler = handler;
    }

    public ArrayList<UIObject> getObjs() {
        return objs;
    }

    public void setObjs(ArrayList<UIObject> objs) {
        this.objs = objs;
    }

    public void addObj(UIObject i){
        objs.add(i);
    }

    public void removeObj(UIObject i){
        objs.remove(i);
    }
}
