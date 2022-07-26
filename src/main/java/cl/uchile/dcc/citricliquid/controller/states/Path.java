package cl.uchile.dcc.citricliquid.controller.states;

public class Path extends State{

    void backToTrack(){
        this.changeState(new Move());
    }

    public boolean isPath(){return true;}
}
