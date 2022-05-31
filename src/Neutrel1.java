import java.lang.reflect.Array;
import java.util.ArrayList;

public class Neutrel1 extends Pokemon{
    private String name;
    private Integer hp;
    private Integer attack = 0;
    private Integer specialAttack = 0;
    private Integer defense;
    private Integer specialDefense;
    private ArrayList<Ability> abilities;
    private BattleStats battleStats;

    public Neutrel1 () {
        this.name = "Neutrel1";
        this.hp = 10;
        this.attack = 3;
        this.defense = 1;
        this.specialDefense = 1;
        this.abilities = null;
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
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getHp() {
        return hp;
    }

    @Override
    public void setHp(Integer hp) {
        this.hp = hp;
    }

    @Override
    public Integer getAttack() {
        return attack;
    }

    @Override
    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    @Override
    public Integer getDefense() {
        return defense;
    }

    @Override
    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    @Override
    public Integer getSpecialDefense() {
        return specialDefense;
    }

    @Override
    public void setSpecialDefense(Integer specialDefense) {
        this.specialDefense = specialDefense;
    }

    @Override
    public BattleStats getBattleStats() {
        return battleStats;
    }

    public void setBattleStats(BattleStats battleStats) {
        this.battleStats = battleStats;
    }

    @Override
    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<Ability> abilities) {
        this.abilities = abilities;
    }

}
