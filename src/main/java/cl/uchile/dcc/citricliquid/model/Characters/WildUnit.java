package cl.uchile.dcc.citricliquid.model.Characters;

import java.util.Random;

public class WildUnit extends AbstractCharacter{

    private final Random random;
    private int stars;
    private int currentHp;

    public WildUnit(String name, int hp, int atk, int def, int evd) {
        super();
        random = new Random();
    }

    @Override
    public void increaseStarsBy(int amount) {

    }

    @Override
    public int getStars() {
        return stars;
    }

    @Override
    public int roll() {
        return random.nextInt(6) + 1;
    }

    @Override
    public void setSeed(long seed) { random.setSeed(seed);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMaxHp() {
        return maxHp;
    }

    @Override
    public int getAtk() {
        return atk;
    }

    @Override
    public int getDef() {
        return def;
    }

    @Override
    public int getEvd() {
        return evd;
    }

    @Override
    public int getCurrentHp() {
        return currentHp;
    }

    @Override
    public void setCurrentHp(int newHp) {
        this.currentHp = Math.max(Math.min(newHp, maxHp), 0);
    }

    @Override
    public WildUnit copy() {
        return new WildUnit(name, maxHp, atk, def, evd);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final WildUnit WildUnit)) {
            return false;
        }
        return getMaxHp() == WildUnit.getMaxHp()
                && getAtk() == WildUnit.getAtk()
                && getDef() == WildUnit.getDef()
                && getEvd() == WildUnit.getEvd()
                && getStars() == WildUnit.getStars()
                && getCurrentHp() == WildUnit.getCurrentHp()
                && getName().equals(WildUnit.getName());
    }
}
