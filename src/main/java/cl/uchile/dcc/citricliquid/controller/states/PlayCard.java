package cl.uchile.dcc.citricliquid.controller.states;

public class PlayCard extends State{

    void move(){this.changeState(new Move());}

    public boolean isPlayCard() {return true;}
}
