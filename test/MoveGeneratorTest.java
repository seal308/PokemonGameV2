package test;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

import constants.Move;
import constants.Type;
import generators.MoveGenerator;
import junit.framework.TestCase;

public class MoveGeneratorTest extends TestCase {

	/*
	public MoveGeneratorTest(String name) {
	
	}
	*/

	@Test
	public void testGetRandomTypeMove() {
		MoveGenerator moveGen = new MoveGenerator();
		assertEquals(Type.ELECTRIC, moveGen.getRandomTypeMove(Type.ELECTRIC).getType());
		assertEquals(Type.GHOST, moveGen.getRandomTypeMove(Type.GHOST).getType());

	}

	@Test
	// fire type has 4 total moves in total
	public void testGetMoveSetExact4() {
		MoveGenerator moveGen = new MoveGenerator();
		HashSet<Move> moves = moveGen.getMovesSet(Type.FIRE);

		assertTrue(moves.contains(Move.EMBER));
		assertTrue(moves.contains(Move.FLAMETHROWER));
		assertTrue(moves.contains(Move.FIRE_BLAST));
		assertTrue(moves.contains(Move.FIRE_SPIN));
		assertEquals(4, moves.size());
	}

	@Test
	// normla type has > 4 moves in total
	public void testGetMoveSetGreater4() {
		MoveGenerator moveGen = new MoveGenerator();
		HashSet<Move> moves = moveGen.getMovesSet(Type.NORMAL);

		assertEquals(4, moves.size());
		for (Move move : moves)
		{
			assertEquals(Type.NORMAL, move.getType());
		}
	}

	@Test
	// rock type only has 2 moves, rock slide and rock throw
	public void testGetMoveSetLess4() {
		MoveGenerator moveGen = new MoveGenerator();
		HashSet<Move> moves = moveGen.getMovesSet(Type.ROCK);

		assertEquals(4, moves.size());
		assertTrue(moves.contains(Move.ROCK_SLIDE));
		assertTrue(moves.contains(Move.ROCK_THROW));

	}

}
