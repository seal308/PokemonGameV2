package test;

import org.junit.jupiter.api.Test;

import constants.Move;
import constants.Type;
import junit.framework.TestCase;

public class MoveTest extends TestCase {
	/*
	public MoveTest(String name) {
		super(name);
	}
	*/

	@Test
	public void testToString() {
		assertEquals("Water Gun", Move.WATER_GUN.toString());
		assertEquals("Thunder", Move.THUNDER.toString());
		assertEquals("Dragons Smell Bad", Move.DRAGONS_SMELL_BAD.toString());
	}

	@Test
	public void testGetDamage() {

		Move stringShot = Move.STRING_SHOT;
		int calculatedDamage = Move.STRING_SHOT.getDamage();
		calculatedDamage = stringShot.getDamage();

		// 13*0.2 = 2.6
		// dmg must be greater than 13-2.6(10.4 = 10 rounded)
		// dmg must be less than 13 + 2.6(15.6 = 16 rounded)

		assertTrue("move dmg too low", calculatedDamage >= 10);
		assertTrue("move dmg too high", calculatedDamage <= 15);

		for (int i = 0; i < 100; i++)
		{
			calculatedDamage = Move.STRING_SHOT.getDamage();
			assertTrue("move dmg too low expect dmg >10.4, actual: " + calculatedDamage, calculatedDamage >= 10);
			assertTrue("move dmg too high expect dmg <=15.6, actual: " + calculatedDamage, calculatedDamage <= 16);
		}
	}

	@Test
	public void testGetType() {
		assertEquals(Type.ELECTRIC, Move.THUNDER.getType());
		assertEquals(Type.WATER, Move.WATER_GUN.getType());
		assertEquals(Type.GHOST, Move.CONFUSE_RAY.getType());
	}

}
