package cl.uchile.dcc.citricliquid.controller.states;

public class StayPanel extends State{
    void end(){
        this.changeState(new End());
    }

    public boolean isStayPanel() {return true;}
}
