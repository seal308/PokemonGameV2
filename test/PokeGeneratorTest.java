package test;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import logic.PokeGenerator;
import logic.Pokemon;
import logic.Trainer;

class PokeGeneratorTest extends TestCase {

	Trainer testTrainer = new Trainer("Tester");

	@Test
	void testGetRandomPokemon() {
		PokeGenerator pokeGen = new PokeGenerator();
		Pokemon poke = pokeGen.getRandomPokemon(testTrainer);

		assertTrue("Poke is null", pokeGen.getRandomPokemon(testTrainer) != null);
	}

	@Test
	void testGetSixRandomPokemon() {
		PokeGenerator pokeGen = new PokeGenerator();
		Pokemon[] pokemons = pokeGen.getSixRandomPokemon(testTrainer);
		assertEquals(6, pokemons.length);
		for (int i = 0; i < pokemons.length; i++)
		{
			assertNotNull(pokemons[i]);
		}
	}

}
