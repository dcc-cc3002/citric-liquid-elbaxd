package cl.uchile.dcc.citricliquid.controller.states;

public class NotKO extends State{
    /**
     * In this state, it checks that the player has more than 0 Hp and the player can go
     * to the state where can play a card.
     */

    void playCard(){
        this.changeState(new PlayCard());
    }


    public boolean isNotKO() {return true;}
}
