package cl.uchile.dcc.citricliquid.controller.states;

public class Fight extends State{

    void noFight(){
        this.changeState(new Move());
    }

    void fighting(){this.changeState(new Fighting());}


    public boolean isFight() {return true;}
}
