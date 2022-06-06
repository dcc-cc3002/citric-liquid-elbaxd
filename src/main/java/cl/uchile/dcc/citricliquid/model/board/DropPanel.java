package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class DropPanel extends AbstractPanel{
    private final PanelType type;
    private final Set<Panel> nextPanels = new HashSet<>();
    public DropPanel(PanelType type) {
        super(type);
        this.type = type;
    }

    /**
     * Reduces the player's star count by the D6 roll multiplied by the player's norma level.
     */
    private static void applyDropTo(final @NotNull Player player) {
        player.reduceStarsBy(player.roll() * player.getNormaLevel());
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
