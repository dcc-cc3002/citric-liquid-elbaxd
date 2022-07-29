package cl.uchile.dcc.citricliquid.controller.states;

public class End extends State{
    /**
     * In this state, the turn ends for the current player, and it starts
     * the turn of the next player.
     */

    void start(){
        this.changeState(new Start());
    }

    public boolean isEnd(){return true;}
}
