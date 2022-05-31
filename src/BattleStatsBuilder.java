import java.util.ArrayList;

public class BattleStatsBuilder {
    private BattleStats battleStats = new BattleStats();

    public BattleStatsBuilder withHp(Integer hp) {
        battleStats.setHp(hp);
        return this;
    }

    public BattleStatsBuilder withAttack(Integer attack) {
        battleStats.setAttack(attack);
        return this;
    }

    public BattleStatsBuilder withSpecialAttack(Integer specialAttack) {
        battleStats.setSpecialAttack(specialAttack);
        return this;
    }

    public BattleStatsBuilder withDefense(Integer defense) {
        battleStats.setDefense(defense);
        return this;
    }

    public BattleStatsBuilder withSpecialDefense(Integer specialDefense) {
        battleStats.setSpecialDefense(specialDefense);
        return this;
    }

    public BattleStatsBuilder withAbilityOneTime(Integer abilityOneTime){
        battleStats.setAbilityOneTime(abilityOneTime);
        return this;
    }

    public BattleStatsBuilder withAbilityTwoTime(Integer abilityTwoTime){
        battleStats.setAbilityTwoTime(abilityTwoTime);
        return this;
    }

    public BattleStats build() {
        return this.battleStats;
    }
}
