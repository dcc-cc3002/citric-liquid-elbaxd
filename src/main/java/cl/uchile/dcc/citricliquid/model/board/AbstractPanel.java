package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractPanel implements IPanel {
    protected PanelType type;
    protected Set<Panel> nextPanels;
    protected Set<Player> playersOnPanel;

    protected AbstractPanel(PanelType type, Set<Panel> nextPanels,Set<Player> playersOnPanel) {
        this.type = type;
        this.nextPanels = nextPanels;
        this.playersOnPanel = playersOnPanel;
    }

    /**
     * Returns the type of this panel.
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
