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
    static void applyBonusTo(final @NotNull Player player) {
        player.increaseStarsBy(player.roll() * Math.min(player.getNormaLevel(), 3));
    }

}
