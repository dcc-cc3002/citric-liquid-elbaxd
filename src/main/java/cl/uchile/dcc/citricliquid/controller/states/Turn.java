package cl.uchile.dcc.citricliquid.controller.states;

public class Turn {
    private State state;

    public Turn(){this.setState(new Start());}

    void setState(State state1) {
        state = state1;
        state.setTurn(this);
    }

    public void start(){state.start();}
    public void isKO(){state.isKO();}
    public void endRecovery(){state.endRecovery();}
    public void notKO(){state.notKO();}
    public void playCard(){state.playCard();}
    public void move(){state.move();}
    public void path(){state.path();}
    public void backToTrack(){state.backToTrack();}
    public void fight(){state.fight();}
    public void noFight(){state.noFight();}
    public void figthing(){state.figthing();}
    public void DefenseDodge(){state.DefenseDodge();}
    public void decided(){state.decided();}
    public void endFigth(){state.endFigth();}
    public void stayPanel(){state.stayPanel();}
    public void end(){state.end();}
    public void stayHome(){state.stayHome();}
    public void noHome(){state.noHome();}
    public void home(){state.home();}


    public boolean isStart(){return state.isStart();}
    public boolean isIsKO(){return state.isIsKO();}
    public boolean isNotKO(){return state.isNotKO();}
    public boolean isPlayCard(){return state.isPlayCard();}
    public boolean isMove(){return state.isMove();}
    public boolean isFight(){return state.isFight();}
    public boolean isFighting(){return state.isFighting();}
    public boolean isDefenseDodge(){return state.isDefenseDodge();}
    public boolean isPath(){return state.isPath();}
    public boolean isStayPanel(){return state.isStayPanel();}
    public boolean isEnd(){return state.isEnd();}
    public boolean isStayHome(){return state.isStayHome();}

}
