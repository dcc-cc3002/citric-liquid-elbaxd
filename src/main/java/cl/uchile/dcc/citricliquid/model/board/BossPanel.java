package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;

import java.util.HashSet;
import java.util.Set;

public class BossPanel extends AbstractPanel{
    protected BossPanel(PanelType type) {
        super(type);
    }
    /**
     * In this panel the player battles with a boss unit.
     */
    public void battle(){
        System.out.println("Jaja combate de Wild Unit empezado");
    }
}
