package cl.uchile.dcc.citricliquid.model.Characters;

import java.util.Random;

public class BossUnit extends AbstractCharacter {

    private final Random random;
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
        random = new Random();
        stars = 0;
    }
}
