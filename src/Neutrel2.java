public class Neutrel2 extends Pokemon{

    private String name;
    private Integer hp;
    private Integer attack = 0;
    private Integer defense;
    private Integer specialDefense;
    private BattleStats battleStats;

    public Neutrel2 () {
        this.name = "Neutrel2";
        this.hp = 20;
        this.attack = 4;
        this.defense = 1;
        this.specialDefense = 1;
    }

    @Override
    public void prepareBattleStats() {
        this.battleStats = new BattleStatsBuilder()
                .withHp(this.hp)
                .withAttack(this.attack)
                .withDefense(this.defense)
                .withSpecialDefense(this.specialDefense)
                .build();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getHp() {
        return hp;
    }

    @Override
    public Integer getAttack() {
        return attack;
    }

    @Override
    public Integer getDefense() {
        return defense;
    }

    @Override
    public Integer getSpecialDefense() {
        return specialDefense;
    }

    @Override
    public BattleStats getBattleStats() {
        return battleStats;
    }
}
