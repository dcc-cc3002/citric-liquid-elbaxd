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
        testSeed = new Random().nextLong();
        suguri = new Player(PLAYER_NAME, BASE_HP, BASE_ATK, BASE_DEF, BASE_EVD);
    }
    @Test
    public void constructorTest() {
        assertNotEquals(PanelType.BOSS, testBonusPanel.getType());
        assertEquals(PanelType.BOSS, testBossPanel.getType());
        assertNotEquals(PanelType.BOSS, testDropPanel.getType());
        assertNotEquals(PanelType.BOSS, testEncounterPanel.getType());
        assertNotEquals(PanelType.BOSS, testHomePanel.getType());
        assertNotEquals(PanelType.BOSS, testNeutralPanel.getType());

        assertNotEquals(2, testBonusPanel.getNumber());
        assertEquals(2, testBossPanel.getNumber());
        assertNotEquals(2, testDropPanel.getNumber());
        assertNotEquals(2, testEncounterPanel.getNumber());
        assertNotEquals(2, testHomePanel.getNumber());
        assertNotEquals(2, testNeutralPanel.getNumber());
    }
    @Test
    public void playersOnPanelTest() {
        assertTrue(testBossPanel.getPlayersOnPanel().isEmpty());
        final var expectedPlayer1 = new Player("suguri3",2,1,1,1);
        final var expectedPlayer2 = new Player("suguri4",4,0,2,2);

        testBossPanel.addPlayerOnPanel(expectedPlayer1);
        assertEquals(1, testBossPanel.getPlayersOnPanel().size());

        testBossPanel.addPlayerOnPanel(expectedPlayer2);
        assertEquals(2, testBossPanel.getPlayersOnPanel().size());

        testBossPanel.addPlayerOnPanel(expectedPlayer2);
        assertEquals(2, testBossPanel.getPlayersOnPanel().size());

        assertEquals(Set.of(expectedPlayer1, expectedPlayer2),
                testBossPanel.getPlayersOnPanel());

        testBossPanel.removePlayerOnPanel(expectedPlayer1);
        assertEquals(2, testBossPanel.getPlayersOnPanel().size());

        testBossPanel.removePlayerOnPanel(expectedPlayer2);
        assertEquals(1, testBossPanel.getPlayersOnPanel().size());

        testBossPanel.removePlayerOnPanel(expectedPlayer2);
        assertEquals(1, testBossPanel.getPlayersOnPanel().size());

        assertNotEquals(Set.of(expectedPlayer1, expectedPlayer2),
                testBossPanel.getPlayersOnPanel());
        assertNotEquals(Set.of(expectedPlayer2),
                testBossPanel.getPlayersOnPanel());
        assertNotEquals(Set.of(expectedPlayer1),
                testBossPanel.getPlayersOnPanel());
        assertEquals(Set.of(),
                testBossPanel.getPlayersOnPanel());
    }
    @Test
    public void nextPanelTest() {
        assertTrue(testBossPanel.getNextPanels().isEmpty());
        final var expectedPanel1 = new Panel(PanelType.BOSS);
        final var expectedPanel2 = new Panel(PanelType.BOSS);

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
