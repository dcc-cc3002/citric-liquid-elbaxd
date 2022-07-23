package cl.uchile.dcc.citricliquid.controller;

import cl.uchile.dcc.citricliquid.controller.states.Turn;
import cl.uchile.dcc.citricliquid.model.Characters.BossUnit;
import cl.uchile.dcc.citricliquid.model.Characters.Player;
import cl.uchile.dcc.citricliquid.model.Characters.WildUnit;
import cl.uchile.dcc.citricliquid.model.NormaGoal;
import cl.uchile.dcc.citricliquid.model.board.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GameController {
    private Player player;
    public List<AbstractPanel> allPanels = new ArrayList<>();
    public List<Player> allPlayers = new ArrayList<>();
    public int turno = 1;
    public int chapter = 1;
    public Turn turn = new Turn();

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
     * A panel ,or more than one, is add as a next panel of on other panel
     * @param actualPanel the panel that will have a next panel
     * @param nextPanels the panel or panels that is adding next
     */

    public void setNextPanel(AbstractPanel actualPanel, AbstractPanel nextPanel){
        actualPanel.addNextPanel(nextPanel);
        }

    /**
     * set a player as a owner of a home panel
     * @param player the player that will have a Home panel
     * @param homepanel the Home panel that will have player as owner
     */

    public void setPlayerHome(Player player, HomePanel homepanel){homepanel.setOwner(player);}

    /**
     * Returns the Set of all the panels created at this moment
     */

    public List<AbstractPanel> getAllPanels(){return allPanels;}

    /**
     * Set the goal that the player will do to level up the norma level
     * @param goal is the goal that the player will try to do
     */
    public void setPlayerGoal(NormaGoal goal){
        Player player = getTurnOwner();
        player.setNormaGoal(goal);
    }

    /**
     * Enters the state of recovery and check if the player can be recovered
     * player.roll is the dice
     */

    public void recovery(){
        Player player = getTurnOwner();
        if(player.roll()>=(8-player.getRecovery())){
            player.setCurrentHp(player.getMaxHp());
            player.setRecovery(0);
        }
        else{
            player.setRecovery(player.getRecovery()+1);
        }
        turn.endRecovery();
        endTurn();
    }

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

    /**
     * stars the turn of the current player
     */

    public void startTurn(){
        Player player = getTurnOwner();
        if (player.getCurrentHp() == 0){
            turn.isKO();
            recovery();
        }
        else{
            turn.notKO();
        }
    }

    /**
     * Returns the current chapter
     */

    public int getChapter() {
        chapter =((turno-1)/4)+1;
        return chapter;
    }

    /**
     * Ends the turn of the actual player
     */

    public void endTurn(){
        Player terminar =getTurnOwner();
        terminar.setMyTurn(false);
        turno +=1;
        Player iniciar = getTurnOwner();
        iniciar.setMyTurn(true);
        turn.start();
    }

    /**
     * Do a normaCheck and a normaClear if the player is in a home panel
     */
    public void normaCheckClear(Player player){
        if (player.getPanel().getType()==PanelType.HOME){
            player.getPanel().normaCheck(player);
        }
    }

    /**
     * delegates the job to the movement method to move the player
     */

    public void movePlayer() {
        Player player = getTurnOwner();
        int moves = player.roll();
        AbstractPanel panel = player.getPanel();
        movement(player, moves, panel);
    }

    /**
     *  moves the player through the panels of the table.
     */
    public void movement(Player player,int moves,AbstractPanel panel){
        Set<Player> playersOnPanel = panel.getPlayersOnPanel();
        if(playersOnPanel.size() != 0 && player.getPanel() != panel) {
            boolean wantFight = wantToFight(playersOnPanel);
            if (wantFight) {
                player.getPanel().removePlayerOnPanel(player);
                player.setPanel(panel);
                panel.addPlayerOnPanel(player);
                panel.activatedBy(player);
            }
        }
        if(panel.getType() == PanelType.HOME && player.getPanel()!=panel){
            if(panel.getOwner()==player) {
                boolean wantHome = wantHome();
                if (wantHome) {
                    player.getPanel().removePlayerOnPanel(player);
                    player.setPanel(panel);
                    panel.addPlayerOnPanel(player);
                    panel.activatedBy(player);
                    endTurn();
                }
            }
        }

        Set<AbstractPanel> nextPanels = panel.getNextPanels();
        List<AbstractPanel> panelList = new ArrayList<>(nextPanels.size());
        panelList.addAll(nextPanels);

        AbstractPanel nextPanel = panelList.get(0);
        if (nextPanels.size()>1 && player.getPanel() != panel){
            player.getPanel().removePlayerOnPanel(player);
            player.setPanel(panel);
            panel.addPlayerOnPanel(player);
            panel.activatedBy(player);
            turn.path();
        }
        if (moves == 0){
            player.getPanel().removePlayerOnPanel(player);
            player.setPanel(panel);
            panel.addPlayerOnPanel(player);
            panel.activatedBy(player);
            turn.stayPanel();
        }
        moves =-1;
        movement(player,moves,nextPanel);

    }

    /**
     * Returns a boolean value depending on the decision of the user
     */

    private boolean wantHome() {
        return true;
    }

    /**
     * returns a boolean value that represents if the user wants to fight or not
     * @param players is the set of players in the panel that the user can choose one of them to battle.
     */

    private boolean wantToFight(Set<Player> players) {
        turn.fight();
        return true;
    }
}
