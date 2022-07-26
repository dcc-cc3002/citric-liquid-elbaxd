package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 * @version 1.0.6-rc.1
 * @since 1.0
 */
public class EncounterPanelTest {
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
        suguri = new Player(PLAYER_NAME, BASE_HP, BASE_ATK, BASE_DEF, BASE_EVD);
    }
    @Test
    public void constructorTest() {
        assertNotEquals(PanelType.ENCOUNTER, testBonusPanel.getType());
        assertNotEquals(PanelType.ENCOUNTER, testBossPanel.getType());
        assertNotEquals(PanelType.ENCOUNTER, testDropPanel.getType());
        assertEquals(PanelType.ENCOUNTER, testEncounterPanel.getType());
        assertNotEquals(PanelType.ENCOUNTER, testHomePanel.getType());
        assertNotEquals(PanelType.ENCOUNTER, testNeutralPanel.getType());

        assertNotEquals(4, testBonusPanel.getNumber());
        assertNotEquals(4, testBossPanel.getNumber());
        assertNotEquals(4, testDropPanel.getNumber());
        assertEquals(4, testEncounterPanel.getNumber());
        assertNotEquals(4, testHomePanel.getNumber());
        assertNotEquals(4, testNeutralPanel.getNumber());
    }
    @Test
    public void playersOnPanelTest() {
        assertTrue(testEncounterPanel.getPlayersOnPanel().isEmpty());
        final var expectedPlayer1 = new Player("suguri3",2,1,1,1);
        final var expectedPlayer2 = new Player("suguri4",4,0,2,2);

        testEncounterPanel.addPlayerOnPanel(expectedPlayer1);
        assertEquals(1, testEncounterPanel.getPlayersOnPanel().size());

        testEncounterPanel.addPlayerOnPanel(expectedPlayer2);
        assertEquals(2, testEncounterPanel.getPlayersOnPanel().size());

        testEncounterPanel.addPlayerOnPanel(expectedPlayer2);
        assertEquals(2, testEncounterPanel.getPlayersOnPanel().size());

        assertEquals(Set.of(expectedPlayer1, expectedPlayer2),
                testEncounterPanel.getPlayersOnPanel());

        testEncounterPanel.removePlayerOnPanel(expectedPlayer1);
        assertEquals(2, testEncounterPanel.getPlayersOnPanel().size());

        testEncounterPanel.removePlayerOnPanel(expectedPlayer2);
        assertEquals(1, testEncounterPanel.getPlayersOnPanel().size());

        testEncounterPanel.removePlayerOnPanel(expectedPlayer2);
        assertEquals(1, testEncounterPanel.getPlayersOnPanel().size());

        assertNotEquals(Set.of(expectedPlayer1, expectedPlayer2),
                testEncounterPanel.getPlayersOnPanel());
        assertNotEquals(Set.of(expectedPlayer2),
                testEncounterPanel.getPlayersOnPanel());
        assertNotEquals(Set.of(expectedPlayer1),
                testEncounterPanel.getPlayersOnPanel());
        assertEquals(Set.of(),
                testEncounterPanel.getPlayersOnPanel());
    }
    @Test
    public void nextPanelTest() {
        assertTrue(testEncounterPanel.getNextPanels().isEmpty());
        final var expectedPanel1 = new EncounterPanel(PanelType.ENCOUNTER,1);
        final var expectedPanel2 = new EncounterPanel(PanelType.ENCOUNTER,1);

        testEncounterPanel.addNextPanel(expectedPanel1);
        assertEquals(1, testEncounterPanel.getNextPanels().size());

        testEncounterPanel.addNextPanel(expectedPanel2);
        assertEquals(2, testEncounterPanel.getNextPanels().size());

        testEncounterPanel.addNextPanel(expectedPanel2);
        assertEquals(2, testEncounterPanel.getNextPanels().size());

        assertEquals(Set.of(expectedPanel1, expectedPanel2),
                testEncounterPanel.getNextPanels());
    }
}
