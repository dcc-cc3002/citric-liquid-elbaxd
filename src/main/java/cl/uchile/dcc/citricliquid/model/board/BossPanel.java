package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;

import java.util.HashSet;
import java.util.Set;

public class BossPanel extends AbstractPanel{
    private final PanelType type;
    private final Set<Panel> nextPanels = new HashSet<>();
    protected BossPanel(PanelType type) {
        super(type);
        this.type=type;
    }
    /**
     * In this panel the player battles with a boss unit.
     */
    public void battle(){
        System.out.println("Jaja combate de Wild Unit empezado");
    }
}
