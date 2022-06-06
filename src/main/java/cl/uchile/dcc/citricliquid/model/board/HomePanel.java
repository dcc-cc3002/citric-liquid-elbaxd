package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class HomePanel extends AbstractPanel{

    private final PanelType type;
    private final Set<Panel> nextPanels = new HashSet<>();
    private final Player Owner;

    public HomePanel(PanelType type,Player player) {
        super(type);
        this.Owner = player;
        this.type = type;
    }

    public Player getOwner() {
        return Owner;
    }
    /**
     * Checks if the player owns this home panel.
     */
    public boolean ownerCheck(Player player){
        return player == Owner;
    }
    /**
     * Checks if the player accomplish with the requirements to go up 1 level of Norma.
     */
    public void normaCheck(@NotNull Player player){
        int normaLevel = player.getNormaLevel();
        if (normaLevel == 1 ){
            if (player.getStars() >= 10){
                player.normaClear();
            }
        }
        if(normaLevel == 2){
            if (player.getStars() >= 30 && player.getWins() >= 2){
                player.normaClear();
            }
        }
        if(normaLevel == 3){
            if (player.getStars() >= 70 && player.getWins() >= 5){
                player.normaClear();
            }
        }
        if(normaLevel == 4){
            if (player.getStars() >= 120 && player.getWins() >= 9){
                player.normaClear();
            }
        }
        if(normaLevel == 6){
            if (player.getStars() >= 200 && player.getWins() >= 14){
                player.normaClear();
            }
        }
    }
    /**
     * Restores a player's HP in 1.
     */
    private static void applyHealTo(@NotNull Player player) {
            player.setCurrentHp(player.getCurrentHp() + 1);
    }

    /**
     * Returns the type of this panel.
     */
    @Override
    public PanelType getType() {
        return type;
    }

    /**
     * Returns a copy of this panel's next ones.
     */
    @Override
    public Set<Panel> getNextPanels() {
        return Set.copyOf(nextPanels);
    }

    /**
     * Adds a new adjacent panel to this one.
     *
     * @param panel the panel to be added.
     */
    @Override
    public void addNextPanel(Panel panel) {
        nextPanels.add(panel);
    }

    @Override
    public void activatedBy(Player player) {
        switch (type) {
            case HOME -> applyHealTo(player);
            default -> {
            }
        }
    }
}
