package cl.uchile.dcc.citricliquid.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class InputHandler implements PropertyChangeListener {
    private final Controller controller;

    public InputHandler(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof Boolean) {
            boolean flag = (boolean) evt.getNewValue();
            if (flag) {
                controller.runContextAction();
            } else {
                controller.promptCharacterSelection();
            }
        }
    }
}
