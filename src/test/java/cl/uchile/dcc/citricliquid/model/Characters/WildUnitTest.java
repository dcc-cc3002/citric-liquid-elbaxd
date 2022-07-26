package cl.uchile.dcc.citricliquid.model.Characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class WildUnitTest {

    private final static String WILD_NAME = "WildUnit";
    private WildUnit WildUnit;

    @BeforeEach
    public void setUp() {
        WildUnit = new WildUnit(WILD_NAME, 2, 1, 0, 0);
    }

    @Test
    public void constructorTest() {
        final var expectedWildUnit = new WildUnit(WILD_NAME, 2, 1, 0, 0);
        Assertions.assertEquals(expectedWildUnit, WildUnit);
    }

    @Test
    public void testEquals() {
        final var o = new Object();
        Assertions.assertNotEquals(WildUnit, o);
        Assertions.assertEquals(WildUnit, WildUnit);
        final var expectedWildUnit = new WildUnit(WILD_NAME, 2, 1, 0, 0);
        Assertions.assertEquals(expectedWildUnit, WildUnit);
    }

    @Test
    public void hitPointsTest() {
        Assertions.assertEquals(WildUnit.getMaxHp(), WildUnit.getCurrentHp());
        WildUnit.setCurrentHp(2);
        Assertions.assertEquals(2, WildUnit.getCurrentHp());
        WildUnit.setCurrentHp(-1);
        Assertions.assertEquals(0, WildUnit.getCurrentHp());
        WildUnit.setCurrentHp(1);
        Assertions.assertEquals(1, WildUnit.getCurrentHp());
    }

    @Test
    public void copyTest() {
        final var expectedWildUnit = new Player(WILD_NAME, 2, 1, 0, 0);
        final var actualWildUnit = WildUnit.copy();
        // Checks that the copied player have the same parameters as the original
        Assertions.assertEquals(expectedWildUnit, actualWildUnit);
        // Checks that the copied player doesn't reference the same object
        Assertions.assertNotSame(expectedWildUnit, actualWildUnit);
    }

    // region : consistency tests
    @RepeatedTest(100)
    public void hitPointsConsistencyTest() {
        final long testSeed = new Random().nextLong();
        // We're gonna try and set random hit points in [-maxHP * 2, maxHP * 2]
        final int testHP = new Random(testSeed).nextInt(4 * WildUnit.getMaxHp() + 1)
                - 2 * WildUnit.getMaxHp();
        WildUnit.setCurrentHp(testHP);
        Assertions.assertTrue(0 <= WildUnit.getCurrentHp()
                        && WildUnit.getCurrentHp() <= WildUnit.getMaxHp(),
                WildUnit.getCurrentHp() + "is not a valid HP value"
                        + System.lineSeparator() + "Test failed with random seed: "
                        + testSeed);
    }
    @RepeatedTest(100)
    public void rollConsistencyTest() {
        final long testSeed = new Random().nextLong();
        WildUnit.setSeed(testSeed);
        final int roll = WildUnit.roll();
        Assertions.assertTrue(roll >= 1 && roll <= 6,
                roll + "is not in [1, 6]" + System.lineSeparator()
                        + "Test failed with random seed: " + testSeed);
    }
    // endregion
}
