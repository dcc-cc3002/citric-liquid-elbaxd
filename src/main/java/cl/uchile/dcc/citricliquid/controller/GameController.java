package cl.uchile.dcc.citricliquid.controller;

import cl.uchile.dcc.citricliquid.controller.states.Turn;
import cl.uchile.dcc.citricliquid.model.Characters.BossUnit;
import cl.uchile.dcc.citricliquid.model.Characters.Player;
import cl.uchile.dcc.citricliquid.model.Characters.WildUnit;
import cl.uchile.dcc.citricliquid.model.board.*;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private Player player;
    List<AbstractPanel> allPanels = new ArrayList<>();
    List<Player> allPlayers = new ArrayList<>();
    int turno = 1;
    int chapter = 1;
    Turn turn = new Turn();

    /**
     * Creates a BonusPanel adding this new panel to the set of all panels
     * and returns the panel
     * @param number is the number of the panel in the list of all panels
     */

    public BonusPanel createBonusPanel(int number){
        BonusPanel panel = new BonusPanel(PanelType.BONUS,number);
        allPanels.add(panel);
        return panel;
    }

    /**
     * Creates a BossPanel adding this new panel to the set of all
     * and returns the panel
     * @param number is the number of the panel in the list of all panels
     */

    public BossPanel createBossPanel(int number){
        BossPanel panel = new BossPanel(PanelType.BOSS, number);
        allPanels.add(panel);
        return panel;
    }

    /**
     * Creates a DropPanel adding this new panel to the set of all panels
     * and returns the panel
     * @param number is the number of the panel in the list of all panels
     */

    public DropPanel createDropPanel(int number){
        DropPanel panel = new DropPanel(PanelType.DROP,number);
        allPanels.add(panel);
        return panel;
    }

    /**
     * Creates a EncounterPanel adding this new panel to the set of all panels
     * and returns the panel
     * @param number is the number of the panel in the list of all panels
     */

    public EncounterPanel createEncounterPanel(int number){
        EncounterPanel panel = new EncounterPanel(PanelType.ENCOUNTER, number);
        allPanels.add(panel);
        return panel;
    }

    /**
     * Creates a HomePanel adding this new panel to the set of all panels
     * and returns the panel
     * @param number is the number of the panel in the list of all panels
     */

    public HomePanel createHomePanel(int number){
        HomePanel panel = new HomePanel(PanelType.HOME,number);
        allPanels.add(panel);
        return panel;
    }

    /**
     * Creates a NeutralPanel adding this new panel to the set of all panels
     * and returns the panel
     * @param number is the number of the panel in the list of all panels
     */

    public NeutralPanel createNeutralPanel(int number){
        NeutralPanel panel = new NeutralPanel(PanelType.NEUTRAL,number);
        allPanels.add(panel);
        return panel;
    }

    /**
     * Creates a DrawPanel adding this new panel to the set of all panels
     * and returns the panel
     * @param number is the number of the panel in the list of all panels
     */

    public DrawPanel createDrawPanel(int number){
        DrawPanel panel = new DrawPanel(PanelType.DRAW,number);
        allPanels.add(panel);
        return panel;
    }

    /**
     * * Creates a new player and adds him to the list of
     * * all players, and places it on a specific panel and
     * * returns the created player
     * @param name
     *    is the name of the player that is going to be created
     * @param hp
     *    is the amount that is going to be the hit points of the player that is going to be created
     * @param atk
     *    is the amount of the attack of the player that is going to be created
     * @param def
     *    is the amount of the defense of the player that is going to be created
     * @param evd
     *    is the amount of the evasion of the player that is going to be created
     * @param panel
     *    is the panel where the created player is going to start
     */

    public Player createPlayer(String name,int hp,int atk,int def,int evd,AbstractPanel panel){
        Player player = new Player(name,hp,atk,def,evd);
        panel.addPlayerOnPanel(player);
        allPlayers.add(player);
        return player;
    }

    /**
     * * Creates a new wild unit
     * @param name
     *    is the name of the wild unit that is going to be created
     * @param hp
     *    is the amount that is going to be the hit points of the wild unit that is going to be created
     * @param atk
     *    is the amount of the attack of the wild unit that is going to be created
     * @param def
     *    is the amount of the defense of the wild unit that is going to be created
     * @param evd
     *    is the amount of the evasion of the wild unit that is going to be created
     * @return
     *    is the created wild unit
     */

    public WildUnit createWildUnit(String name,int hp,int atk,int def,int evd){
        WildUnit wildunit = new WildUnit(name,hp,atk,def,evd);
        return wildunit;
    }

    /**
     * * Creates a new boss unit
     * @param name
     *    is the name of the player that is going to be created
     * @param hp
     *    is the amount that is going to be the hit points of the player that is going to be created
     * @param atk
     *    is the amount of the attack of the player that is going to be created
     * @param def
     *    is the amount of the defense of the player that is going to be created
     * @param evd
     *    is the amount of the evasion of the player that is going to be created
     * @return
     *    is the created boss unit
     */

    public BossUnit createBossUnit(String name,int hp,int atk,int def,int evd){
        BossUnit bossunit= new BossUnit(name,hp,atk,def,evd);
        return bossunit;
    }

    /**
     * A panel is add as a next panel of on other panel
     * @param actualPanel the panel that will have a next panel
     * @param nextPanel the panel that is add next
     */

    public void setNextPanel(AbstractPanel actualPanel, AbstractPanel nextPanel){actualPanel.addNextPanel(nextPanel);}

    /**
     * set a player as a owner of a home panel
     * @param player the panel that will have a next panel
     * @param homepanel the panel that is add next
     */

    public void setPlayerHome(Player player, HomePanel homepanel){homepanel.setOwner(player);}

    /**
     * Returns the Set of all the panels created at this moment
     */

    public List<AbstractPanel> getAllPanels(){return allPanels;}

    /**
     * Returns the player's who turn is it now
     * and if it is the first turn, the turn is set
     * to the first player created
     */

    public Player getTurnOwner(){
        getChapter();
        Player player = allPlayers.get(turno-1-(4*(chapter-1)));
        if(turno == 1){
            player.setMyTurn(true);
        }
        return player;
    }

    public int getChapter() {
        chapter =((turno-1)/4)+1;
        return chapter;
    }

    /**
     * Returns the current chapter
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
