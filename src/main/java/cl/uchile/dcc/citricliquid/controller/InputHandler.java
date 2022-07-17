package cl.uchile.dcc.citricliquid.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class InputHandler implements PropertyChangeListener {
    private final GameController gameController;

    public InputHandler(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof Boolean) {
            boolean flag = (boolean) evt.getNewValue();
            if (flag) {
                gameController.runContextAction();
            } else {
                gameController.promptCharacterSelection();
            }
        }
    }
}
