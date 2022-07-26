package cl.uchile.dcc.citricliquid.controller.states;

public class DefenseDodge extends State{

    void decided() {
        this.changeState(new Fighting());
    }

    public boolean isDefenseDodge(){return true;}
}
