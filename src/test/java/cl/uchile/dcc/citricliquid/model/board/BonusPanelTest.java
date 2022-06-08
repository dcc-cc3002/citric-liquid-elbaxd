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
        testBonusPanel = new BonusPanel(PanelType.BONUS);
        testBossPanel = new BossPanel(PanelType.BOSS);
        testDropPanel = new DropPanel(PanelType.DROP);
        testEncounterPanel = new EncounterPanel(PanelType.ENCOUNTER);
        testHomePanel = new HomePanel(PanelType.HOME,suguri);
        testNeutralPanel = new NeutralPanel(PanelType.NEUTRAL);
        testDrawPanel = new DrawPanel(PanelType.DRAW);
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
    }
    @Test
    public void nextPanelTest() {
        assertTrue(testBonusPanel.getNextPanels().isEmpty());
        final var expectedPanel1 = new Panel(PanelType.BONUS);
        final var expectedPanel2 = new Panel(PanelType.BONUS);

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
