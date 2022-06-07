package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class EncounterPanel extends AbstractPanel{
    private final PanelType type;
    private final Set<Panel> nextPanels = new HashSet<>();
    protected EncounterPanel(PanelType type) {
        super(type);
        this.type = type;
    }
    /**
     * In this panel the player battles with a random wild unit.
     */
    public void battle(){
        System.out.println("Jaja combate de jefe empezado");
    }
}
