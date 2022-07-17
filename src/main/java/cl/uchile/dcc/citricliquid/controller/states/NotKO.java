package cl.uchile.dcc.citricliquid.controller.states;

public class NotKO extends State{

    void playCard(){
        this.changeState(new PlayCard());
    }


    public boolean isNotKO() {return true;}
}
