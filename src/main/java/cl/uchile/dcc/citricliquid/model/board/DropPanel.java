package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class DropPanel extends AbstractPanel{
    protected DropPanel(PanelType type) {
        super(type);
    }

    /**
     * Reduces the player's star count by the D6 roll multiplied by the player's norma level.
     */
    private static void applyDropTo(final @NotNull Player player) {
        player.reduceStarsBy(player.roll() * player.getNormaLevel());
    }

    @Override
    public PanelType getType() {
        return type;
    }

    @Override
    public Set<Panel> getNextPanels() {
        return null;
    }

    @Override
    public void addNextPanel(Panel panel) {

    }

    @Override
    public void activatedBy(Player player) {

    }
}
