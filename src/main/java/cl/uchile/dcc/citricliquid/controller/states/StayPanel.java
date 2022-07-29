package cl.uchile.dcc.citricliquid.controller.states;

public class StayPanel extends State{
    /**
     * In this state, is a terminal state where the action that took place it ends.
     */
    void end(){
        this.changeState(new End());
    }

    public boolean isStayPanel() {return true;}
}
