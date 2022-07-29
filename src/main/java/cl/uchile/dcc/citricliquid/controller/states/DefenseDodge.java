package cl.uchile.dcc.citricliquid.controller.states;

public class DefenseDodge extends State{
    /**
     * In this state, the player decided if he will defense or dodge the attack during the fight
     */

    void decided() {
        this.changeState(new Fighting());
    }

    public boolean isDefenseDodge(){return true;}
}
