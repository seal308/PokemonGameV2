package test;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import pokemonBattleJUnit.MoveName;
import pokemonBattleJUnit.MoveName.WATER;

class MoveNamesTest extends TestCase {

	@Test
	void testConvertEnumString() {
		assertEquals("Headbutt", MoveName.NORMAL.HEADBUTT.toString());
		assertEquals("Body Slam", MoveName.NORMAL.BODY_SLAM.toString());
		assertEquals("Dragons Smell Bad", MoveName.DRAGON.DRAGONS_SMELL_BAD.toString());

		// DOES NOT WORK
		// MoveName mv = MoveName.WATER.BUBBLE;

		WATER mv = MoveName.WATER.BUBBLE;
		// so basically we can't pass it as a MoveName
	}

}
