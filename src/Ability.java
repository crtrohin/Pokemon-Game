public class Ability {
    private Integer damage;
    private boolean stun;
    private boolean dodge;
    private Integer cooldown;

    public Ability(Integer damage, boolean stun, boolean dodge, Integer cooldown) {
        this.damage = damage;
        this.stun = stun;
        this.dodge = dodge;
        this.cooldown = cooldown;
    }

    public Integer getDamage() {
        return damage;
    }

    public boolean hasStun() {
        return stun;
    }

    public boolean hasDodge() {
        return dodge;
    }

    public Integer getCooldown() {
        return cooldown;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "damage=" + damage +
                ", stun=" + stun +
                ", dodge=" + dodge +
                ", cooldown=" + cooldown +
                '}';
    }
}
