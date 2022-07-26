package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class BossPanel extends AbstractPanel{
    /**
     * Creates a new BossPanel.
     *
     * @param type the type of the panel.
     */
    public BossPanel(PanelType type, int number) {
        super(type);
        this.number = number;
    }
    /**
     * In this panel the player battles with a boss unit.
     */
    public void battle(){
        System.out.println("Jaja combate de Wild Unit empezado");
    }

    @Override
    public void normaCheck(@NotNull Player player) {
        
    }

    @Override
    public Player getOwner() {
        return null;
    }
}
