package cl.uchile.dcc.citricliquid.controller;

import cl.uchile.dcc.citricliquid.controller.states.State;
import cl.uchile.dcc.citricliquid.controller.states.Turn;
import cl.uchile.dcc.citricliquid.exceptions.InvalidStateOperationException;
import cl.uchile.dcc.citricliquid.model.Characters.AbstractCharacter;
import cl.uchile.dcc.citricliquid.model.Characters.BossUnit;
import cl.uchile.dcc.citricliquid.model.Characters.Player;
import cl.uchile.dcc.citricliquid.model.Characters.WildUnit;
import cl.uchile.dcc.citricliquid.model.board.AbstractPanel;
import cl.uchile.dcc.citricliquid.model.board.BonusPanel;
import cl.uchile.dcc.citricliquid.model.board.IPanel;
import cl.uchile.dcc.citricliquid.model.board.PanelType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {

    List<AbstractPanel> allPanels = new ArrayList<>();
    List<Player> allPlayers = new ArrayList<>();
    int turno = 1;
    int chapter = 1;
    Turn turn = new Turn();

    /**
     * Creates a BonusPanel adding this new panel to the set of all panels
     */

    public BonusPanel createBonusPanel(){
        BonusPanel panel = new BonusPanel(PanelType.BONUS);
        allPanels.add(panel);
        return panel;
    }

    /**
     * Creates a BossPanel adding this new panel to the set of all panels
     */



    private final List<WildUnit> WildUnits =
            List.of(new WildUnit("Chicken",3,-1,-1,1),
                    new WildUnit("Robo Ball",3,-1,1,-1),
                    new WildUnit("Seagull",3,1,-1,-1));

    private final List<BossUnit> BossUnits =
            List.of(new BossUnit("Store Manager",8,+3,+2,-1),
                    new BossUnit("Shifu Robot",7,+2,+3,-2),
                    new BossUnit("Flying Castle",10,+2,+1,-3));


}
