package cl.uchile.dcc.citricliquid.model.Characters;

import java.util.Random;

public class WildUnit extends AbstractCharacter{

    private final Random random;
    private final int stars;
    private int currentHp;

    /**
     * Creates a new wild unit.
     *
     * @param name
     *     the wild unit's name.
     * @param hp
     *     the initial (and max) hit points of the wild unit.
     * @param atk
     *     the base damage the wild unit does.
     * @param def
     *     the base defense of the wild unit.
     * @param evd
     *     the base evasion of the wild unit.
     */
    public WildUnit(String name, int hp, int atk, int def, int evd) {
        super(name,hp,atk,def,evd);
        random = new Random();
        stars = 0;
    }
}
