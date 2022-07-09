package cl.uchile.dcc.citricliquid;

import cl.uchile.dcc.citricliquid.controller.InputHandler;

import java.beans.PropertyChangeSupport;

public class InputManager {
    private final PropertyChangeSupport inputPromptNotification = new PropertyChangeSupport(this);

    public void addInputPromptListener(InputHandler listener) {
        inputPromptNotification.addPropertyChangeListener(listener);
    }

    public void promptForInput() {
        inputPromptNotification.firePropertyChange("promptForInput", null, false);
    }

    public void processInput() {
        inputPromptNotification.firePropertyChange("processInput", null, true);
    }
}
