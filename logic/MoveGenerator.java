package logic;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import pokemonBattleJUnit.MoveEnum;
import pokemonBattleJUnit.Type;

public class MoveGenerator {

	private EnumMap<Type, List<MoveEnum>> moves = new EnumMap<Type, List<MoveEnum>>(Type.class);
	private Random randIndex = new Random();

	public MoveGenerator() {
		randIndex = new Random();
		setGenerator();
	}

	private void setGenerator() {

		/*
		// @formatter:off
		moves.put(Type.WATER, Arrays.asList(
				new Move(MoveName.WATER.WATER_GUN.toString(), Type.WATER, 13, 0.2), 
				new Move(MoveName.WATER.BUBBLE.toString(), Type.WATER, 13, 0.2),
				new Move(MoveName.WATER.HYDRO_PUMP.toString(), Type.WATER, 13, 0.2),
				new Move(MoveName.WATER.WATERFALL.toString(), Type.WATER, 13, 0.2),
				new Move(MoveName.WATER.SURF.toString(), Type.WATER, 13, 0.2)));
		// @formatter:on
		 */

		// initialize keys
		// could use a loop of Type.values() do later if have time
		moves.put(Type.NORMAL, new ArrayList<MoveEnum>());
		moves.put(Type.FIRE, new ArrayList<MoveEnum>());
		moves.put(Type.WATER, new ArrayList<MoveEnum>());
		moves.put(Type.ELECTRIC, new ArrayList<MoveEnum>());
		moves.put(Type.GRASS, new ArrayList<MoveEnum>());
		moves.put(Type.ICE, new ArrayList<MoveEnum>());
		moves.put(Type.FIGHTING, new ArrayList<MoveEnum>());
		moves.put(Type.POISON, new ArrayList<MoveEnum>());
		moves.put(Type.GROUND, new ArrayList<MoveEnum>());
		moves.put(Type.FLYING, new ArrayList<MoveEnum>());
		moves.put(Type.PSYCHIC, new ArrayList<MoveEnum>());
		moves.put(Type.BUG, new ArrayList<MoveEnum>());
		moves.put(Type.ROCK, new ArrayList<MoveEnum>());
		moves.put(Type.GHOST, new ArrayList<MoveEnum>());
		moves.put(Type.DRAGON, new ArrayList<MoveEnum>());

		for (MoveEnum move : MoveEnum.values())
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

	public MoveEnum getRandomTypeMove(Type type) {
		MoveEnum returnMove;

		// might wanna check if null before using just in case
		int length = moves.get(type).size();

		int index = randIndex.nextInt(length);
		returnMove = moves.get(type).get(index);

		return returnMove;
	}

	public MoveEnum getRandomMove() {
		MoveEnum returnMove;

		Type[] types = Type.values();
		int index = randIndex.nextInt(types.length);
		Type randomType = types[index];

		returnMove = getRandomTypeMove(randomType);

		return returnMove;
	}

	public HashSet<MoveEnum> getMovesSet(Type type) {
		HashSet<MoveEnum> moveSet;

		int numMovesForType = moves.get(type).size();

		if (numMovesForType == 4)
		{
			moveSet = new HashSet<MoveEnum>(moves.get(type));
		} else if (numMovesForType < 4)
		{
			moveSet = new HashSet<MoveEnum>(moves.get(type));

			while (moveSet.size() < 4)
			{
				moveSet.add(getRandomMove());
			}
		} else // numMovesForType > 4
		{
			moveSet = new HashSet<MoveEnum>();
			while (moveSet.size() < 4)
			{
				moveSet.add(getRandomTypeMove(type));
			}
		}

		return moveSet;
	}
}
