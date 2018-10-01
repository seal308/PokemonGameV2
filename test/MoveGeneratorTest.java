package test;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import logic.MoveGenerator;
import pokemonBattleJUnit.MoveEnum;
import pokemonBattleJUnit.Type;

class MoveGeneratorTest extends TestCase {

	@Test
	void testGetRandomTypeMove() {
		MoveGenerator moveGen = new MoveGenerator();
		assertEquals(Type.ELECTRIC, moveGen.getRandomTypeMove(Type.ELECTRIC).getType());
		assertEquals(Type.GHOST, moveGen.getRandomTypeMove(Type.GHOST).getType());

	}

	@Test
	// fire type has 4 total moves in total
	void testGetMoveSetExact4() {
		MoveGenerator moveGen = new MoveGenerator();
		HashSet<MoveEnum> moves = moveGen.getMovesSet(Type.FIRE);

		assertTrue(moves.contains(MoveEnum.EMBER));
		assertTrue(moves.contains(MoveEnum.FLAMETHROWER));
		assertTrue(moves.contains(MoveEnum.FIRE_BLAST));
		assertTrue(moves.contains(MoveEnum.FIRE_SPIN));
		assertEquals(4, moves.size());
	}

	@Test
	// normla type has > 4 moves in total
	void testGetMoveSetGreater4() {
		MoveGenerator moveGen = new MoveGenerator();
		HashSet<MoveEnum> moves = moveGen.getMovesSet(Type.NORMAL);

		assertEquals(4, moves.size());
		for (MoveEnum move : moves)
		{
			assertEquals(Type.NORMAL, move.getType());
		}
	}

	@Test
	// rock type only has 2 moves, rock slide and rock throw
	void testGetMoveSetLess4() {
		MoveGenerator moveGen = new MoveGenerator();
		HashSet<MoveEnum> moves = moveGen.getMovesSet(Type.ROCK);

		assertEquals(4, moves.size());
		assertTrue(moves.contains(MoveEnum.ROCK_SLIDE));
		assertTrue(moves.contains(MoveEnum.ROCK_THROW));

	}

}
