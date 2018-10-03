package test;

import org.junit.jupiter.api.Test;

import constants.Constants;
import constants.Move;
import constants.PokemonName;
import creatures.Pokemon;
import creatures.Trainer;
import junit.framework.TestCase;

public class PokemonTest extends TestCase {

	Trainer testTrainer = new Trainer("Tester");

	@Test
	public void testFullHPInRange() {
		int MIN_HP = Constants.MIN_HP;
		Pokemon testPokemon;
		int hp = -1;

		testPokemon = new Pokemon(PokemonName.BULBASAUR, testTrainer);
		hp = testPokemon.getHP();

		// TODO: get error sometimes
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
	
	*/

	@Test
	public void testGetName() {

		// might wanna change this later to Mankey

		Pokemon mankey = new Pokemon(PokemonName.MANKEY, testTrainer);
		assertEquals("mankey name wrong", "MANKEY", mankey.getName());
	}

	@Test
	public void testCheckFaint() {

		Pokemon chansey = new Pokemon(PokemonName.CHANSEY, testTrainer);
		chansey.damaged(Move.MAX_HIT);
		assertTrue("chimeko shoulda but didn't faint", chansey.getFainted());

		Pokemon haunter = new Pokemon(PokemonName.HAUNTER, testTrainer);
		haunter.damaged(Move.MAX_HIT);
		// b/c normal attack has 0 effect on ghost pokemon
		assertFalse("hunter should not die from Normal MAX HIT", haunter.getFainted());
	}
}
