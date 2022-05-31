public class NormalAttack implements Command {
    Pokemon pokemon1, pokemon2;

    public NormalAttack(Pokemon pokemon1, Pokemon pokemon2) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }

    public void execute() {
        pokemon1.getObserver().writeCommand("Normal Attack");
        pokemon1.normalAttack(pokemon2);
    }
}
