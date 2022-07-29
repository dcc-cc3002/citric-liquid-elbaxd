package cl.uchile.dcc.citricliquid.controller.states;

public class PlayCard extends State{
    /**
     * In this state, the player decided if he will play a card or not.
     */

    void move(){this.changeState(new Move());}

    public boolean isPlayCard() {return true;}
}
