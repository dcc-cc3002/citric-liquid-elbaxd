package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class BonusPanel extends AbstractPanel{

    /**
     * Creates a new BonusPanel.
     *
     * @param type the type of the panel.
     */
    public BonusPanel(PanelType type, int number) {
        super(type);
        this.number = number;
    }

    /**
     * Increases the player's star count by the D6 roll multiplied by the minimum between the player's
     * norma level and three.
     */
    static void applyBonusTo(final @NotNull Player player) {
        player.increaseStarsBy(player.roll() * Math.min(player.getNormaLevel(), 3));
    }

}
