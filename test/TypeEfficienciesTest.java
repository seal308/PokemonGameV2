package test;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import logic.TypeEffectiveness;
import pokemonBattleJUnit.Effectiveness;
import pokemonBattleJUnit.Type;

class TypeEfficienciesTest extends TestCase {

	@Test
	void testGetSuperEff() {
		// fail("Not yet implemented");

		TypeEffectiveness typeEff = new TypeEffectiveness();

		// System.out.println(Arrays.asList(1, 4, 2).equals(Arrays.asList(1, 4, 2)));

		assertEquals("Wrong getSuperEff for " + Type.POISON, Arrays.asList(Type.GRASS, Type.BUG),
				typeEff.getSuperEff(Type.POISON));
		assertEquals("Wrong getSuperEff for " + Type.FIRE, Arrays.asList(Type.GRASS, Type.ICE, Type.BUG),
				typeEff.getSuperEff(Type.FIRE));

		// not doing the rest same as above
	}

	/*
	@Test
	void testGetNoEff() {
		fail("Not yet implemented");
		
		// note doing this same as testGetSuperEff
	}
	
	@Test
	void testGetNotVeryEff() {
		fail("Not yet implemented");
		
		// note doing this same as testGetSuperEff
	}
	
	*/

	@Test
	void testFindEfficiency() {

		TypeEffectiveness typeEff = new TypeEffectiveness();
		assertEquals(Effectiveness.SUPEREFFECTIVE, typeEff.findEffectiveness(Type.ICE, Type.DRAGON));
		assertEquals(Effectiveness.NORMAL, typeEff.findEffectiveness(Type.ICE, Type.ELECTRIC));
		assertEquals(Effectiveness.INEFFECTIVE, typeEff.findEffectiveness(Type.ICE, Type.WATER));
		assertEquals(Effectiveness.NOEFFECT, typeEff.findEffectiveness(Type.GROUND, Type.FLYING));
		assertEquals(Effectiveness.SUPEREFFECTIVE, typeEff.findEffectiveness(Type.DRAGON, Type.DRAGON));
	}

}
