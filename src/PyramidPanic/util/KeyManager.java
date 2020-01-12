package PyramidPanic.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyManager implements KeyListener {

    private boolean[] keys, pressed, locked;
    public boolean up, down, left, right;

    public KeyManager(){
        keys = new boolean[256];
        pressed = new boolean[keys.length];
        locked = new boolean[keys.length];

    }

    public void update(){
        for(int i = 0; i < keys.length; i++){
            if(locked[i] && !keys[i]){
                locked[i] = false;
            }else if(pressed[i]){
                locked[i] = true;
                pressed[i] = false;
            }

            if(!locked[i] && keys[i]){
                pressed[i] = true;
            }
        }

        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() < 0 || keyEvent.getKeyCode() >= keys.length){
            return;
        }

        keys[keyEvent.getKeyCode()] = true;
        /*test*/
        //System.out.print("key");
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() < 0 || keyEvent.getKeyCode() >= keys.length){
            return;
        }

        keys[keyEvent.getKeyCode()] = false;
        /*test*/
        //System.out.print("key");
    }

    public boolean keyPressedNow(int code){
        if(code < 0 || code >= keys.length){
            return false;
        }

        return pressed[code];
    }
}
