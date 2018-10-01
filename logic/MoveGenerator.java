package logic;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import pokemonBattleJUnit.Move;
import pokemonBattleJUnit.Type;

public class MoveGenerator {

	private EnumMap<Type, List<Move>> moves = new EnumMap<Type, List<Move>>(Type.class);
	private Random randIndex = new Random();

	public MoveGenerator() {
		randIndex = new Random();
		setGenerator();
	}

	private void setGenerator() {

		// initialize keys
		// could use a loop of Type.values() do later if have time
		moves.put(Type.NORMAL, new ArrayList<Move>());
		moves.put(Type.FIRE, new ArrayList<Move>());
		moves.put(Type.WATER, new ArrayList<Move>());
		moves.put(Type.ELECTRIC, new ArrayList<Move>());
		moves.put(Type.GRASS, new ArrayList<Move>());
		moves.put(Type.ICE, new ArrayList<Move>());
		moves.put(Type.FIGHTING, new ArrayList<Move>());
		moves.put(Type.POISON, new ArrayList<Move>());
		moves.put(Type.GROUND, new ArrayList<Move>());
		moves.put(Type.FLYING, new ArrayList<Move>());
		moves.put(Type.PSYCHIC, new ArrayList<Move>());
		moves.put(Type.BUG, new ArrayList<Move>());
		moves.put(Type.ROCK, new ArrayList<Move>());
		moves.put(Type.GHOST, new ArrayList<Move>());
		moves.put(Type.DRAGON, new ArrayList<Move>());

		for (Move move : Move.values())
		{
			// what if MoveEnums had no normal moves? and later we try to access map of
			// normal?
			if (move.getType().equals(Type.NORMAL))
			{
				moves.get(Type.NORMAL).add(move);
			} else if (move.getType().equals(Type.FIRE))
			{
				moves.get(Type.FIRE).add(move);
			} else if (move.getType().equals(Type.WATER))
			{
				moves.get(Type.WATER).add(move);
			} else if (move.getType().equals(Type.ELECTRIC))
			{
				moves.get(Type.ELECTRIC).add(move);
			} else if (move.getType().equals(Type.GRASS))
			{
				moves.get(Type.GRASS).add(move);
			} else if (move.getType().equals(Type.ICE))
			{
				moves.get(Type.ICE).add(move);
			} else if (move.getType().equals(Type.FIGHTING))
			{
				moves.get(Type.FIGHTING).add(move);
			} else if (move.getType().equals(Type.POISON))
			{
				moves.get(Type.POISON).add(move);
			} else if (move.getType().equals(Type.GROUND))
			{
				moves.get(Type.GROUND).add(move);
			} else if (move.getType().equals(Type.FLYING))
			{
				moves.get(Type.FLYING).add(move);
			} else if (move.getType().equals(Type.PSYCHIC))
			{
				moves.get(Type.PSYCHIC).add(move);
			} else if (move.getType().equals(Type.BUG))
			{
				moves.get(Type.BUG).add(move);
			} else if (move.getType().equals(Type.ROCK))
			{
				moves.get(Type.ROCK).add(move);
			} else if (move.getType().equals(Type.GHOST))
			{
				moves.get(Type.GHOST).add(move);
			} else if (move.getType().equals(Type.DRAGON))
			{
				moves.get(Type.DRAGON).add(move);
			} else
			{
				// throw an exception
			}
		}
	}

	public Move getRandomTypeMove(Type type) {
		Move returnMove;

		// might wanna check if null before using just in case
		int length = moves.get(type).size();

		int index = randIndex.nextInt(length);
		returnMove = moves.get(type).get(index);

		return returnMove;
	}

	public Move getRandomMove() {
		Move returnMove;

		Type[] types = Type.values();
		int index = randIndex.nextInt(types.length);
		Type randomType = types[index];

		returnMove = getRandomTypeMove(randomType);

		return returnMove;
	}

	public HashSet<Move> getMovesSet(Type type) {
		HashSet<Move> moveSet;

		int numMovesForType = moves.get(type).size();

		if (numMovesForType == 4)
		{
			moveSet = new HashSet<Move>(moves.get(type));
		} else if (numMovesForType < 4)
		{
			moveSet = new HashSet<Move>(moves.get(type));

			while (moveSet.size() < 4)
			{
				moveSet.add(getRandomMove());
			}
		} else // numMovesForType > 4
		{
			moveSet = new HashSet<Move>();
			while (moveSet.size() < 4)
			{
				moveSet.add(getRandomTypeMove(type));
			}
		}

		return moveSet;
	}
}
