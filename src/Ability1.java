public class Ability1 implements Command{
    Pokemon pokemon1, pokemon2;

    public Ability1(Pokemon pokemon1, Pokemon pokemon2) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }

    public void execute() {
        pokemon1.getObserver().writeCommand("Ability1");
        pokemon1.abilityOne(pokemon2);
    }
}
