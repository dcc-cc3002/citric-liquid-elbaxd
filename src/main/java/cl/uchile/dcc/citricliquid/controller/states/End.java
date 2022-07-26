package cl.uchile.dcc.citricliquid.controller.states;

public class End extends State{

    void start(){
        this.changeState(new Start());
    }

    public boolean isEnd(){return true;}
}
