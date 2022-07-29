package cl.uchile.dcc.citricliquid.controller.states;

public class IsKO extends State{
    /**
     * In this state, it checks if the player has 0 Hp and if it does, it starts the recovery phase.
     */

    void endRecovery(){this.changeState(new End());}

    public boolean isIsKO(){return true;}
}
