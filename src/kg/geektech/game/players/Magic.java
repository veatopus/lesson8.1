package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Magic extends Hero {

    public Magic(int health, int damage) {
        super(health, damage, SuperAbilty.BOOST);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] instanceof Warrior) {
                RPG_Game.damageWarrior += 20;
            } else {
                heroes[i].setDamage(heroes[i].getDamage() + 20);
            }
        }
    }
}