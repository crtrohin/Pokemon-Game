public class Ability2 implements Command{
    Pokemon pokemon1, pokemon2;

    public Ability2(Pokemon pokemon1, Pokemon pokemon2) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }

    public void execute() {
        pokemon1.getObserver().writeCommand("Ability2");
        pokemon1.abilityTwo(pokemon2);
    }
}
