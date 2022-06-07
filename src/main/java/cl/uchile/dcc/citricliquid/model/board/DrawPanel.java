package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;

import java.util.Set;

public class DrawPanel extends AbstractPanel{
    protected DrawPanel(PanelType type, Set<Panel> nextPanels) {
        super(type, nextPanels);
    }
}
