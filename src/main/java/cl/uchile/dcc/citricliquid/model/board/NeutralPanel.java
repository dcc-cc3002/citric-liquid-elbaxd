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
    @Override
    public PanelType getType() {
        return type;
    }

    /**
     * Returns a copy of this panel's next ones.
     */
    @Override
    public Set<Panel> getNextPanels() {
        return Set.copyOf(nextPanels);
    }

    /**
     * Adds a new adjacent panel to this one.
     *
     * @param panel the panel to be added.
     */
    @Override
    public void addNextPanel(Panel panel) {
        nextPanels.add(panel);

    }

    @Override
    public void activatedBy(Player player) {

    }

}
