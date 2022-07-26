package cl.uchile.dcc.citricliquid.controller.states;

public class Fighting extends State{

    void DefenseDodge(){this.changeState(new DefenseDodge());}
    void endFight(){this.changeState(new StayPanel());}


    public boolean isFighting() {return true;}
}
