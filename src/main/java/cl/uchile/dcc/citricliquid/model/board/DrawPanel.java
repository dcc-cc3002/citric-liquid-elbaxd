package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;

import java.util.Set;

public class DrawPanel extends AbstractPanel{
    protected DrawPanel(PanelType type) {
        super(type);
    }
    public void draw(){
        System.out.println("El jugador que acaba de caer en este panel roba 1 carta");
    }
}
