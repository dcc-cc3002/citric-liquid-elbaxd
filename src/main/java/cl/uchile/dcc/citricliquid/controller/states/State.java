package cl.uchile.dcc.citricliquid.controller.states;

import cl.uchile.dcc.citricliquid.controller.Controller;
import cl.uchile.dcc.citricliquid.exceptions.InvalidStateOperationException;
import
public class State {
    protected final Controller context;

    public State(Controller context) {
        this.context = context;
    }

    public void toSelectCharacterState() throws InvalidStateOperationException {
        throw new InvalidStateOperationException();
    }

    public void toIdleState() throws InvalidStateOperationException {
        throw new InvalidStateOperationException();
    }

    public void toAttackingState() throws InvalidStateOperationException {
        throw new InvalidStateOperationException();
    }

    public void runAction() throws InvalidStateOperationException {
    }
}
