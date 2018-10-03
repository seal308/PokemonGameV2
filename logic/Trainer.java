package logic;

import java.util.ArrayList;
import java.util.Arrays;

import presentation.Scene;

public class Trainer {
	private String name;
	private PokeGenerator pokeGen;
	private Pokemon currPokemon;
	private ArrayList<Pokemon> pokemons;
	private boolean defeated;

	public Trainer(String name) {
		this.name = name;
		pokeGen = new PokeGenerator();
		pokemons = new ArrayList<Pokemon>(Arrays.asList(pokeGen.getSixRandomPokemon(this)));
		currPokemon = pokemons.get(0);
		defeated = false;
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
			Scene.printToScreen("Trainer " + name + " is defeated");
			defeated = true;
			currPokemon = null;
		} else
		{
			Scene.printToScreen(name + " sent out " + currPokemon.getName() + " hp=" + currPokemon.getHP());
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

	// TODO
	public void switchPlayerPoke() {
		showPokemons();
	}

	public Pokemon getCurrPokemon() {
		return currPokemon;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Pokemon> getAllPokemon() {
		return pokemons;
	}

	public void setCurrPokemon(Pokemon poke) {
		currPokemon = poke;
	}

	public void showPokemons() {
		System.out.printf("Trainer %s pokemon are: ", name);
		for (Pokemon poke : pokemons)
		{
			System.out.print(poke.getName() + " ");
		}
		System.out.println();
	}

	public boolean checkDefeated() {
		return defeated;
	}
}
