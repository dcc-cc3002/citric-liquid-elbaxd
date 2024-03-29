package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class DrawPanel extends AbstractPanel{
    /**
     * Creates a new DrawPanel.
     *
     * @param type the type of the panel.
     */
    public DrawPanel(PanelType type, int number) {
        super(type);
        this.number = number;
    }
    /**
     * In this panel the player draw a card.
     */
    public void draw(){
        System.out.println("El jugador que acaba de caer en este panel roba 1 carta");
    }

    @Override
    public void normaCheck(@NotNull Player player) {
        
    }

    @Override
    public Player getOwner() {
        return null;
    }
}
