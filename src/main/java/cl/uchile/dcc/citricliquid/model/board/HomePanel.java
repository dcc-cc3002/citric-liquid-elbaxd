package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class HomePanel extends AbstractPanel{

    private final PanelType type;
    private final Set<Panel> nextPanels = new HashSet<>();

    public HomePanel(PanelType type) {
        super(type);
    }

    /**
     * Restores a player's HP in 1.
     */
    private static void applyHealTo(@NotNull Player player) {
            player.setCurrentHp(player.getCurrentHp() + 1);}
    @Override
    public PanelType getType() {
        return null;
    }

    @Override
    public Set<Panel> getNextPanels() {
        return null;
    }

    @Override
    public void addNextPanel(Panel panel) {

    }
}
