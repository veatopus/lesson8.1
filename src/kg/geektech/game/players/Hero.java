package kg.geektech.game.players;

public abstract class Hero extends GameEntity
        implements HavingSuperAbility {
    private SuperAbilty superAbilty;

    public Hero(int health, int damage, SuperAbilty superAbilty) {
        super(health, damage);
        this.superAbilty = superAbilty;
    }
}
