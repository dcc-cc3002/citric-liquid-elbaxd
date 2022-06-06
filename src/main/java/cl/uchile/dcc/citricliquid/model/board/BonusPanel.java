package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class BonusPanel extends AbstractPanel{

    protected BonusPanel(PanelType type) {
        super(type);
        this.type = type;
    }

    /**
     * Reduces the player's star count by the D6 roll multiplied by the maximum between the player's
     * norma level and three.
     */
    private static void applyBonusTo(final @NotNull Player player) {
        player.increaseStarsBy(player.roll() * Math.min(player.getNormaLevel(), 3));
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
