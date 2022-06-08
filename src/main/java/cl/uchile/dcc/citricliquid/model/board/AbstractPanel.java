package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractPanel implements IPanel {
    protected PanelType type;
    protected Set<Panel> nextPanels = new HashSet<>();
    protected Set<Player> playersOnPanel = new HashSet<>();

    protected AbstractPanel(final PanelType type) {
        this.type = type;
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

    /**
     * Returns a copy of the players on the panel.
     */
    @Override
    public Set<Player> getPlayersOnPanel() {
        return Set.copyOf(playersOnPanel);
    }

    /**
     * Adds a new player to the list of players on the panel.
     *
     * @param player the player to be added.
     */
    @Override
    public void addPlayerOnPanel(Player player) {
        playersOnPanel.add(player);
    }

    /**
     * Executes the appropriate action to the player according to this panel's type.
     */
    @Override
    public void activatedBy(@NotNull Player player) {
        switch (type) {
            case BONUS -> BonusPanel.applyBonusTo(player);
            case DROP -> DropPanel.applyDropTo(player);
            case HOME -> HomePanel.applyHealTo(player);
            default -> {
            }
        }
    }
}
