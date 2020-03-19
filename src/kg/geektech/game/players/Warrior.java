package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

import java.util.Random;

public class Warrior extends Hero {

    public Warrior(int health, int damage) {
        super(health, damage, SuperAbilty.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        setDamage(RPG_Game.damageWarrior);
        Random r = new Random();
        int criticalDamage = r.nextInt(3) + 2;
        setDamage(getDamage()*criticalDamage);
    }
}