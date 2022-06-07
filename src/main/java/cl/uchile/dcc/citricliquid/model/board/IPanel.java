package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public interface IPanel {

    PanelType getType();

    Set<Panel> getNextPanels();

    void addNextPanel(Panel panel);

    void activatedBy(@NotNull Player player);
}
