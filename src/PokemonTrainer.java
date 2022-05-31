import java.util.ArrayList;
import java.util.Random;

public class PokemonTrainer {
    private final String name;
    private final Integer age;
    private final ArrayList<Pokemon> pokemons;

    public PokemonTrainer(String name, Integer age, ArrayList<Pokemon> pokemons) {
        this.name = name;
        this.age = age;
        this.pokemons = pokemons;
    }


    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public Command chooseCommand(Pokemon pokemon1, Pokemon pokemon2) {
        boolean checkAbility1 = (pokemon1.getBattleStats().getAbilityOneTime() == 0);
        boolean checkAbility2 = (pokemon1.getBattleStats().getAbilityTwoTime() == 0);
        boolean again;
        Integer commandNr = 0;
        do {
            again = false;
            commandNr = 1 + (int)(Math.random() * 3);
            if (commandNr == 1 && checkAbility1 == false) {
                again = true;
            }
            if (commandNr == 2 && checkAbility2 == false) {
                again = true;
            }
        } while (again);
        if (checkAbility1 == false) {
            pokemon1.getBattleStats().decreaseAbilityOneTime();
        }
        if (checkAbility2 == false) {
            pokemon1.getBattleStats().decreaseAbilityTwoTime();
        }
        switch (commandNr) {
            case 1:
                return new Ability1(pokemon1, pokemon2);
                //abilitate1
            case 2:
                return new Ability2(pokemon1, pokemon2);
                //abilitate2
            case 3:
                if (pokemon1.hasSpecialAttack()) {
                    return new SpecialAttack(pokemon1, pokemon2);
                }
                return new NormalAttack(pokemon1, pokemon2);
                //atac normal/special
        }
        return null;
    }

    @Override
    public String toString() {
        return "PokemonTrainer -> " + '\n' +
                "name : " + name + '\n' +
                "age : "  + age + '\n' +
                "pokemons : " + pokemons + '\n';
    }

}
