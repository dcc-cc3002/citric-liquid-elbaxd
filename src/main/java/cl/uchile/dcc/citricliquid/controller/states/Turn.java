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

}
