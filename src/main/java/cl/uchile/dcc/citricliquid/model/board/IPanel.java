package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public interface IPanel {

    public PanelType getType();

    public Set<Panel> getNextPanels();

    static void applyHealTo(@NotNull Player player);
    static void applyHealTo(@NotNull Player player);
    static void applyBonusTo(@NotNull Player player);

    public void addNextPanel(Panel panel);

    public void activatedBy(Player player);
}
