package cl.uchile.dcc.citricliquid.model.board;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractPanel implements IPanel {
    protected PanelType type;
    protected Set<Panel> nextPanels = new HashSet<>();

    protected AbstractPanel(PanelType type) {
        this.type = type;
    }
}
