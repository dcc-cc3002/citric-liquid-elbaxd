package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrawPanelTest {
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

    @BeforeEach
    public void setUp() {
        testBonusPanel = new BonusPanel(PanelType.BONUS);
        testBossPanel = new BossPanel(PanelType.BOSS);
        testDropPanel = new DropPanel(PanelType.DROP);
        testEncounterPanel = new EncounterPanel(PanelType.ENCOUNTER);
        testHomePanel = new HomePanel(PanelType.HOME,suguri);
        testNeutralPanel = new NeutralPanel(PanelType.NEUTRAL);
        testDrawPanel = new DrawPanel(PanelType.DRAW);
        suguri = new Player(PLAYER_NAME, BASE_HP, BASE_ATK, BASE_DEF, BASE_EVD);
    }
    @Test
    public void constructorTest() {
        assertNotEquals(PanelType.DRAW, testBonusPanel.getType());
        assertNotEquals(PanelType.DRAW, testBossPanel.getType());
        assertNotEquals(PanelType.DRAW, testDropPanel.getType());
        assertNotEquals(PanelType.DRAW, testEncounterPanel.getType());
        assertNotEquals(PanelType.DRAW, testHomePanel.getType());
        assertNotEquals(PanelType.DRAW, testNeutralPanel.getType());
        assertEquals(PanelType.DRAW, testDrawPanel.getType());
    }

    @Test
    public void playersOnPanelTest() {
        assertTrue(testDrawPanel.getPlayersOnPanel().isEmpty());
        final var expectedPlayer1 = new Player("suguri3",2,1,1,1);
        final var expectedPlayer2 = new Player("suguri4",4,0,2,2);

        testDrawPanel.addPlayerOnPanel(expectedPlayer1);
        assertEquals(1, testDrawPanel.getPlayersOnPanel().size());

        testDrawPanel.addPlayerOnPanel(expectedPlayer2);
        assertEquals(2, testDrawPanel.getPlayersOnPanel().size());

        testDrawPanel.addPlayerOnPanel(expectedPlayer2);
        assertEquals(2, testDrawPanel.getPlayersOnPanel().size());

        assertEquals(Set.of(expectedPlayer1, expectedPlayer2),
                testDrawPanel.getPlayersOnPanel());
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
}
