package cl.uchile.dcc.citricliquid.model.Characters;

import java.util.Random;

public class BossUnit extends AbstractCharacter {
    private int stars;
    private int currentHp;

    /**
     * Creates a new boss.
     *
     * @param name
     *     the boss's name.
     * @param hp
     *     the initial (and max) hit points of the boss.
     * @param atk
     *     the base damage the boss does.
     * @param def
     *     the base defense of the boss.
     * @param evd
     *     the base evasion of the boss.
     */
    public BossUnit(String name, int hp, int atk, int def, int evd) {
        super(name,hp,atk,def,evd);
        stars = 0;
        currentHp = hp;
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
