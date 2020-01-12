package PyramidPanic.states;

import PyramidPanic.GameHandler;

import java.awt.*;

public abstract class State {

    private static State currentState = null;
    protected GameHandler handler;

    public static void setCurrentState(State state){
        currentState = state;
    }

    public static State getCurrentState(){
        return currentState;
    }

    public State(GameHandler handler){
        this.handler = handler;
    }

    public abstract void update();
    public abstract void render(Graphics g);

    public abstract void setWin(boolean b);
}
