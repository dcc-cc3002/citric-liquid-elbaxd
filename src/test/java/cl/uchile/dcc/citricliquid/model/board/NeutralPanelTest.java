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
public class NeutralPanelTest {
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
        assertNotEquals(PanelType.NEUTRAL, testBonusPanel.getType());
        assertNotEquals(PanelType.NEUTRAL, testBossPanel.getType());
        assertNotEquals(PanelType.NEUTRAL, testDropPanel.getType());
        assertNotEquals(PanelType.NEUTRAL, testEncounterPanel.getType());
        assertNotEquals(PanelType.NEUTRAL, testHomePanel.getType());
        assertEquals(PanelType.NEUTRAL, testNeutralPanel.getType());
        assertNotEquals(PanelType.NEUTRAL, testDrawPanel.getType());
    }

    @Test
    public void nextPanelTest() {
        assertTrue(testNeutralPanel.getNextPanels().isEmpty());
        final var expectedPanel1 = new Panel(PanelType.NEUTRAL);
        final var expectedPanel2 = new Panel(PanelType.NEUTRAL);

        testNeutralPanel.addNextPanel(expectedPanel1);
        assertEquals(1, testNeutralPanel.getNextPanels().size());

        testNeutralPanel.addNextPanel(expectedPanel2);
        assertEquals(2, testNeutralPanel.getNextPanels().size());

        testNeutralPanel.addNextPanel(expectedPanel2);
        assertEquals(2, testNeutralPanel.getNextPanels().size());

        assertEquals(Set.of(expectedPanel1, expectedPanel2),
                testNeutralPanel.getNextPanels());
    }
    @Test
    public void neutralPanelTest() {
        final var expectedSuguri = suguri.copy();
        testNeutralPanel.activatedBy(suguri);
        assertEquals(expectedSuguri, suguri);
    }
}
