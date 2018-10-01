package presentation;

import logic.Pokemon;
import pokemonBattleJUnit.PokemonName;

public class Scene {
	public void start() {
		System.out.println("Drew is a new trainer from Sainow town."
				+ "\nWhile walking the path to Estreni town he hear's a voice");
		System.out.println("\"Prepare for trouble ....\"");
		System.out.println("Jessie from team rocket pops from behind a tree");
		System.out.println("\"ohh ehh James is not here... TIME TO BATTLE TWERP!!!\"");

		Pokemon[] pokemons = new Pokemon[15];

		pokemons[0] = new Pokemon(PokemonName.BULBASAUR);
		pokemons[1] = new Pokemon(PokemonName.SQUIRTLE);
		pokemons[2] = new Pokemon(PokemonName.CHARMANDER);
		pokemons[3] = new Pokemon(PokemonName.PIKACHU);
		pokemons[4] = new Pokemon(PokemonName.DRATINI);
		pokemons[5] = new Pokemon(PokemonName.HAUNTER);
		pokemons[6] = new Pokemon(PokemonName.ABRA);
		pokemons[7] = new Pokemon(PokemonName.BUTTERFREE);
		pokemons[8] = new Pokemon(PokemonName.MUK);
		pokemons[9] = new Pokemon(PokemonName.EEVEE);
		pokemons[10] = new Pokemon(PokemonName.DEWGONG);
		pokemons[11] = new Pokemon(PokemonName.MACHAMP);
		pokemons[12] = new Pokemon(PokemonName.DIGLETT);
		pokemons[13] = new Pokemon(PokemonName.PIDGEY);
		pokemons[14] = new Pokemon(PokemonName.ONIX);

	}
}
