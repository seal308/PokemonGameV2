package test;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import logic.PokemonOld;
import pokemonBattleJUnit.Constants;
import pokemonBattleJUnit.PokemonTypeException;

class PokemonTest extends TestCase {

	@Test
	void testFullHPInRange() {
		int MIN_HP = Constants.MIN_HP;
		PokemonOld testPokemon;
		int hp = -1;
		try
		{
			testPokemon = new PokemonOld("bulbasaur", "grass");
			hp = testPokemon.getHP();
		} catch (PokemonTypeException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue("hp less than MIN", hp > MIN_HP);
		assertTrue("hp greater than MIN + MIN/2", hp < (MIN_HP + MIN_HP / 2));
	}

	@Test
	void testTypesAreValid() {
		// this test bit redundant now that code throws pokemonTypeException
		// but in case that fails we still have this
		PokemonOld[] pokemons = new PokemonOld[15];
		int typeFound;
		int typesArrCounter;

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

			for (int i = 0; i < pokemons.length; i++)
			{
				typesArrCounter = 0;
				typeFound = 1; // 1 for false
				String currType = pokemons[i].getType();
				while (typesArrCounter < Constants.TYPES.length && typeFound != 0)
				{
					String currConstType = Constants.TYPES[typesArrCounter];
					typeFound = currType.compareTo(currConstType);
					typesArrCounter++;
				}
				assertEquals("type not found", 0, typeFound);
			}
		} catch (PokemonTypeException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testDamage() {
		try
		{
			PokemonOld ghastly = new PokemonOld("ghastly", "ghost");
			int oldHP = ghastly.getHP();
			ghastly.damaged(5);
			assertEquals("incorrect damage, expect:" + (oldHP - 5) + " actual: " + ghastly.getHP(), oldHP - 5,
					ghastly.getHP());
		} catch (PokemonTypeException e)
		{

			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testCheckFaint() {
		try
		{
			PokemonOld chimeko = new PokemonOld("chimeko", "psychic");
			PokemonOld chikorita = new PokemonOld("chikorita", "grass");

			int maxHP = chimeko.getMaxHP();
			chimeko.damaged(maxHP);

			assertTrue("chimeko shoulda but didn't faint", chimeko.getFainted());

			maxHP = chikorita.getMaxHP();
			chikorita.damaged(maxHP + 5);

			assertTrue("chikorita shoulda but didn't faint", chikorita.getFainted());
			assertEquals("chikorta hp didn't reset to 0", 0, chikorita.getHP());

		} catch (PokemonTypeException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
