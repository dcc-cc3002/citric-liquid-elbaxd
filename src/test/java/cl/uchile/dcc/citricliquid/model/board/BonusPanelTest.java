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
public class BonusPanelTest {
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
        testHomePanel = new HomePanel(PanelType.HOME,5);
        testNeutralPanel = new NeutralPanel(PanelType.NEUTRAL,6);
        testDrawPanel = new DrawPanel(PanelType.DRAW,7);
        testSeed = new Random().nextLong();
        suguri = new Player(PLAYER_NAME, BASE_HP, BASE_ATK, BASE_DEF, BASE_EVD);
    }
    @Test
    public void constructorTest() {
        assertEquals(PanelType.BONUS, testBonusPanel.getType());
        assertNotEquals(PanelType.BONUS, testBossPanel.getType());
        assertNotEquals(PanelType.BONUS, testDropPanel.getType());
        assertNotEquals(PanelType.BONUS, testEncounterPanel.getType());
        assertNotEquals(PanelType.BONUS, testHomePanel.getType());
        assertNotEquals(PanelType.BONUS, testNeutralPanel.getType());

        assertEquals(1, testBonusPanel.getNumber());
        assertNotEquals(1, testBossPanel.getNumber());
        assertNotEquals(1, testDropPanel.getNumber());
        assertNotEquals(1, testEncounterPanel.getNumber());
        assertNotEquals(1, testHomePanel.getNumber());
        assertNotEquals(1, testNeutralPanel.getNumber());
    }

    @Test
    public void playersOnPanelTest() {
        assertTrue(testBonusPanel.getPlayersOnPanel().isEmpty());
        final var expectedPlayer1 = new Player("suguri3",2,1,1,1);
        final var expectedPlayer2 = new Player("suguri4",4,0,2,2);

        testBonusPanel.addPlayerOnPanel(expectedPlayer1);
        assertEquals(1, testBonusPanel.getPlayersOnPanel().size());

        testBonusPanel.addPlayerOnPanel(expectedPlayer2);
        assertEquals(2, testBonusPanel.getPlayersOnPanel().size());

        testBonusPanel.addPlayerOnPanel(expectedPlayer2);
        assertEquals(2, testBonusPanel.getPlayersOnPanel().size());

        assertEquals(Set.of(expectedPlayer1, expectedPlayer2),
                testBonusPanel.getPlayersOnPanel());

        testBonusPanel.removePlayerOnPanel(expectedPlayer1);
        assertEquals(2, testBonusPanel.getPlayersOnPanel().size());

        testBonusPanel.removePlayerOnPanel(expectedPlayer2);
        assertEquals(1, testBonusPanel.getPlayersOnPanel().size());

        testBonusPanel.removePlayerOnPanel(expectedPlayer2);
        assertEquals(1, testBonusPanel.getPlayersOnPanel().size());

        assertNotEquals(Set.of(expectedPlayer1, expectedPlayer2),
                testBonusPanel.getPlayersOnPanel());
        assertNotEquals(Set.of(expectedPlayer2),
                testBonusPanel.getPlayersOnPanel());
        assertNotEquals(Set.of(expectedPlayer1),
                testBonusPanel.getPlayersOnPanel());
        assertEquals(Set.of(),
                testBonusPanel.getPlayersOnPanel());
    }
    @Test
    public void nextPanelTest() {
        assertTrue(testBonusPanel.getNextPanels().isEmpty());
        final var expectedPanel1 = new BonusPanel(PanelType.BONUS,1);
        final var expectedPanel2 = new BonusPanel(PanelType.BONUS,2);

        testBonusPanel.addNextPanel(expectedPanel1);
        assertEquals(1, testBonusPanel.getNextPanels().size());

        testBonusPanel.addNextPanel(expectedPanel2);
        assertEquals(2, testBonusPanel.getNextPanels().size());

        testBonusPanel.addNextPanel(expectedPanel2);
        assertEquals(2, testBonusPanel.getNextPanels().size());

        assertEquals(Set.of(expectedPanel1, expectedPanel2),
                testBonusPanel.getNextPanels());
    }
    @RepeatedTest(100)
    public void bonusPanelConsistencyTest() {
        int expectedStars = 0;
        assertEquals(expectedStars, suguri.getStars());
        final var testRandom = new Random(testSeed);
        suguri.setSeed(testSeed);
        for (int normaLvl = 1; normaLvl <= 6; normaLvl++) {
            final int roll = testRandom.nextInt(6) + 1;
            testBonusPanel.activatedBy(suguri);
            expectedStars += roll * Math.min(3, normaLvl);
            assertEquals(expectedStars, suguri.getStars(),
                    "Test failed with seed: " + testSeed);
            suguri.normaClear();
        }
}
}
