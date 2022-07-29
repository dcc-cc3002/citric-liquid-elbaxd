package cl.uchile.dcc.citricliquid.controller.states;

public class Move extends State{

    /**
     * In this state, the player moves in the board.
     */

    void fight(){this.changeState(new Fight());}
    void path(){this.changeState(new Path());}
    void stayPanel(){
        this.changeState(new StayPanel());
    }
    void stayHome(){this.changeState(new StayHome());}

    public boolean isMove() {return true;}
}
