package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public interface IPanel {

    int getNumber();

    PanelType getType();

    Set<Panel> getNextPanels();

    void addNextPanel(Panel panel);

    Set<Player> getPlayersOnPanel();

    void addPlayerOnPanel(Player player);

    void activatedBy(@NotNull Player player);
}
