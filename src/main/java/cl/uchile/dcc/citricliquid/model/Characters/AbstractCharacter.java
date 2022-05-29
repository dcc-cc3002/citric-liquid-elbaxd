package cl.uchile.dcc.citricliquid.model.Characters;

import java.util.Random;

public abstract class AbstractCharacter implements ICharacter {

    protected int atk;
    protected int def;
    protected int evd;
    protected String name;
    protected int currentHp;
    protected int maxHp ;

    public AbstractCharacter(String name, int hp, int atk, int def, int evd) {
        this.name = name;
        this.maxHp = currentHp = hp;
        this.atk = atk;
        this.def = def;
        this.evd = evd;
        new Random();
    }
}
