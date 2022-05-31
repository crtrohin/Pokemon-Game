public class SpecialAttack implements Command{
    Pokemon pokemon1, pokemon2;

    public SpecialAttack(Pokemon pokemon1, Pokemon pokemon2) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }

    public void execute() {
        pokemon1.getObserver().writeCommand("Special Attack");
        pokemon1.specialAttack(pokemon2);
    }
}
