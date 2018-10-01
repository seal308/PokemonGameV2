package test;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import logic.PokemonOld;

class battleTest extends TestCase {

	@Test
	void testPokeBagIsFull(PokemonOld[] pokeBag) {
		for (int i = 0; i < pokeBag.length; i++)
		{
			assertNotNull("PokeBall Empty", pokeBag[i]);
		}
	}

	void testPokeBagNoRepeats(PokemonOld[] pokeBag) {

	}

}
