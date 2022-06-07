package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;

import java.util.HashSet;
import java.util.Set;

public class NeutralPanel extends AbstractPanel{
    public NeutralPanel(PanelType type) {
        super(type);
    }
    /**
     * This panel does nothing and ends the turn of the player without any changes.
     */
    public void nothing(){
        System.out.println("Literal no hace nada este panel");
    }
}
