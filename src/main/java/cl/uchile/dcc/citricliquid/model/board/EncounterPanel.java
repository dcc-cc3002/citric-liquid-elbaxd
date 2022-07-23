package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import org.jetbrains.annotations.NotNull;

public class EncounterPanel extends AbstractPanel{
    /**
     * Creates a new EncounterPanel.
     *
     * @param type the type of the panel.
     */
    public EncounterPanel(PanelType type, int number) {
        super(type);
        this.number = number;
    }
    /**
     * In this panel the player battles with a random wild unit.
     */
    public void battle(){
        System.out.println("Jaja combate de jefe empezado");
    }

    @Override
    public void normaCheck(@NotNull Player player) {

    }

    @Override
    public Player getOwner() {
        return null;
    }
}
