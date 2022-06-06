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
    public String battle(){
        System.out.println("Jaja combate de Wild Unit empezado");
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

    }
}
