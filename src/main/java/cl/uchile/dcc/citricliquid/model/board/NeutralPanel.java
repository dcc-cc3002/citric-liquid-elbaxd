package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class NeutralPanel extends AbstractPanel{
    /**
     * Creates a new NeutralPanel.
     *
     * @param type the type of the panel.
     */
    public NeutralPanel(PanelType type, int number) {
        super(type);
        this.number = number;
    }
    /**
     * This panel does nothing and ends the Turn of the player without any changes.
     */
    public void nothing(){
        System.out.println("Literal no hace nada este panel");
    }

    @Override
    public void normaCheck(@NotNull Player player) {

    }

    @Override
    public Player getOwner() {
        return null;
    }
}
