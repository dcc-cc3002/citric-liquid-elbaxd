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
public class BossPanelTest {
    private final static String PLAYER_NAME = "Suguri";
    private final static int BASE_HP = 4;
    private final static int BASE_ATK = 1;
    private final static int BASE_DEF = -1;
    private final static int BASE_EVD = 2;
    private Panel testHomePanel;
    private Panel testNeutralPanel;
    private Panel testBonusPanel;
    private Panel testDropPanel;
    private Panel testEncounterPanel;
    private Panel testBossPanel;
    private Player suguri;
    private long testSeed;

    @BeforeEach
    public void setUp() {
        testBonusPanel = new Panel(PanelType.BONUS);
        testBossPanel = new Panel(PanelType.BOSS);
        testDropPanel = new Panel(PanelType.DROP);
        testEncounterPanel = new Panel(PanelType.ENCOUNTER);
        testHomePanel = new Panel(PanelType.HOME);
        testNeutralPanel = new Panel(PanelType.NEUTRAL);
        testSeed = new Random().nextLong();
        suguri = new Player(PLAYER_NAME, BASE_HP, BASE_ATK, BASE_DEF, BASE_EVD);
    }
    @Test
    public void constructorTest() {
        assertNotEquals(PanelType.BONUS, testBonusPanel.getType());
        assertEquals(PanelType.BOSS, testBossPanel.getType());
        assertNotEquals(PanelType.DROP, testDropPanel.getType());
        assertNotEquals(PanelType.ENCOUNTER, testEncounterPanel.getType());
        assertNotEquals(PanelType.HOME, testHomePanel.getType());
        assertNotEquals(PanelType.NEUTRAL, testNeutralPanel.getType());
    }
    @Test
    public void nextPanelTest() {
        assertTrue(testBossPanel.getNextPanels().isEmpty());
        final var expectedPanel1 = new Panel(PanelType.NEUTRAL);
        final var expectedPanel2 = new Panel(PanelType.NEUTRAL);

        testBossPanel.addNextPanel(expectedPanel1);
        assertEquals(1, testBossPanel.getNextPanels().size());

        testBossPanel.addNextPanel(expectedPanel2);
        assertEquals(2, testBossPanel.getNextPanels().size());

        testBossPanel.addNextPanel(expectedPanel2);
        assertEquals(2, testBossPanel.getNextPanels().size());

        assertEquals(Set.of(expectedPanel1, expectedPanel2),
                testBossPanel.getNextPanels());
    }
}
