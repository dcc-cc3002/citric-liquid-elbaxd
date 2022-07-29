package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import org.jetbrains.annotations.NotNull;

public class HomePanel extends AbstractPanel{
    private Player Owner;

    /**
     * Creates a new HomePanel.
     *
     * @param type the type of the panel.
     *
     * @param number the number of the panel in the board.
     */
    public HomePanel(PanelType type,int number) {
        super(type);
        this.number = number;
        this.Owner = null;
    }

    /**
     * Set the new player who owns this HomePanel.
     */
    public void setOwner(Player player2){this.Owner = player2;}
    /**
     * Returns the player who owns this HomePanel.
     */
    public Player getOwner() {
        return this.Owner;
    }
    /**
     * Checks if the player owns this home panel.
     */
    public boolean ownerCheck(@NotNull Player player){
        return player == this.Owner;
    }
    /**
     * Checks if the player accomplish with the requirements to go up 1 level of Norma.
     */
    public void normaCheck(@NotNull Player player){
        if (player.getNormaLevel() == 1 ) {
            if (player.getStars() >= 10 || player.getWins() >= 2) {
                player.normaClear();
            }
        }
        if(player.getNormaLevel() == 2){
            if (player.getStars() >= 30 || player.getWins() >= 2){
                player.normaClear();
            }
        }
        if(player.getNormaLevel() == 3){
            if (player.getStars() >= 70 || player.getWins() >= 5){
                player.normaClear();
            }
        }
        if(player.getNormaLevel() == 4){
            if (player.getStars() >= 120 || player.getWins() >= 9){
                player.normaClear();
            }
        }
        if(player.getNormaLevel() == 5){
            if (player.getStars() >= 200 || player.getWins() >= 14){
                player.normaClear();
            }
        }
    }
    /**
     * Restores a player's HP in 1.
     */
    static void applyHealTo(@NotNull Player player) {
            player.setCurrentHp(player.getCurrentHp() + 1);
    }
}
