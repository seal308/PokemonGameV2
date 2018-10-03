package test;

import org.junit.jupiter.api.Test;

import constants.Move;
import creatures.Pokemon;
import creatures.Trainer;
import junit.framework.TestCase;

public class TrainerTest extends TestCase {

	@Test
	public void testPartyPokeFainted() {
		Trainer trainer1 = new Trainer("eric");
		Trainer trainer2 = new Trainer("lisa");

		trainer1.showPokemons();
		trainer2.showPokemons();

		// System.out.println(trainer1.getCurrPokemon().getName());
		// System.out.println(trainer2.getCurrPokemon().getName());
	}

	@Test
	public void testCheckLost() {
		Trainer trainer1 = new Trainer("eric");
		Trainer trainer2 = new Trainer("lisa");

		Pokemon attacker = trainer1.getCurrPokemon();

		Pokemon defender = trainer2.getCurrPokemon();

		int counter = 0;
		Pokemon oldDefender = defender;
		while (defender != null && counter < 100)
		{
			// System.out.printf("defender: %s starting hp: %d\n", defender.getName(),
			// defender.getHP());
			oldDefender = defender;
			attacker = trainer1.getCurrPokemon();
			attacker.attack(defender, Move.BLIZZARD);
			attacker.attack(defender, Move.HEADBUTT);
			// System.out.printf("defender: %s HP post attack: %d\n", defender.getName(),
			// defender.getHP());
			if (defender.getHP() == 0)
			{
				assertTrue(defender.getFainted());
			}
			defender = trainer2.getCurrPokemon();
			if (oldDefender.getHP() == 0)
			{
				assertNotSame(oldDefender, defender);
			}
			counter++;
		}
		assertNull("currPokemon still exists", defender);
	}

	/*
	
	@Test
	void testSwitchCurrPoke() {
		fail("Not yet implemented");
	}
	
	@Test
	void testGetCurrPokemon() {
		fail("Not yet implemented");
	}
	
	@Test
	void testGetName() {
		fail("Not yet implemented");
	}
	*/

}
