package test;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import logic.Pokemon2;
import pokemonBattleJUnit.Constants;
import pokemonBattleJUnit.PokemonTypeException;
import pokemonBattleJUnit.Type;

class Pokemon2Test extends TestCase {

	@Test
	void testFullHPInRange() {
		int MIN_HP = Constants.MIN_HP;
		Pokemon2 testPokemon;
		int hp = -1;
		try
		{
			testPokemon = new Pokemon2("bulbasaur", Type.GRASS);
			hp = testPokemon.getHP();
		} catch (PokemonTypeException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue("hp less than MIN", hp > MIN_HP);
		assertTrue("hp greater than MIN + MIN/2", hp < (MIN_HP + MIN_HP / 2));
	}

	/*
	
	@Test
	void testGetHP() {
		fail("Not yet implemented");
	}
	
	@Test
	void testGetType() {
		fail("Not yet implemented");
	}
	
	@Test
	void testDamaged() {
		fail("Not yet implemented");
	}
	
	@Test
	void testCheckFaint() {
		fail("Not yet implemented");
	}
	
	@Test
	void testGetMaxHP() {
		fail("Not yet implemented");
	}
	
	@Test
	void testGetFainted() {
		fail("Not yet implemented");
	}
	
	@Test
	void testGetName() {
		fail("Not yet implemented");
	}
	
	*/
}
