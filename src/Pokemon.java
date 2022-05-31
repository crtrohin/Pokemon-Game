import java.util.ArrayList;

public class Pokemon {
    private String name;
    private Integer hp;
    private Integer attack = 0;
    private Integer specialAttack = 0;
    private Integer defense;
    private Integer specialDefense;
    private ArrayList<Ability> abilities;
    private ArrayList<Item> items;
    private BattleStats battleStats;
    private Observer observer;

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

    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<Ability> abilities) {
        this.abilities = abilities;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public BattleStats getBattleStats() {
        return battleStats;
    }

    public Observer getObserver() {
        return observer;
    }

    public void subscribe(Observer observer) {
        this.observer = observer;
    }

    public boolean hasSpecialAttack() {
        if (specialAttack != 0) {
            return true;
        }
        return false;
    }


    public void win() {
        this.hp++;
        this.defense++;
        this.specialDefense++;
        if (this.hasSpecialAttack()) {
            this.specialAttack++;
        } else {
            this.attack++;
        }
    }


    public Item getTotalItem() {
        Integer totalHp = 0;
        Integer totalAttack = 0, totalSpecialAttack = 0;
        Integer totalDefense = 0, totalSpecialDefense = 0;

        for (Item item : items) {
            totalHp += item.getHp();
            totalAttack += item.getAttack();
            totalSpecialAttack += item.getSpecialAttack();
            totalDefense += item.getDefense();
            totalSpecialDefense += item.getSpecialDefense();
        }

        Item totalItem = new Item(null, totalHp,totalAttack, totalSpecialAttack, totalDefense, totalSpecialDefense);

        return totalItem;
    }

    public void prepareBattleStats() {
        Item totalItem = getTotalItem();
        if (this.hasSpecialAttack()) {
            totalItem.setAttack(0);
        } else {
            totalItem.setSpecialAttack(0);
        }
        this.battleStats = new BattleStatsBuilder()
                .withHp(this.hp + totalItem.getHp())
                .withAttack(this.attack + totalItem.getAttack())
                .withSpecialAttack(this.specialAttack + totalItem.getSpecialAttack())
                .withDefense(this.defense + totalItem.getDefense())
                .withSpecialDefense(this.specialDefense + totalItem.getSpecialDefense())
                .withAbilityOneTime(0)
                .withAbilityTwoTime(0)
                .build();
    }

    public boolean isDead() {
        if (this.getBattleStats().getHp() <= 0) {
            return true;
        }
        return false;
    }

    public void normalAttack(Pokemon opponent) {
        Integer damage = 0;
        if (!opponent.getBattleStats().dodged()) {
            damage = this.getBattleStats().getAttack() - opponent.getBattleStats().getDefense();
            if (damage > opponent.getBattleStats().getHp()) {
                damage = opponent.getBattleStats().getHp();
            } else if (damage <= 0) {
                damage = 0;
            }
        } else {
            opponent.getBattleStats().setDodged(false);
        }
        opponent.loseHp(damage, this);
    }

    public void specialAttack(Pokemon opponent) {
        Integer damage = 0;
        if (!opponent.getBattleStats().dodged()) {
            damage = this.getBattleStats().getSpecialAttack() - opponent.getBattleStats().getSpecialDefense();
            if (damage > opponent.getBattleStats().getHp()) {
                damage = opponent.getBattleStats().getHp();
            } else if (damage <= 0) {
                damage = 0;
            }
        } else {
            opponent.getBattleStats().setDodged(false);
        }
        opponent.loseHp(damage, this);
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void abilityOne(Pokemon opponent) {
        this.getBattleStats().setAbilityOneTime(this.getAbilities().get(0).getCooldown());
        boolean getStun = getAbilities().get(0).hasStun();
        opponent.getBattleStats().setStunned(getStun);
        boolean getDogde = getAbilities().get(0).hasDodge();
        this.getBattleStats().setDodged(getDogde);
        Integer damage = 0;
        if (!opponent.getBattleStats().dodged()) {
            damage = this.getAbilities().get(0).getDamage();
            if (opponent.getBattleStats().getHp() - damage < 0) {
                damage = opponent.getBattleStats().getHp();
            }
        } else {
            opponent.getBattleStats().setDodged(false);
        }
        opponent.loseHp(damage, this);
    }

    public void abilityTwo(Pokemon opponent) {
        this.getBattleStats().setAbilityTwoTime(this.getAbilities().get(1).getCooldown());
        boolean getStun = getAbilities().get(1).hasStun();
        opponent.getBattleStats().setStunned(getStun);
        boolean getDogde = getAbilities().get(1).hasDodge();
        this.getBattleStats().setDodged(getDogde);
        Integer damage = 0;
        if (!opponent.getBattleStats().dodged()) {
            damage = this.getAbilities().get(1).getDamage();
            if (opponent.getBattleStats().getHp() - damage < 0) {
                damage = opponent.getBattleStats().getHp();
            }
        } else {
            opponent.getBattleStats().setDodged(false);
        }
        opponent.loseHp(damage, this);

    }

    public void loseHp(Integer damage, Pokemon pokemon) {
        this.getBattleStats().loseHp(damage);
    }


    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", attack=" + attack +
                ", specialAttack=" + specialAttack +
                ", defense=" + defense +
                ", specialDefense=" + specialDefense +
                ", abilities=" + abilities +
                ", items=" + items +
                '}';
    }
}
