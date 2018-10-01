package presentation;

import logic.MoveEfficiencies;
import logic.PokemonOld;
import pokemonBattleJUnit.PokemonTypeException;

public class Scene {
	public void start() {
		System.out.println("Drew is a new trainer from Sainow town."
				+ "\nWhile walking the path to Estreni town he hear's a voice");
		System.out.println("\"Prepare for trouble ....\"");
		System.out.println("Jessie from team rocket pops from behind a tree");
		System.out.println("\"ohh ehh James is not here... TIME TO BATTLE TWERP!!!\"");

		PokemonOld[] pokemons = new PokemonOld[15];

		try
		{
			pokemons[0] = new PokemonOld("bulbasaur", "grass");
			pokemons[1] = new PokemonOld("squirtle", "water");
			pokemons[2] = new PokemonOld("charmander", "fire");
			pokemons[3] = new PokemonOld("pikachu", "electric");
			pokemons[4] = new PokemonOld("dratini", "dragon");
			pokemons[5] = new PokemonOld("haunter", "ghost");
			pokemons[6] = new PokemonOld("abra", "psychic");
			pokemons[7] = new PokemonOld("butterfree", "bug");
			pokemons[8] = new PokemonOld("muk", "poison");
			pokemons[9] = new PokemonOld("eevee", "normal");
			pokemons[10] = new PokemonOld("dewgong", "ice");
			pokemons[11] = new PokemonOld("machamp", "fighting");
			pokemons[12] = new PokemonOld("diglett", "ground");
			pokemons[13] = new PokemonOld("pidgey", "flying");
			pokemons[14] = new PokemonOld("onix", "rock");

		} catch (PokemonTypeException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		MoveEfficiencies me = new MoveEfficiencies();
	}
}
