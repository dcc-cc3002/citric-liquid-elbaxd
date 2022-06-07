package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;

import java.util.HashSet;
import java.util.Set;

public class NeutralPanel extends AbstractPanel{
    private final PanelType type;
    private final Set<Panel> nextPanels = new HashSet<>();
    public NeutralPanel(PanelType type) {
        super(type);
        this.type = type;
    }
    /**
     * This panel does nothing and ends the turn of the player without any changes.
     */

}
