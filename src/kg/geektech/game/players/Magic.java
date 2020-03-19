package kg.geektech.game.players;

public class Magic extends Hero {

    public Magic(int health, int damage) {
        super(health, damage, SuperAbilty.BOOST);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].setDamage(heroes[i].getDamage() + 20);
        }
    }
}
/*
Magic должен увеличивать атаку каждого героя после каждого раунда на n-ное количество
 */