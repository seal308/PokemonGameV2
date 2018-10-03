package logic;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import constants.Effectiveness;
import constants.Type;

/*
 * Based on generation 1: https://pokemondb.net/type/old
 */

public class TypeEffectiveness {
	private EnumMap<Type, List<Type>> superEffMap = new EnumMap<Type, List<Type>>(Type.class);
	private EnumMap<Type, List<Type>> notVeryEffMap = new EnumMap<Type, List<Type>>(Type.class);
	private EnumMap<Type, List<Type>> noEffMap = new EnumMap<Type, List<Type>>(Type.class);

	public TypeEffectiveness() {
		setSuperEff();
		setNoEff();
		setNotVeryEff();
	}

	private void setSuperEff() {
		// got list idea from:
		// https://stackoverflow.com/questions/1005073/initialization-of-an-arraylist-in-one-line

		// normal no super effective might wanna make empty list? prob not
		superEffMap.put(Type.FIRE, Arrays.asList(Type.GRASS, Type.ICE, Type.BUG));
		superEffMap.put(Type.WATER, Arrays.asList(Type.FIRE, Type.GROUND, Type.ROCK));
		superEffMap.put(Type.ELECTRIC, Arrays.asList(Type.WATER, Type.FLYING));
		superEffMap.put(Type.GRASS, Arrays.asList(Type.WATER, Type.GROUND, Type.ROCK));
		superEffMap.put(Type.ICE, Arrays.asList(Type.GRASS, Type.GROUND, Type.FLYING, Type.DRAGON));
		superEffMap.put(Type.FIGHTING, Arrays.asList(Type.NORMAL, Type.ICE, Type.ROCK));
		superEffMap.put(Type.POISON, Arrays.asList(Type.GRASS, Type.BUG));
		superEffMap.put(Type.GROUND, Arrays.asList(Type.FIRE, Type.ELECTRIC, Type.POISON, Type.ROCK));
		superEffMap.put(Type.FLYING, Arrays.asList(Type.GRASS, Type.FIGHTING, Type.BUG));
		superEffMap.put(Type.PSYCHIC, Arrays.asList(Type.FIGHTING, Type.POISON));
		superEffMap.put(Type.BUG, Arrays.asList(Type.GRASS, Type.POISON, Type.PSYCHIC));
		superEffMap.put(Type.ROCK, Arrays.asList(Type.FIRE, Type.ICE, Type.FLYING, Type.BUG));
		superEffMap.put(Type.GHOST, Arrays.asList(Type.GHOST));
		superEffMap.put(Type.DRAGON, Arrays.asList(Type.DRAGON));
	}

	private void setNoEff() {
		noEffMap.put(Type.NORMAL, Arrays.asList(Type.GHOST));
		noEffMap.put(Type.ELECTRIC, Arrays.asList(Type.GROUND));
		noEffMap.put(Type.FIGHTING, Arrays.asList(Type.GHOST));
		noEffMap.put(Type.GROUND, Arrays.asList(Type.FLYING));
		noEffMap.put(Type.GHOST, Arrays.asList(Type.NORMAL, Type.PSYCHIC));
	}

	private void setNotVeryEff() {
		notVeryEffMap.put(Type.NORMAL, Arrays.asList(Type.ROCK));
		notVeryEffMap.put(Type.FIRE, Arrays.asList(Type.FIRE, Type.WATER, Type.ROCK, Type.DRAGON));
		notVeryEffMap.put(Type.WATER, Arrays.asList(Type.WATER, Type.GRASS, Type.DRAGON));
		notVeryEffMap.put(Type.ELECTRIC, Arrays.asList(Type.ELECTRIC, Type.GRASS, Type.DRAGON));
		notVeryEffMap.put(Type.GRASS,
				Arrays.asList(Type.FIRE, Type.GRASS, Type.POISON, Type.FLYING, Type.BUG, Type.DRAGON));
		notVeryEffMap.put(Type.ICE, Arrays.asList(Type.WATER, Type.ICE));
		notVeryEffMap.put(Type.FIGHTING, Arrays.asList(Type.POISON, Type.FLYING, Type.PSYCHIC, Type.BUG));
		notVeryEffMap.put(Type.POISON, Arrays.asList(Type.POISON, Type.GROUND, Type.ROCK, Type.GHOST));
		notVeryEffMap.put(Type.GROUND, Arrays.asList(Type.GRASS, Type.BUG));
		notVeryEffMap.put(Type.FLYING, Arrays.asList(Type.ELECTRIC, Type.ROCK));
		notVeryEffMap.put(Type.PSYCHIC, Arrays.asList(Type.PSYCHIC));
		notVeryEffMap.put(Type.BUG, Arrays.asList(Type.FIRE, Type.FIGHTING, Type.FLYING, Type.GHOST));
		notVeryEffMap.put(Type.ROCK, Arrays.asList(Type.FIGHTING, Type.GROUND));
	}

	public List<Type> getSuperEff(Type queryType) {
		return superEffMap.get(queryType);
	}

	public List<Type> getNoEff(Type queryType) {
		return noEffMap.get(queryType);
	}

	public List<Type> getNotVeryEff(Type queryType) {
		return notVeryEffMap.get(queryType);
	}

	public Effectiveness findEffectiveness(Type attackType, Type defenceType) {
		Effectiveness returnEff = null;
		List<Type> effList = null;

		// arranged with biggest map 1st, smallest last, b/c more likely to be in big
		// one
		if (superEffMap.containsKey(attackType) && superEffMap.get(attackType).contains(defenceType))
		{
			returnEff = Effectiveness.SUPEREFFECTIVE;
		}

		else if (notVeryEffMap.containsKey(attackType) && notVeryEffMap.get(attackType).contains(defenceType))
		{
			returnEff = Effectiveness.INEFFECTIVE;
		}

		else if (noEffMap.containsKey(attackType) && noEffMap.get(attackType).contains(defenceType))
		{
			returnEff = Effectiveness.NOEFFECT;
		} else
		{
			returnEff = Effectiveness.NORMAL;
		}

		return returnEff;
	}

}
