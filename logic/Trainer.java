package logic;

import java.util.ArrayList;
import java.util.Arrays;

public class Trainer {
	private String name;
	private PokeGenerator pokeGen;
	private Pokemon currPokemon;
	private ArrayList<Pokemon> pokemons;

	public Trainer(String name) {
		this.name = name;
		pokeGen = new PokeGenerator();
		pokemons = new ArrayList<Pokemon>(Arrays.asList(pokeGen.getSixRandomPokemon(this)));
		currPokemon = pokemons.get(0);
	}

	public void partyPokeFainted(Pokemon poke) {
		if (pokemons.contains(poke))
		{
			if (currPokemon.equals(poke))
			{
				// switch current Pokemon
				int oldIndex = pokemons.indexOf(poke);
				// mod makes sure if oldIndex was at last index currPok is oldIndex = 0
				// could have used a if statement
				if (pokemons.size() > 0)
				{
					currPokemon = pokemons.get((oldIndex + 1) % pokemons.size());
				}
			}
			pokemons.remove(poke);
		}

		if (checkLost())
		{
			// announce game over
			System.out.println("Game over");
			currPokemon = null;
		}
	}

	public boolean checkLost() {
		boolean lost = false;
		if (pokemons.isEmpty())
		{
			lost = true;
		}

		return lost;
	}

	public void switchCurrPoke() {

	}

	public Pokemon getCurrPokemon() {
		return currPokemon;
	}

	public String getName() {
		return name;
	}

	public void showPokemons() {
		System.out.printf("Trainer %s pokemon are: ", name);
		for (Pokemon poke : pokemons)
		{
			System.out.print(poke.getName() + " ");
		}
		System.out.println();
	}
}
