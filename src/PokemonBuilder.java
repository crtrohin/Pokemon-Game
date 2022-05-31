import java.util.ArrayList;

public class PokemonBuilder {
    private Pokemon pokemon = new Pokemon();

    public Pokemon build () {
        return pokemon;
    }

    public PokemonBuilder withName(String name) {
        pokemon.setName(name);
        return this;
    }

    public PokemonBuilder withHP(Integer hp) {
        pokemon.setHp(hp);
        return this;
    }

    public PokemonBuilder withAttack(Integer attack) {
        pokemon.setAttack(attack);
        return this;
    }

    public PokemonBuilder withSpecialAttack(Integer specialAttack) {
        pokemon.setSpecialAttack(specialAttack);
        return this;
    }

    public PokemonBuilder withDefense(Integer defense) {
        pokemon.setDefense(defense);
        return this;
    }

    public PokemonBuilder withSpecialDefense(Integer specialDefense) {
        pokemon.setSpecialDefense(specialDefense);
        return this;
    }

    public PokemonBuilder withAbilities(ArrayList<Ability> abilities) {
        pokemon.setAbilities(abilities);
        return this;
    }

    public PokemonBuilder withItems(ArrayList<Item> items) {
        pokemon.setItems(items);
        return this;
    }

}
