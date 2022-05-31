public class PokemonBattle implements Runnable{
    Pokemon pokemon1, pokemon2;
    PokemonTrainer trainer1;

    public PokemonBattle(Pokemon pokemon1, Pokemon pokemon2, PokemonTrainer trainer1) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.trainer1 = trainer1;
    }

    @Override
    public void run() {
        boolean isStunned1;
        while (!pokemon2.isDead()) {
            isStunned1 = pokemon1.getBattleStats().isStunned();
            if (!isStunned1) {
                Command pokemon1Command = trainer1.chooseCommand(pokemon1, pokemon2);
                pokemon1Command.execute();
            } else {
                pokemon1.getBattleStats().setStunned(false);
            }
        }
    }
}
