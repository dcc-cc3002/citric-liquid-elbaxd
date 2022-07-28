package cl.uchile.dcc.citricliquid.model.controller;

import cl.uchile.dcc.citricliquid.controller.GameController;
import cl.uchile.dcc.citricliquid.model.Characters.BossUnit;
import cl.uchile.dcc.citricliquid.model.Characters.Player;
import cl.uchile.dcc.citricliquid.model.Characters.WildUnit;
import cl.uchile.dcc.citricliquid.model.board.*;
import cl.uchile.dcc.citricliquid.model.NormaGoal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
    private GameController gameController;
    protected final static String player = "Suguri";
    protected final static String jefe1 = "Suguri";
    protected final static String salvaje1 = "Suguri";
    private DropPanel testDropPanel;
    private BossPanel testBossPanel;
    private BonusPanel testBonusPanel;
    private HomePanel testHomePanel;
    private Player suguri;
    private BossUnit jefe;
    private WildUnit salvaje;

    @BeforeEach
    public void setUp(){
        gameController = new GameController();
        testHomePanel = new HomePanel(PanelType.HOME,5);
        testDropPanel = new DropPanel(PanelType.DROP,3);
        testBossPanel = new BossPanel(PanelType.BOSS,2);
        testBonusPanel = new BonusPanel(PanelType.BONUS,1);
        suguri = new Player(player,4,1,-1,2);
        jefe = new BossUnit(jefe1, 4, 1, -1,2);
        salvaje = new WildUnit(salvaje1, 4, 1, -1, 2);
    }

    @Test
    public void constructorTest(){
        assertEquals(0,gameController.allPlayers.size());
        assertEquals(0,gameController.allPanels.size());
        assertEquals(1,gameController.turno);
        assertEquals(1,gameController.chapter);
        assertTrue(gameController.turn.isStart());
    }

    @Test
    public void createPanelsTest(){
        List<IPanel> testPanels = new ArrayList<>();
        testPanels.add(gameController.createBonusPanel(1));
        testPanels.add(gameController.createBossPanel(2));
        testPanels.add(gameController.createDropPanel(3));
        testPanels.add(gameController.createEncounterPanel(4));
        testPanels.add(gameController.createHomePanel(5));
        testPanels.add(gameController.createNeutralPanel(6));
        testPanels.add(gameController.createBonusPanel(7));
        assertEquals(testPanels,gameController.allPanels);
    }

    @Test
    public void createPlayersTest(){
        List<Player> playersTest = new ArrayList<>();
        playersTest.add(gameController.createPlayer("Javier",1,1,1,1,gameController.createBonusPanel(1)));
        playersTest.add(gameController.createPlayer("Ignacio",1,1,1,1,gameController.createHomePanel(2)));
        playersTest.add(gameController.createPlayer("Atenas",1,1,1,1,gameController.createNeutralPanel(3)));
        playersTest.add(gameController.createPlayer("Maldonado",1,1,1,1,gameController.createEncounterPanel(4)));
        assertEquals(playersTest,gameController.allPlayers);
        Set<Player> test = new HashSet<>();
        test.add(gameController.allPlayers.get(0));
        assertEquals(test,gameController.allPanels.get(0).getPlayersOnPanel());
        Set<Player> test2 = new HashSet<>();
        test2.add(gameController.allPlayers.get(1));
        assertEquals(test2,gameController.allPanels.get(1).getPlayersOnPanel());
    }

    @Test
    public void createWildTest(){
        WildUnit wildTest = new WildUnit("salvaje", 1, 1,1,1);
        assertEquals(wildTest,gameController.createWildUnit("salvaje",1,1,1,1));
        assertNotEquals(wildTest,gameController.createWildUnit("otroSalvaje",1,1,1,1));
    }

    @Test
    public void createBossTest(){
        BossUnit bossTest = new BossUnit("jefe", 1, 1,1,1);
        assertEquals(bossTest,gameController.createBossUnit("jefe",1,1,1,1));
        assertNotEquals(bossTest,gameController.createBossUnit("otrojefe",1,1,1,1));
    }

    @Test
    public void setPlayerHomeTest(){
        HomePanel home = new HomePanel(PanelType.HOME,5);
        Player player = new Player("Suguri",4,1,-1,2);
        home.setOwner(player);
        gameController.setPlayerHome(suguri,testHomePanel);
        assertEquals(home.getOwner(),testHomePanel.getOwner());
    }

    @Test
    public void getPanelsTest(){
        List<IPanel> testPanels = new ArrayList<>();
        testPanels.add(gameController.createBonusPanel(1));
        testPanels.add(gameController.createBossPanel(2));
        testPanels.add(gameController.createDropPanel(3));
        testPanels.add(gameController.createEncounterPanel(4));
        testPanels.add(gameController.createHomePanel(5));
        testPanels.add(gameController.createNeutralPanel(1));
        testPanels.add(gameController.createBonusPanel(1));
        assertEquals(testPanels,gameController.getAllPanels());
    }

    @Test
    public void getTurnOwnerTest(){
        gameController.createPlayer("Suguri",4,1,-1,2,testHomePanel);
        gameController.createPlayer("player",4,1,-1,2,testDropPanel);
        gameController.createPlayer("player2",4,1,-1,2,testBossPanel);
        gameController.createPlayer("player3",4,1,-1,2,testBonusPanel);
        assertEquals(suguri,gameController.getTurnOwner());
        gameController.turno = gameController.turno + 1;
        assertEquals("player",gameController.getTurnOwner().getName());
        gameController.turno = gameController.turno + 1;
        assertEquals("player2",gameController.getTurnOwner().getName());
        gameController.turno = gameController.turno + 1;
        assertEquals("player3",gameController.getTurnOwner().getName());
        gameController.turno = gameController.turno + 1;
        assertEquals(suguri,gameController.getTurnOwner());
        gameController.turno = gameController.turno + 1;
        assertEquals(gameController.allPlayers.get(1),gameController.getTurnOwner());
        gameController.turno = gameController.turno + 1;
        assertEquals(gameController.allPlayers.get(2),gameController.getTurnOwner());
        gameController.turno = gameController.turno + 1;
        assertEquals(gameController.allPlayers.get(3),gameController.getTurnOwner());
    }

    @Test
    public void recoveryTest(){
        gameController.createPlayer("Suguri",4,1,-1,2,testHomePanel);
        Player player = gameController.getTurnOwner();
        player.setCurrentHp(0);
        gameController.recovery();
        assertEquals(1,player.getRecovery());
        assertEquals(0,player.getCurrentHp());
        gameController.recovery();
        assertEquals(2,player.getRecovery());
        assertEquals(0,player.getCurrentHp());
        player.setRecovery(7);
        gameController.recovery();
        assertEquals(0,player.getRecovery());
        assertEquals(4,player.getCurrentHp());
    }

    @Test
    public void startTurnTest(){
        gameController.createPlayer("Suguri",4,1,-1,2,testHomePanel);
        Player player = gameController.getTurnOwner();
        assertTrue(gameController.turn.isStart());
        gameController.startTurn();
        assertTrue(gameController.turn.isNotKO());
        gameController.turn.playCard();
        gameController.turn.move();
        gameController.turn.stayPanel();
        gameController.turn.end();
        gameController.turn.start();
        player.setCurrentHp(0);
        gameController.startTurn();
        assertTrue(gameController.turn.isIsKO());
    }

    @Test
    public void endTurnTest(){
        gameController.createPlayer("Suguri",4,1,-1,2,testHomePanel);
        gameController.createPlayer("player",4,1,-1,2,testDropPanel);
        gameController.createPlayer("player2",4,1,-1,2,testBossPanel);
        gameController.createPlayer("player3",4,1,-1,2,testBonusPanel);
        gameController.turn.notKO();
        gameController.turn.playCard();
        gameController.turn.move();
        gameController.turn.stayPanel();
        gameController.turn.end();
        assertEquals(1, gameController.turno);
        assertEquals(1, gameController.chapter);
        assertEquals(gameController.allPlayers.get(0),gameController.getTurnOwner());
        gameController.endTurn();
        assertEquals(2,gameController.turno);
        assertEquals(1,gameController.chapter);
        assertEquals(gameController.allPlayers.get(1),gameController.getTurnOwner());
        assertTrue(gameController.turn.isStart());
        gameController.turn.notKO();
        gameController.turn.playCard();
        gameController.turn.move();
        gameController.turn.stayPanel();
        gameController.turn.end();
        gameController.endTurn();
        assertEquals(3,gameController.turno);
        assertEquals(1,gameController.chapter);
        assertEquals(gameController.allPlayers.get(2),gameController.getTurnOwner());
        assertTrue(gameController.turn.isStart());
        gameController.turn.notKO();
        gameController.turn.playCard();
        gameController.turn.move();
        gameController.turn.stayPanel();
        gameController.turn.end();
        gameController.endTurn();
        assertEquals(4,gameController.turno);
        assertEquals(1,gameController.chapter);
        assertEquals(gameController.allPlayers.get(3),gameController.getTurnOwner());
        assertTrue(gameController.turn.isStart());
        gameController.turn.notKO();
        gameController.turn.playCard();
        gameController.turn.move();
        gameController.turn.stayPanel();
        gameController.turn.end();
        gameController.endTurn();
        assertEquals(5,gameController.turno);
        assertEquals(2,gameController.chapter);
        assertEquals(gameController.allPlayers.get(0),gameController.getTurnOwner());
        assertTrue(gameController.turn.isStart());
        gameController.turn.notKO();
        gameController.turn.playCard();
        gameController.turn.move();
        gameController.turn.stayPanel();
        gameController.turn.end();
    }

    @Test
    public void setNormaGoalTest(){
        gameController.createPlayer("Suguri",4,1,-1,2,testHomePanel);
        assertEquals(NormaGoal.WINS,gameController.allPlayers.get(0).getNormaGoal());
        gameController.setPlayerGoal(NormaGoal.STARS);
        assertEquals(NormaGoal.STARS,gameController.allPlayers.get(0).getNormaGoal());
        assertNotEquals(NormaGoal.WINS,gameController.allPlayers.get(0).getNormaGoal());
        gameController.setPlayerGoal(NormaGoal.WINS);
        assertNotEquals(NormaGoal.STARS,gameController.allPlayers.get(0).getNormaGoal());
        assertEquals(NormaGoal.WINS,gameController.allPlayers.get(0).getNormaGoal());
        gameController.setPlayerGoal(NormaGoal.STARS);
        assertNotEquals(NormaGoal.WINS,gameController.allPlayers.get(0).getNormaGoal());
        assertEquals(NormaGoal.STARS,gameController.allPlayers.get(0).getNormaGoal());
    }

    @Test
    public void movevementTest(){
        Set<Player> test = new HashSet<>();
        gameController.turn.notKO();
        gameController.turn.playCard();
        gameController.turn.move();
        gameController.createBonusPanel(1);
        gameController.createPlayer("Suguri",4,1,-1,2,gameController.allPanels.get(0));
        test.add(gameController.allPlayers.get(0));
        test.add(suguri);
        gameController.createBossPanel(2);
        gameController.allPanels.get(1).addPlayerOnPanel(suguri);
        gameController.createHomePanel(3);
        HomePanel panel = (HomePanel) gameController.allPanels.get(2);
        gameController.setPlayerHome(gameController.getTurnOwner(),panel);
        gameController.createDropPanel(4);
        gameController.createEncounterPanel(5);
        gameController.createNeutralPanel(6);
        gameController.createNeutralPanel(7);
        gameController.createNeutralPanel(8);
        gameController.createNeutralPanel(9);
        gameController.createNeutralPanel(10);
        gameController.createNeutralPanel(11);
        gameController.createNeutralPanel(12);
        int j = 0;
        for(int x=0; x<gameController.allPanels.size(); x++){
            if(x+1 == gameController.allPanels.size()){
                j = 0;
            }
            else{
                j = x+1;
            }
            gameController.allPanels.get(x).addNextPanel(gameController.allPanels.get(j));
        }
        gameController.setNextPanel(gameController.allPanels.get(3),gameController.allPanels.get(9));
        gameController.turn.notKO();
        gameController.turn.playCard();
        gameController.turn.move();
        assertTrue(gameController.turn.isMove());
        gameController.movePlayer();
        assertTrue(gameController.turn.isFight());
        assertEquals(gameController.allPanels.get(1),gameController.getTurnOwner().getPanel());
        assertEquals(test,gameController.getTurnOwner().getPanel().getPlayersOnPanel());
        assertEquals(0,gameController.allPanels.get(0).getPlayersOnPanel().size());
        assertEquals(2,gameController.allPanels.get(1).getPlayersOnPanel().size());
        gameController.turn.noFight();
        assertTrue(gameController.turn.isMove());
        gameController.movePlayer();
        assertTrue(gameController.turn.isStayHome());
        assertEquals(gameController.allPanels.get(2),gameController.getTurnOwner().getPanel());
        assertEquals(1,gameController.allPanels.get(1).getPlayersOnPanel().size());
        gameController.turn.noHome();
        assertTrue(gameController.turn.isMove());
        gameController.movePlayer();
        assertTrue(gameController.turn.isPath());
        gameController.turn.backToTrack();
        assertTrue(gameController.turn.isMove());
        gameController.movePlayer();
        assertFalse(gameController.turn.isMove());
        assertFalse(gameController.turn.isPath());
        assertFalse(gameController.turn.isStayHome());
        assertFalse(gameController.turn.isFight());
        assertTrue(gameController.turn.isStayPanel());
    }
}
