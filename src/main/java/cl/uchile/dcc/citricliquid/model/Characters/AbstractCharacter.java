package cl.uchile.dcc.citricliquid.model.Characters;

import cl.uchile.dcc.citricliquid.model.board.AbstractPanel;

import java.util.Random;

public abstract class AbstractCharacter implements ICharacter {
    protected int atk;
    protected int def;
    protected int evd;
    protected String name;
    protected int currentHp;
    protected int maxHp ;
    private Random random = new Random();
    private int stars = 0;
    private AbstractPanel panel;

    public AbstractCharacter(String Name, int hp, int atk, int def, int evd) {
        this.panel = null;
        this.name = Name;
        this.maxHp = currentHp = hp;
        this.atk = atk;
        this.def = def;
        this.evd = evd;
    }
    @Override
    public void increaseStarsBy(final int amount) {
        stars += amount;
    }
    /**
     * Returns this player's star count.
     */
    @Override
    public int getStars() {
        return stars;
    }
    /**
     * Returns a uniformly distributed random value in [1, 6].
     */
    public int roll() {
        return random.nextInt(6) + 1;
    }
    /**
     * Set's the seed for this player's random number generator.
     *
     * <p>The random number generator is used for taking non-deterministic decisions, this method is
     * declared to avoid non-deterministic behaviour while testing the code.
     */
    @Override
    public void setSeed(final long seed) {
        random.setSeed(seed);
    }
    /**
     * Set the new panel where the character will go or be set on.
     */
    public void setPanel(AbstractPanel panel){
        this.panel = panel;}
    /**
     * Get the current panel where the character is.
     */
    public AbstractPanel getPanel(){return this.panel;}
    /**
     * Returns the character's name.
     */
    @Override
    public String getName() {
        return name;
    }
    /**
     * Returns the character's max hit points.
     */
    @Override
    public int getMaxHp() {
        return maxHp;
    }
    /**
     * Returns the current character's attack points.
     */
    @Override
    public int getAtk() {
        return atk;
    }
    /**
     * Returns the current character's defense points.
     */
    @Override
    public int getDef() {
        return def;
    }
    /**
     * Returns the current character's evasion points.
     */
    @Override
    public int getEvd() {
        return evd;
    }
    /**
     * Returns the current hit points of the character.
     */
    @Override
    public int getCurrentHp() {
        return currentHp;
    }
    /**
     * Sets the current character's hit points.
     *
     * <p>The character's hit points have a constraint to always be between 0 and maxHP, both
     * inclusive.
     */
    @Override
    public void setCurrentHp(final int newHp) {
        this.currentHp = Math.max(Math.min(newHp, maxHp), 0);
    }
    /**
     * Reduces this player's star count by a given amount.
     *
     * <p>The star count will must always be greater or equal to 0
     */
    public void reduceStarsBy(final int amount) {
        stars = Math.max(0, stars - amount);
    }
    /**
     * Returns a copy of this character.
     */
    public Player copy() {
        return new Player(name, maxHp, atk, def, evd);
    }
}
