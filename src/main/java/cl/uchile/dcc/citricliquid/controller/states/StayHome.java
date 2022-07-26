package cl.uchile.dcc.citricliquid.controller.states;

public class StayHome extends State{
    void noHome(){
        this.changeState(new Move());
    }
    void home(){
        this.changeState(new StayPanel());
    }

    public boolean isStayHome(){return true;}
}
