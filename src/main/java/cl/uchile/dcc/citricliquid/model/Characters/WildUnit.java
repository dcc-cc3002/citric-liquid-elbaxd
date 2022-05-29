package cl.uchile.dcc.citricliquid.model.Characters;

public class WildUnit extends AbstractCharacter{


    public WildUnit(String name, int hp, int atk, int def, int evd) {
        super(name, hp, atk, def, evd);
    }

    @Override
    public void increaseStarsBy(int amount) {

    }

    @Override
    public int getStars() {
        return 0;
    }

    @Override
    public void setSeed(long seed) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getMaxHp() {
        return 0;
    }

    @Override
    public int getAtk() {
        return 0;
    }

    @Override
    public int getDef() {
        return 0;
    }

    @Override
    public int getEvd() {
        return 0;
    }

    @Override
    public int getCurrentHp() {
        return 0;
    }

    @Override
    public void setCurrentHp(int newHp) {

    }
}
