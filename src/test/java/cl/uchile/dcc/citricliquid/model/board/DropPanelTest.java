package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
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
public class DropPanelTest {
    private final static String PLAYER_NAME = "Suguri";
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
    private long testSeed;

    @BeforeEach
    public void setUp() {
        testBonusPanel = new BonusPanel(PanelType.BONUS,1);
        testBossPanel = new BossPanel(PanelType.BOSS,2);
        testDropPanel = new DropPanel(PanelType.DROP,3);
        testEncounterPanel = new EncounterPanel(PanelType.ENCOUNTER,4);
        testHomePanel = new HomePanel(PanelType.HOME,5,suguri);
        testNeutralPanel = new NeutralPanel(PanelType.NEUTRAL,6);
        testDrawPanel = new DrawPanel(PanelType.DRAW,7);
        suguri = new Player(PLAYER_NAME, BASE_HP, BASE_ATK, BASE_DEF, BASE_EVD);
    }
    @Test
    public void constructorTest() {
        assertNotEquals(PanelType.DROP, testBonusPanel.getType());
        assertNotEquals(PanelType.DROP, testBossPanel.getType());
        assertEquals(PanelType.DROP, testDropPanel.getType());
        assertNotEquals(PanelType.DROP, testEncounterPanel.getType());
        assertNotEquals(PanelType.DROP, testHomePanel.getType());
        assertNotEquals(PanelType.DROP, testNeutralPanel.getType());

        assertNotEquals(3, testBonusPanel.getNumber());
        assertNotEquals(3, testBossPanel.getNumber());
        assertEquals(3, testDropPanel.getNumber());
        assertNotEquals(3, testEncounterPanel.getNumber());
        assertNotEquals(3, testHomePanel.getNumber());
        assertNotEquals(3, testNeutralPanel.getNumber());
    }
    @Test
    public void playersOnPanelTest() {
        assertTrue(testDropPanel.getPlayersOnPanel().isEmpty());
        final var expectedPlayer1 = new Player("suguri3",2,1,1,1);
        final var expectedPlayer2 = new Player("suguri4",4,0,2,2);

        testDropPanel.addPlayerOnPanel(expectedPlayer1);
        assertEquals(1, testDropPanel.getPlayersOnPanel().size());

        testDropPanel.addPlayerOnPanel(expectedPlayer2);
        assertEquals(2, testDropPanel.getPlayersOnPanel().size());

        testDropPanel.addPlayerOnPanel(expectedPlayer2);
        assertEquals(2, testDropPanel.getPlayersOnPanel().size());

        assertEquals(Set.of(expectedPlayer1, expectedPlayer2),
                testDropPanel.getPlayersOnPanel());

        testDropPanel.removePlayerOnPanel(expectedPlayer1);
        assertEquals(2, testDropPanel.getPlayersOnPanel().size());

        testDropPanel.removePlayerOnPanel(expectedPlayer2);
        assertEquals(1, testDropPanel.getPlayersOnPanel().size());

        testDropPanel.removePlayerOnPanel(expectedPlayer2);
        assertEquals(1, testDropPanel.getPlayersOnPanel().size());

        assertNotEquals(Set.of(expectedPlayer1, expectedPlayer2),
                testDropPanel.getPlayersOnPanel());
        assertNotEquals(Set.of(expectedPlayer2),
                testDropPanel.getPlayersOnPanel());
        assertNotEquals(Set.of(expectedPlayer1),
                testDropPanel.getPlayersOnPanel());
        assertEquals(Set.of(),
                testDropPanel.getPlayersOnPanel());
    }
    @Test
    public void nextPanelTest() {
        assertTrue(testDropPanel.getNextPanels().isEmpty());
        final var expectedPanel1 = new Panel(PanelType.DROP);
        final var expectedPanel2 = new Panel(PanelType.DROP);

        testDropPanel.addNextPanel(expectedPanel1);
        assertEquals(1, testDropPanel.getNextPanels().size());

        testDropPanel.addNextPanel(expectedPanel2);
        assertEquals(2, testDropPanel.getNextPanels().size());

        testDropPanel.addNextPanel(expectedPanel2);
        assertEquals(2, testDropPanel.getNextPanels().size());

        assertEquals(Set.of(expectedPanel1, expectedPanel2),
                testDropPanel.getNextPanels());
    }
    @RepeatedTest(100)
    public void dropPanelConsistencyTest() {
        int expectedStars = 30;
        suguri.increaseStarsBy(30);
        assertEquals(expectedStars, suguri.getStars());
        final var testRandom = new Random(testSeed);
        suguri.setSeed(testSeed);
        for (int normaLvl = 1; normaLvl <= 6; normaLvl++) {
            final int roll = testRandom.nextInt(6) + 1;
            testDropPanel.activatedBy(suguri);
            expectedStars = Math.max(expectedStars - roll * normaLvl, 0);
            assertEquals(expectedStars, suguri.getStars(),
                    "Test failed with seed: " + testSeed);
            suguri.normaClear();
        }
    }
}
