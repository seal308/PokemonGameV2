package presentation;

import logic.Pokemon;
import pokemonBattleJUnit.Type;

public class Scene {
	public void start() {
		System.out.println("Drew is a new trainer from Sainow town."
				+ "\nWhile walking the path to Estreni town he hear's a voice");
		System.out.println("\"Prepare for trouble ....\"");
		System.out.println("Jessie from team rocket pops from behind a tree");
		System.out.println("\"ohh ehh James is not here... TIME TO BATTLE TWERP!!!\"");

		Pokemon[] pokemons = new Pokemon[15];

		pokemons[0] = new Pokemon("bulbasaur", Type.GRASS);
		pokemons[1] = new Pokemon("squirtle", Type.WATER);
		pokemons[2] = new Pokemon("charmander", Type.FIRE);
		pokemons[3] = new Pokemon("pikachu", Type.ELECTRIC);
		pokemons[4] = new Pokemon("dratini", Type.DRAGON);
		pokemons[5] = new Pokemon("haunter", Type.GHOST);
		pokemons[6] = new Pokemon("abra", Type.PSYCHIC);
		pokemons[7] = new Pokemon("butterfree", Type.BUG);
		pokemons[8] = new Pokemon("muk", Type.POISON);
		pokemons[9] = new Pokemon("eevee", Type.NORMAL);
		pokemons[10] = new Pokemon("dewgong", Type.ICE);
		pokemons[11] = new Pokemon("machamp", Type.FIGHTING);
		pokemons[12] = new Pokemon("diglett", Type.GROUND);
		pokemons[13] = new Pokemon("pidgey", Type.FLYING);
		pokemons[14] = new Pokemon("onix", Type.ROCK);

	}
}
