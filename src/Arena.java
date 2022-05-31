import com.google.gson.Gson;

import java.io.*;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class NeutrelFactory {

    public Pokemon createNeutrelPokemon(String neutrelType) {
        switch(neutrelType) {
            case "Neutrel1" :
                return new Neutrel1();
            case "Neutrel2" :
                return new Neutrel2();
            default:
                return null;
        }
    }
}

class Observer {
    Pokemon pokemon;

    public Observer(Pokemon pokemon) {
        this.pokemon = pokemon;
        this.pokemon.subscribe(this);
    }

    public void updateStats() {
        System.out.println(pokemon.getName() + "'s battle stats : " + pokemon.getBattleStats());
    }

    public void writeCommand(String command) {
        System.out.println(pokemon.getName() + " uses " + command);
    }

    public void battleOutcome(Pokemon opponent) {
        System.out.println(opponent.getName() + " wins");
    }

    public void pokemonInfo() {
        System.out.println(pokemon);
    }
}


public class Arena {


    public PokemonTrainer[] readFromFile() {
        Gson gson = new Gson();
        PokemonTrainer[] trainers = new PokemonTrainer[2];
        try (Reader reader = new FileReader("input/game1.json")) {
            trainers = gson.fromJson(reader, PokemonTrainer[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return trainers;
        }
    }

    public void neutrel1Battle(PokemonTrainer trainer, Pokemon pokemon) {
        NeutrelFactory neutrelFactory = new NeutrelFactory();
        Neutrel1 neutrel1 = (Neutrel1) neutrelFactory.createNeutrelPokemon("Neutrel1");
        Observer observer = new Observer(neutrel1);
        neutrel1.subscribe(observer);
        pokemon.prepareBattleStats();
        neutrel1.prepareBattleStats();
        boolean neutrel1Stunned;
        Command neutrel1Command, pokemonCommand;
        while (!pokemon.isDead() && !neutrel1.isDead()) {
            neutrel1Stunned = neutrel1.getBattleStats().isStunned();
            pokemonCommand = trainer.chooseCommand(pokemon, neutrel1);
            pokemonCommand.execute();
            if (!neutrel1Stunned) {
                neutrel1Command = new NormalAttack(neutrel1, pokemon);
                neutrel1Command.execute();
            } else {
                System.out.println("Neutrel1 is stunned");
                if (!neutrel1.getBattleStats().isStunned()) {
                    neutrel1.getBattleStats().setStunned(false);
                }
            }
            pokemon.getObserver().updateStats();
            neutrel1.getObserver().updateStats();
        }

        if (neutrel1.isDead()) {
            neutrel1.getObserver().battleOutcome(pokemon);
            pokemon.win();
            pokemon.getObserver().pokemonInfo();
        }
    }

    public void neutrel2Battle(PokemonTrainer trainer, Pokemon pokemon) {
        NeutrelFactory neutrelFactory = new NeutrelFactory();
        Neutrel2 neutrel2 = (Neutrel2) neutrelFactory.createNeutrelPokemon("Neutrel2");
        Observer observer = new Observer(neutrel2);
        neutrel2.subscribe(observer);
        pokemon.prepareBattleStats();
        neutrel2.prepareBattleStats();
        boolean neutrel2Stunned;
        Command pokemonCommand, neutrel2Command;
        while (!pokemon.isDead() && !neutrel2.isDead()) {
            neutrel2Stunned = neutrel2.getBattleStats().isStunned();
            pokemonCommand = trainer.chooseCommand(pokemon, neutrel2);
            pokemonCommand.execute();
            if (!neutrel2Stunned) {
                neutrel2Command = new NormalAttack(neutrel2, pokemon);
                neutrel2Command.execute();
            } else {
                System.out.println("Neutrel2 is stunned");
                if (!neutrel2.getBattleStats().isStunned()) {
                    neutrel2.getBattleStats().setStunned(false);
                }
            }
            pokemon.getObserver().updateStats();
            neutrel2.getObserver().updateStats();
        }
        if (neutrel2.isDead()) {
            neutrel2.getObserver().battleOutcome(pokemon);
            pokemon.win();
            pokemon.getObserver().pokemonInfo();
        }
    }


    public void chooseEvent(Pokemon pokemon1, PokemonTrainer trainer1, Pokemon pokemon2, PokemonTrainer trainer2)  {
        Integer eventNr;
        do {
            eventNr = 1 + (int) (Math.random() * 3);
            switch (eventNr) {
                case 1:
                    System.out.println("Neutrel1 battle");
                    neutrel1Battle(trainer1, pokemon1);
                    neutrel1Battle(trainer2, pokemon2);
                    break;
                case 2:
                    System.out.println("Neutrel2 battle");
                    neutrel2Battle(trainer1, pokemon1);
                    neutrel2Battle(trainer2, pokemon2);
                    break;
                case 3:
                    System.out.println("Pokemon1 vs pokemon2 battle");
                    pokemon1.prepareBattleStats();
                    pokemon2.prepareBattleStats();
                    ExecutorService executor = Executors.newFixedThreadPool(2);
                    executor.execute(new PokemonBattle(pokemon1, pokemon2, trainer1));
                    executor.execute(new PokemonBattle(pokemon2, pokemon1, trainer2));
                    executor.shutdown();
                    while (!executor.isTerminated()) {

                    }
                    break;
            }
        } while (eventNr != 3);
    }


    public static void main(String[] args) {
        Arena arena = new Arena();
        PokemonTrainer[] trainers = arena.readFromFile();

        for (Pokemon pokemon : trainers[0].getPokemons()) {
            Observer observer = new Observer(pokemon);
            pokemon.subscribe(observer);
        }

        for (Pokemon pokemon : trainers[1].getPokemons()) {
            Observer observer = new Observer(pokemon);
            pokemon.subscribe(observer);
        }

        for (int i = 0; i < 3; i++) {
            Pokemon pokemon1 = trainers[0].getPokemons().get(i);
            Pokemon pokemon2 = trainers[1].getPokemons().get(i);

            arena.chooseEvent(pokemon1, trainers[0], pokemon2, trainers[1]);
        }

    }
}
