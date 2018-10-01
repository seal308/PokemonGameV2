package logic;

import java.util.Random;

import pokemonBattleJUnit.PokemonName;

public class PokeGenerator {
	public Pokemon getRandomPokemon(Trainer trainer) {

		PokemonName randPokeName = null;
		Random randIndex = new Random();
		int index = randIndex.nextInt(PokemonName.values().length);

		PokemonName[] pokemonArray = PokemonName.values();

		randPokeName = pokemonArray[index];

		Pokemon returnPokemon = new Pokemon(randPokeName, trainer);

		return returnPokemon;
	}

	public Pokemon[] getSixRandomPokemon(Trainer trainer) {

		Pokemon[] pokemons = new Pokemon[6];
		for (int i = 0; i < 6; i++)
		{
			pokemons[i] = getRandomPokemon(trainer);
		}
		return pokemons;
	}
}
