package test;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import logic.PokeGenerator;
import logic.Pokemon;

class PokeGeneratorTest extends TestCase {

	@Test
	void testGetRandomPokemon() {
		PokeGenerator pokeGen = new PokeGenerator();
		Pokemon poke = pokeGen.getRandomPokemon();

		assertTrue("Poke is null", pokeGen.getRandomPokemon() != null);
	}

	@Test
	void testGetSixRandomPokemon() {
		PokeGenerator pokeGen = new PokeGenerator();
		Pokemon[] pokemons = pokeGen.getSixRandomPokemon();
		assertEquals(6, pokemons.length);
		for (int i = 0; i < pokemons.length; i++)
		{
			assertNotNull(pokemons[i]);
		}
	}

}
