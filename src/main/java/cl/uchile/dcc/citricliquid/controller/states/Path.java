package cl.uchile.dcc.citricliquid.controller.states;

public class Path extends State{
    /**
     * In this state, the player decided what panel go next, in the case if there is more than one.
     */

    void backToTrack(){
        this.changeState(new Move());
    }

    public boolean isPath(){return true;}
}
