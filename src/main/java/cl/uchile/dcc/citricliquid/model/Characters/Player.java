package cl.uchile.dcc.citricliquid.model.Characters;

import java.util.Random;

/**
 * This class represents a player in the game 99.7% Citric Liquid.
 *
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater
 *     Muñoz</a>.
 * @version 1.1.222804
 * @since 1.0
 */
public class Player extends AbstractCharacter {
  private final Random random;
  private int normaLevel;
  private int stars;
  private int wins;

  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name.
   * @param hp
   *     the initial (and max) hit points of the character.
   * @param atk
   *     the base damage the character does.
   * @param def
   *     the base defense of the character.
   * @param evd
   *     the base evasion of the character.
   */
  public Player(final String name, final int hp, final int atk, final int def,
                final int evd) {
    super(name,hp,atk,def,evd);
    this.name = name;
    this.maxHp = currentHp = hp;
    this.atk = atk;
    this.def = def;
    this.evd = evd;
    random = new Random();
    normaLevel = 1;
    stars = 0;
    wins = 0;
  }

  /**
   * Increases this player's wins count by an amount.
   */
  public void increaseWinsBy(final int amount) {
    wins += amount;
  }

  /**
   * Returns this player's wins count.
   */
  public int getWins() {
    return wins;
  }

  /**
   * Increases this player's star count by an amount.
   */
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
   * Returns the current norma level.
   */
  public int getNormaLevel() {
    return normaLevel;
  }

  /**
   * Performs a norma clear action; the {@code norma} counter increases in 1.
   */
  public void normaClear() {
    normaLevel++;
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

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Player player)) {
      return false;
    }
    return getMaxHp() == player.getMaxHp()
           && getAtk() == player.getAtk()
           && getDef() == player.getDef()
           && getEvd() == player.getEvd()
           && getNormaLevel() == player.getNormaLevel()
           && getStars() == player.getStars()
           && getCurrentHp() == player.getCurrentHp()
           && getName().equals(player.getName());
  }

  /**
   * Returns a copy of this character.
   */
  public Player copy() {
    return new Player(name, maxHp, atk, def, evd);
  }
}
