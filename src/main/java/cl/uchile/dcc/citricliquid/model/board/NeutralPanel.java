package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;

import java.util.Set;

public class NeutralPanel extends AbstractPanel{
    protected NeutralPanel(PanelType type) {
        super(type);
    }

    @Override
    public PanelType getType() {
        return type;
    }

    @Override
    public Set<Panel> getNextPanels() {
        return Set.copyOf(nextPanels);
    }

    @Override
    public void addNextPanel(Panel panel) {
        nextPanels.add(panel);

    }
    
}
