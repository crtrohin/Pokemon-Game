public class Item {
    private String name;
    private Integer hp = 0;
    private Integer attack = 0;
    private Integer specialAttack = 0;
    private Integer defense = 0;
    private Integer specialDefense = 0;

    public Item(String name, Integer hp, Integer attack, Integer specialAttack, Integer defense, Integer specialDefense) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.specialAttack = specialAttack;
        this.defense = defense;
        this.specialDefense = specialDefense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", attack=" + attack +
                ", specialAttack=" + specialAttack +
                ", defense=" + defense +
                ", specialDefense=" + specialDefense +
                '}';
    }
}
