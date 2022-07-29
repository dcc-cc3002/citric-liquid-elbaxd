package cl.uchile.dcc.citricliquid.controller.states;

public class Fight extends State{
    /**
     * In this state, the player decide if he wants to fight against other
     * player that it is in the same panel that him.
     */

    void noFight(){
        this.changeState(new Move());
    }

    void fighting(){this.changeState(new Fighting());}


    public boolean isFight() {return true;}
}
