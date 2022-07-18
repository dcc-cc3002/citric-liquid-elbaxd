package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class DropPanel extends AbstractPanel{
    /**
     * Creates a new DropPanel.
     *
     * @param type the type of the panel.
     */
    public DropPanel(PanelType type, int number) {
        super(type);
        this.number = number;
    }

    /**
     * Reduces the player's star count by the D6 roll multiplied by the player's norma level.
     */
    static void applyDropTo(final @NotNull Player player) {
        player.reduceStarsBy(player.roll() * player.getNormaLevel());
    }


}
