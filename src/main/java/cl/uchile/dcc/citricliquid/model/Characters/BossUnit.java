package cl.uchile.dcc.citricliquid.model.Characters;

import java.util.Random;

public class BossUnit extends AbstractCharacter {

    private final Random random;
    private int stars;
    private int currentHp;

    public BossUnit(String name, int hp, int atk, int def, int evd) {
        super(name,hp,atk,def,evd);
        random = new Random();
    }

    @Override
    public void increaseStarsBy(int amount) {
        stars += amount;
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
    public void setSeed(long seed) {
        random.setSeed(seed);
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
    public BossUnit copy() {
        return new BossUnit(name, maxHp, atk, def, evd);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final BossUnit BossUnit)) {
            return false;
        }
        return getMaxHp() == BossUnit.getMaxHp()
                && getAtk() == BossUnit.getAtk()
                && getDef() == BossUnit.getDef()
                && getEvd() == BossUnit.getEvd()
                && getStars() == BossUnit.getStars()
                && getCurrentHp() == BossUnit.getCurrentHp()
                && getName().equals(BossUnit.getName());
}
}
