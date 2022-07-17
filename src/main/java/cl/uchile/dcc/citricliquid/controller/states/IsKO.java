package cl.uchile.dcc.citricliquid.controller.states;

public class IsKO extends State{

    void endRecovery(){this.changeState(new End());}

    public boolean isIsKO(){return true;}
}
