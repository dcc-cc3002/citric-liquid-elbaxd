package cl.uchile.dcc.citricliquid.model.Characters;

import cl.uchile.dcc.citricliquid.model.Characters.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class BossUnitTest {
    private final static String BOSS_NAME = "JefeFinal";
    private BossUnit JefeFinal;


    @BeforeEach
    public void setUp() {
        JefeFinal = new BossUnit(BOSS_NAME, 5, 2, 0, 3);
    }

    @Test
    public void constructorTest() {
        final var expectedJefeFinal = new BossUnit(BOSS_NAME, 5, 2, 0, 3);
        Assertions.assertEquals(expectedJefeFinal, JefeFinal);
    }

    @Test
    public void testEquals() {
        final var o = new Object();
        Assertions.assertNotEquals(JefeFinal, o);
        Assertions.assertEquals(JefeFinal, JefeFinal);
        final var expectedJefeFinal = new BossUnit(BOSS_NAME, 5, 2, 0, 3);
        Assertions.assertEquals(expectedJefeFinal, JefeFinal);
    }

    @Test
    public void hitPointsTest() {
        Assertions.assertEquals(JefeFinal.getMaxHp(), JefeFinal.getCurrentHp());
        JefeFinal.setCurrentHp(2);
        Assertions.assertEquals(2, JefeFinal.getCurrentHp());
        JefeFinal.setCurrentHp(-1);
        Assertions.assertEquals(0, JefeFinal.getCurrentHp());
        JefeFinal.setCurrentHp(5);
        Assertions.assertEquals(5, JefeFinal.getCurrentHp());
    }

    @Test
    public void copyTest() {
        final var expectedJefeFinal = new Player(BOSS_NAME, 5, 2, 0, 3);
        final var actualJefeFinal = JefeFinal.copy();
        // Checks that the copied player have the same parameters as the original
        Assertions.assertEquals(expectedJefeFinal, actualJefeFinal);
        // Checks that the copied player doesn't reference the same object
        Assertions.assertNotSame(expectedJefeFinal, actualJefeFinal);
    }

    // region : consistency tests
    @RepeatedTest(100)
    public void hitPointsConsistencyTest() {
        final long testSeed = new Random().nextLong();
        // We're gonna try and set random hit points in [-maxHP * 2, maxHP * 2]
        final int testHP = new Random(testSeed).nextInt(4 * JefeFinal.getMaxHp() + 1)
                - 2 * JefeFinal.getMaxHp();
        JefeFinal.setCurrentHp(testHP);
        Assertions.assertTrue(0 <= JefeFinal.getCurrentHp()
                        && JefeFinal.getCurrentHp() <= JefeFinal.getMaxHp(),
                JefeFinal.getCurrentHp() + "is not a valid HP value"
                        + System.lineSeparator() + "Test failed with random seed: "
                        + testSeed);
    }
    @RepeatedTest(100)
    public void rollConsistencyTest() {
        final long testSeed = new Random().nextLong();
        JefeFinal.setSeed(testSeed);
        final int roll = JefeFinal.roll();
        Assertions.assertTrue(roll >= 1 && roll <= 6,
                roll + "is not in [1, 6]" + System.lineSeparator()
                        + "Test failed with random seed: " + testSeed);
    }
    // endregion
}
