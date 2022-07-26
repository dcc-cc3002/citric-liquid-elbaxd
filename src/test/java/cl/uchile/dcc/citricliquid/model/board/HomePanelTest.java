package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 * @version 1.0.6-rc.1
 * @since 1.0
 */
public class HomePanelTest {
    private final static String PLAYER_NAME = "Suguri";
    private final static String PLAYER_NAME2 = "Suguri2";
    private final static int BASE_HP = 4;
    private final static int BASE_ATK = 1;
    private final static int BASE_DEF = -1;
    private final static int BASE_EVD = 2;
    private HomePanel testHomePanel;
    private NeutralPanel testNeutralPanel;
    private BonusPanel testBonusPanel;
    private DropPanel testDropPanel;
    private EncounterPanel testEncounterPanel;
    private BossPanel testBossPanel;
    private DrawPanel testDrawPanel;
    private Player suguri;
    private Player suguri2;
    private long testSeed;


    @BeforeEach
    public void setUp() {
        testBonusPanel = new BonusPanel(PanelType.BONUS,1);
        testBossPanel = new BossPanel(PanelType.BOSS,2);
        testDropPanel = new DropPanel(PanelType.DROP,3);
        testEncounterPanel = new EncounterPanel(PanelType.ENCOUNTER,4);
        testNeutralPanel = new NeutralPanel(PanelType.NEUTRAL,6);
        testDrawPanel = new DrawPanel(PanelType.DRAW,7);
        testSeed = new Random().nextLong();
        suguri = new Player(PLAYER_NAME, BASE_HP, BASE_ATK, BASE_DEF, BASE_EVD);
        suguri2 = new Player(PLAYER_NAME2, BASE_HP, BASE_ATK, BASE_DEF, BASE_EVD);
        testHomePanel = new HomePanel(PanelType.HOME,5);
    }
    @Test
    public void constructorTest() {
        assertNotEquals(PanelType.HOME, testBonusPanel.getType());
        assertNotEquals(PanelType.HOME, testBossPanel.getType());
        assertNotEquals(PanelType.HOME, testDropPanel.getType());
        assertNotEquals(PanelType.HOME, testEncounterPanel.getType());
        assertEquals(PanelType.HOME, testHomePanel.getType());
        assertNotEquals(PanelType.HOME, testNeutralPanel.getType());
        assertNotEquals(PanelType.HOME, testDrawPanel.getType());

        assertNotEquals(5, testBonusPanel.getNumber());
        assertNotEquals(5, testBossPanel.getNumber());
        assertNotEquals(5, testDropPanel.getNumber());
        assertNotEquals(5, testEncounterPanel.getNumber());
        assertEquals(5, testHomePanel.getNumber());
        assertNotEquals(5, testNeutralPanel.getNumber());
        assertNotEquals(5, testDrawPanel.getNumber());
    }
    @Test
    public void playersOnPanelTest() {
        assertTrue(testHomePanel.getPlayersOnPanel().isEmpty());
        final var expectedPlayer1 = new Player("suguri3",2,1,1,1);
        final var expectedPlayer2 = new Player("suguri4",4,0,2,2);

        testHomePanel.addPlayerOnPanel(expectedPlayer1);
        assertEquals(1, testHomePanel.getPlayersOnPanel().size());

        testHomePanel.addPlayerOnPanel(expectedPlayer2);
        assertEquals(2, testHomePanel.getPlayersOnPanel().size());

        testHomePanel.addPlayerOnPanel(expectedPlayer2);
        assertEquals(2, testHomePanel.getPlayersOnPanel().size());

        assertEquals(Set.of(expectedPlayer1, expectedPlayer2),
                testHomePanel.getPlayersOnPanel());

        testHomePanel.removePlayerOnPanel(expectedPlayer1);
        assertEquals(2, testHomePanel.getPlayersOnPanel().size());

        testHomePanel.removePlayerOnPanel(expectedPlayer2);
        assertEquals(1, testHomePanel.getPlayersOnPanel().size());

        testHomePanel.removePlayerOnPanel(expectedPlayer2);
        assertEquals(1, testHomePanel.getPlayersOnPanel().size());

        assertNotEquals(Set.of(expectedPlayer1, expectedPlayer2),
                testHomePanel.getPlayersOnPanel());
        assertNotEquals(Set.of(expectedPlayer2),
                testHomePanel.getPlayersOnPanel());
        assertNotEquals(Set.of(expectedPlayer1),
                testHomePanel.getPlayersOnPanel());
        assertEquals(Set.of(),
                testHomePanel.getPlayersOnPanel());
    }
    @Test
    public void nextPanelTest() {
        assertTrue(testHomePanel.getNextPanels().isEmpty());
        final var expectedPanel1 = new NeutralPanel(PanelType.NEUTRAL,1);
        final var expectedPanel2 = new NeutralPanel(PanelType.NEUTRAL,2);

        testHomePanel.addNextPanel(expectedPanel1);
        assertEquals(1, testHomePanel.getNextPanels().size());

        testHomePanel.addNextPanel(expectedPanel2);
        assertEquals(2, testHomePanel.getNextPanels().size());

        testHomePanel.addNextPanel(expectedPanel2);
        assertEquals(2, testHomePanel.getNextPanels().size());

        assertEquals(Set.of(expectedPanel1, expectedPanel2),
                testHomePanel.getNextPanels());
    }
    @Test
    public void homePanelTest() {
        testHomePanel.setOwner(suguri);

        assertEquals(suguri.getMaxHp(), suguri.getCurrentHp());
        testHomePanel.activatedBy(suguri);
        assertEquals(suguri.getMaxHp(), suguri.getCurrentHp());

        suguri.setCurrentHp(1);
        testHomePanel.activatedBy(suguri);
        assertEquals(2, suguri.getCurrentHp());

        assertEquals(suguri,testHomePanel.getOwner());
        assertNotEquals(suguri2,testHomePanel.getOwner());
        assertTrue(testHomePanel.ownerCheck(suguri));
        assertFalse(testHomePanel.ownerCheck(suguri2));

        testHomePanel.setOwner(suguri2);

        assertNotEquals(suguri,testHomePanel.getOwner());
        assertEquals(suguri2,testHomePanel.getOwner());
        assertFalse(testHomePanel.ownerCheck(suguri));
        assertTrue(testHomePanel.ownerCheck(suguri2));
    }
    @RepeatedTest(100)
    public void normaCheckConsistencyTest(){
        int expectedNorma=1;
        assertEquals(expectedNorma, suguri.getNormaLevel());
        final int expectedStars = Math.abs(new Random(testSeed).nextInt(205));
        final int expectedWins = Math.abs(new Random(testSeed).nextInt(20));
        suguri.increaseStarsBy(expectedStars);
        suguri.increaseWinsBy(expectedWins);
        if (expectedStars >= 10 || expectedWins >=2){
            expectedNorma = 2;
        }
        if (expectedStars >= 30 || expectedWins >=2){
            expectedNorma = 3;
        }
        if (expectedStars >= 70 || expectedWins >=5){
            expectedNorma = 4;
        }
        if (expectedStars >= 120 || expectedWins >=9){
            expectedNorma = 5;
        }
        if (expectedStars >= 200 || expectedWins >=14){
            expectedNorma = 6;
        }
        testHomePanel.normaCheck(suguri);
        Assertions.assertEquals(expectedNorma, suguri.getNormaLevel(),
                "Test failed with random seed: " + testSeed);
    }
}
