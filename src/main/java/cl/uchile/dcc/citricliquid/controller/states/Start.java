package cl.uchile.dcc.citricliquid.controller.states;

public class Start extends State {

    void isKO() {this.changeState(new IsKO());}

    void notKO() {this.changeState(new NotKO());}

    public boolean isStart(){return true;}
}
