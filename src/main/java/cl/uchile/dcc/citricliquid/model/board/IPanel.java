package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public interface IPanel {

    int getNumber();

    PanelType getType();

    Set<AbstractPanel> getNextPanels();

    void addNextPanel(AbstractPanel panel);

    Set<Player> getPlayersOnPanel();

    void addPlayerOnPanel(Player player);

    void removePlayerOnPanel(Player player);

    void activatedBy(@NotNull Player player);


}
