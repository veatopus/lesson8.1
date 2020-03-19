package kg.geektech.game.players;

import java.util.Random;

public class Warrior extends Hero {

    public Warrior(int health, int damage) {
        super(health, damage, SuperAbilty.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        Random r = new Random();
        int criticalDamage = r.nextInt(3) + 2;
        setDamage(getDamage()*criticalDamage);
    }
}