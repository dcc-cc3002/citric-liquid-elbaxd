package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class BonusPanel extends AbstractPanel{

    protected BonusPanel(PanelType type) {
        super(type);
    }

    /**
     * Reduces the player's star count by the D6 roll multiplied by the maximum between the player's
     * norma level and three.
     */
    private static void applyBonusTo(final @NotNull Player player) {
        player.increaseStarsBy(player.roll() * Math.min(player.getNormaLevel(), 3));
    }

    @Override
    public PanelType getType() {
        return null;
    }

    @Override
    public Set<Panel> getNextPanels() {
        return Set.copyOf(nextPanels);
    }

    @Override
    public void addNextPanel(Panel panel) {
        nextPanels.add(panel);
    }

}
