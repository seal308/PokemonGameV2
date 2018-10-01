package test;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import pokemonBattleJUnit.MoveEnum;
import pokemonBattleJUnit.Type;

class MoveEnumTest extends TestCase {

	@Test
	void testToString() {
		assertEquals("Water Gun", MoveEnum.WATER_GUN.toString());
		assertEquals("Thunder", MoveEnum.THUNDER.toString());
		assertEquals("Dragons Smell Bad", MoveEnum.DRAGONS_SMELL_BAD.toString());
	}

	@Test
	void testGetDamage() {

		MoveEnum stringShot = MoveEnum.STRING_SHOT;
		int calculatedDamage = MoveEnum.STRING_SHOT.getDamage();
		calculatedDamage = stringShot.getDamage();

		// 13*0.2 = 2.6
		// dmg must be greater than 13-2.6(10.4 = 10 rounded)
		// dmg must be less than 13 + 2.6(15.6 = 16 rounded)

		assertTrue("move dmg too low", calculatedDamage >= 10);
		assertTrue("move dmg too high", calculatedDamage <= 15);

		for (int i = 0; i < 100; i++)
		{
			calculatedDamage = MoveEnum.STRING_SHOT.getDamage();
			assertTrue("move dmg too low expect dmg >10.4, actual: " + calculatedDamage, calculatedDamage >= 10);
			assertTrue("move dmg too high expect dmg <=15.6, actual: " + calculatedDamage, calculatedDamage <= 16);
		}
	}

	@Test
	void testGetType() {
		assertEquals(Type.ELECTRIC, MoveEnum.THUNDER.getType());
		assertEquals(Type.WATER, MoveEnum.WATER_GUN.getType());
		assertEquals(Type.GHOST, MoveEnum.CONFUSE_RAY.getType());
	}

}
