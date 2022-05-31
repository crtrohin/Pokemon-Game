public class BattleStats {
    private Integer hp;
    private Integer attack = 0;
    private Integer specialAttack = 0;
    private Integer defense = 0;
    private Integer specialDefense = 0;
    private boolean isStunned = false;
    private boolean dodged = false;
    private Integer abilityOneTime;
    private Integer abilityTwoTime;

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(Integer specialAttack) {
        this.specialAttack = specialAttack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(Integer specialDefense) {
        this.specialDefense = specialDefense;
    }

    public boolean isStunned() {
        return isStunned;
    }

    public boolean dodged() {
        return dodged;
    }

    public void setStunned(boolean stunned) {
        isStunned = stunned;
    }

    public void setDodged(boolean dodged) {
        this.dodged = dodged;
    }

    public Integer getAbilityOneTime() {
        return abilityOneTime;
    }

    public Integer getAbilityTwoTime() {
        return abilityTwoTime;
    }

    public void setAbilityOneTime(Integer abilityOneTime) {
        this.abilityOneTime = abilityOneTime;
    }

    public void setAbilityTwoTime(Integer abilityTwoTime) {
        this.abilityTwoTime = abilityTwoTime;
    }

    public void decreaseAbilityOneTime() {
        this.abilityOneTime--;
    }

    public void decreaseAbilityTwoTime() {
        this.abilityTwoTime--;
    }

    public void loseHp(Integer damage) {
        this.hp -= damage;
    }

    @Override
    public String toString() {
        return "BattleStats{" +
                "hp=" + hp +
                ", attack=" + attack +
                ", specialAttack=" + specialAttack +
                ", defense=" + defense +
                ", specialDefense=" + specialDefense +
                ", isStunned=" + isStunned +
                ", dodged=" + dodged +
                ", abilityOneTime=" + abilityOneTime +
                ", abilityTwoTime=" + abilityTwoTime +
                '}';
    }
}
