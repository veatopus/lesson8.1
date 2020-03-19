package kg.geektech.game.general;

import kg.geektech.game.players.*;

public class RPG_Game {

    public static void startGame() {
        Boss boss = new Boss(1000, 100);
        Magic magic = new Magic(100, 70);
        Warrior warrior = new Warrior(250, 50);
        Medic medic = new Medic(150, 0, 50);
        Hunter hunter = new Hunter(100, 70);
        Medic youngMedic = new Medic(120, 0, 10);

        Hero[] heroes = {magic, warrior, medic, hunter, youngMedic};

        printStatistics(boss, heroes);
        while (!isFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        heroesHit(boss, heroes);
        bossHit(boss, heroes);
        heroesApplyAbilities(boss, heroes);
        printStatistics(boss, heroes);
    }

    private static boolean isFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && !(heroes[i] instanceof Medic) && boss.getHealth() > 0) {
                if (boss.getHealth() - heroes[i].getDamage() < 0) {
                    boss.setHealth(0);
                } else {
                    boss.setHealth(boss.getHealth() - heroes[i].getDamage());
                }
            } else {
                if (boss.getHealth() < 0) {
                    boss.setHealth(0);
                }
            }
            if (heroes[i] instanceof Warrior){
                heroes[i].setDamage(50);
            }
        }
    }

    private static void heroesApplyAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].applySuperAbility(boss, heroes);

            }
        }
    }

    private static void bossHit(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0) {
                    if (heroes[i].getHealth() - boss.getDamage() < 0) {
                        if (heroes[i] instanceof Hunter && (heroes[i].getHealth() - boss.getDamage()) > 0) {
                            heroes[i].setHealth(heroes[i].getHealth() - (boss.getDamage() - ((boss.getDamage() * 20) / 100)));
                        } else {
                            heroes[i].setHealth(0);
                        }
                    } else {
                        if (heroes[i] instanceof Hunter) {
                            heroes[i].setHealth(heroes[i].getHealth() - (boss.getDamage() - ((boss.getDamage() * 20) / 100)));
                        } else {
                            heroes[i].setHealth(heroes[i].getHealth()
                                    - boss.getDamage());
                        }
                    }
                }
            }
        } else {
            boss.setHealth(0);
        }
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("_________________");
        if (boss.getHealth() < 0) {
            boss.setHealth(0);
        }
        System.out.println("Boss health: " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName()
                    + " health: " + heroes[i].getHealth());
        }
        System.out.println("_________________");
    }
}
