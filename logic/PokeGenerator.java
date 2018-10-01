package logic;

import java.util.Random;

import pokemonBattleJUnit.PokemonName;

public class PokeGenerator {
	public Pokemon getRandomPokemon() {

		PokemonName randPokeName = null;
		Random randIndex = new Random();
		int index = randIndex.nextInt(PokemonName.values().length);

		PokemonName[] pokemonArray = PokemonName.values();

		randPokeName = pokemonArray[index];

		Pokemon returnPokemon = new Pokemon(randPokeName);

		return returnPokemon;
	}

	public Pokemon[] getSixRandomPokemon() {
		Pokemon[] pokemons = new Pokemon[6];
		for (int i = 0; i < 6; i++)
		{
			pokemons[i] = getRandomPokemon();
		}
		return pokemons;
	}
}
