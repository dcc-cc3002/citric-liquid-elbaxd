package cl.uchile.dcc.citricliquid.model.Characters;

import java.util.Random;

public interface ICharacter {

    /**
     * Increases this player's star count by an amount.
     */
    void increaseStarsBy(int amount);

    /**
     * Returns this character's star count.
     */
    public int getStars();
    /**
     * Returns a uniformly distributed random value in [1, 6].
     */
    public int roll();
    /**
     * Set's the seed for this player's random number generator.
     *
     * <p>The random number generator is used for taking non-deterministic decisions, this method is
     * declared to avoid non-deterministic behaviour while testing the code.
     */
    public void setSeed(final long seed);
    /**
     * Returns the object's name.
     */
    public String getName();

    /**
     * Returns the character's max hit points.
     */
    public int getMaxHp();

    /**
     * Returns the current character's attack points.
     */
    public int getAtk();

    /**
     * Returns the current character's defense points.
     */
    public int getDef();

    /**
     * Returns the current character's evasion points.
     */
    public int getEvd();

    /**
     * Returns the current hit points of the character.
     */
    public int getCurrentHp();

    /**
     * Sets the current character's hit points.
     *
     * <p>The character's hit points have a constraint to always be between 0 and maxHP, both
     * inclusive.
     */
    public void setCurrentHp(final int newHp);

    /**
     * Returns a copy of the object
     */
    public AbstractCharacter copy();
}
