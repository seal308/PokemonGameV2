package test;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import logic.MoveOld;
import pokemonBattleJUnit.Type;

class MoveTest extends TestCase {

	@Test
	void testCalcDamage() {

		MoveOld watergun = new MoveOld("watergun", Type.WATER, 13, 0.2);

		// 13*0.2 = 2.6
		// dmg must be greater than 13-2.6(10.4 = 10 rounded)
		// dmg must be less than 13 + 2.6(15.6 = 16 rounded)

		int calculatedDamage = watergun.getDamage();

		assertTrue("move dmg too low", calculatedDamage >= 10);
		assertTrue("move dmg too high", calculatedDamage <= 15);

		for (int i = 0; i < 100; i++)
		{
			watergun = new MoveOld("watergun", Type.WATER, 13, 0.2);
			calculatedDamage = watergun.getDamage();
			assertTrue("move dmg too low expect dmg >10.4, actual: " + calculatedDamage, calculatedDamage >= 10);
			assertTrue("move dmg too high expect dmg <=15.6, actual: " + calculatedDamage, calculatedDamage <= 16);
		}

		/*
		 * eg dmg = 13
		 * variability = 0.2
		 * 
		 * 13*0.2 = 2.6
		 * changeAmount (if normal type dmg) = random float between -2.6 and 2.6
		 * changeAmount (if supereffective) = random float between 2.6/2 and 2.6
		 * changeAMount (if not very effect) = random float between -2.6 and -2.6/2
		 * 
		 * actual damange = dmg + changeAmount
		 * Round damage to nearest int
		 */
	}
}
