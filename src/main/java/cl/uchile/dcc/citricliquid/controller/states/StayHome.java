package cl.uchile.dcc.citricliquid.controller.states;

public class StayHome extends State{
    /**
     * In this state, if the player is in his home panel, can decide if stay in it or
     * continue with the movement.
     */
    void noHome(){
        this.changeState(new Move());
    }
    void home(){
        this.changeState(new StayPanel());
    }

    public boolean isStayHome(){return true;}
}
