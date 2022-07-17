package cl.uchile.dcc.citricliquid.controller.states;

import cl.uchile.dcc.citricliquid.controller.GameController;
import cl.uchile.dcc.citricliquid.exceptions.InvalidStateOperationException;
import
public class State {
    private Turn turn;

    public void setTurn(Turn turn) {this.turn = turn;}

    protected void changeState(State state) {turn.setState(state);}

    void start(){return;}
    void isKO(){return;}
    void endRecovery(){return;}
    void notKO(){return;}
    void playCard(){return;}
    void move(){return;}
    void path(){return;}
    void backToTrack(){return;}
    void fight(){return;}
    void noFight(){return;}
    void figthing(){return;}
    void DefenseDodge(){return;}
    void decided(){return;}
    void endFigth(){return;}
    void stayPanel(){return;}
    void end(){return;}
    void stayHome(){return;}
    void noHome(){return;}
    void home(){return;}


    public boolean isStart(){return false;}
    public boolean isIsKO(){return false;}
    public boolean isNotKO(){return false;}
    public boolean isPlayCard(){return false;}
    public boolean isMove(){return false;}
    public boolean isFight(){return false;}
    public boolean isFighting(){return false;}
    public boolean isDefenseDodge(){return false;}
    public boolean isPath(){return false;}
    public boolean isStayPanel(){return false;}
    public boolean isEnd(){return false;}
    public boolean isStayHome(){return false;}

}
