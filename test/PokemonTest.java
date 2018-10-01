package test;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import logic.Pokemon;
import pokemonBattleJUnit.Constants;
import pokemonBattleJUnit.Move;
import pokemonBattleJUnit.Type;

public class PokemonTest extends TestCase {

	@Test
	public void testFullHPInRange() {
		int MIN_HP = Constants.MIN_HP;
		Pokemon testPokemon;
		int hp = -1;

		testPokemon = new Pokemon("bulbasaur", Type.GRASS);
		hp = testPokemon.getHP();

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

	@Test
	public void testCheckFaint() {

		Pokemon chimeko = new Pokemon("chimeko", Type.PSYCHIC);
		chimeko.damaged(Move.MAX_HIT);
		assertTrue("chimeko shoulda but didn't faint", chimeko.getFainted());

		Pokemon haunter = new Pokemon("haunter", Type.GHOST);
		haunter.damaged(Move.MAX_HIT);
		// b/c normal attack has 0 effect on ghost pokemon
		assertFalse("hunter should not die from Normal MAX HIT", haunter.getFainted());
	}
}
