package pokemonBattleJUnit;

import java.util.Random;

public enum Move {

	// @formatter:off
	
	// normal
	BODY_SLAM(Type.NORMAL, 21, 0.2), 
	FURY_SWIPES(Type.NORMAL, 5, 0.2), 
	HEADBUTT(Type.NORMAL, 18, 0.1), 
	HYPER_BEAM(Type.NORMAL, 38, 0.2),
	QUICK_ATTACK(Type.NORMAL, 10, 0.2),
	SWIFT(Type.NORMAL, 15, 0.3),
	POUND(Type.NORMAL, 10, 0.3),
	
	//fire
	EMBER(Type.FIRE, 10, 0.1), 
	FIRE_BLAST(Type.FIRE, 28, 0.2), 
	FIRE_SPIN(Type.FIRE, 9, 0.3), 
	FLAMETHROWER(Type.FIRE, 23, 0.2),
	
	//water
	BUBBLE(Type.WATER, 10, 0.1), 
	HYDRO_PUMP(Type.WATER, 28, 0.2), 
	SURF(Type.WATER, 23, 0.3), 
	WATER_GUN(Type.WATER, 10, 0.2),
	WATERFALL(Type.WATER, 20, 0.3),
	
	//electric
	THUNDER(Type.ELECTRIC, 28, 0.1), 
	THUNDER_SHOCK(Type.ELECTRIC, 10, 0.2), 
	THUNDER_WAVE(Type.ELECTRIC, 15, 0.3), 
	THUNDER_BOLT(Type.ELECTRIC, 23, 0.2),
	
	//grass
	LEECH_SEED(Type.GRASS, 13, 0.3), 
	PETAL_DANCE(Type.GRASS, 30, 0.2), 
	RAZOR_LEAF(Type.GRASS, 14, 0.1), 
	SOLAR_BEAM(Type.GRASS, 30, 0.2),
	VINE_WHIP(Type.GRASS, 12, 0.2),
	
	//ice
	AURORA_BEAM(Type.ICE, 16, 0.2), 
	BLIZZARD(Type.ICE, 28, 0.2), 
	HAZE(Type.ICE, 19, 0.3), 
	ICE_BEAM(Type.ICE, 23, 0.1),
	
	//fighting
	DOUBLE_KICK(Type.FIGHTING, 8, 0.2), 
	HIGH_JUMP_KICK(Type.FIGHTING, 32, 0.2), 
	JUMP_KICK(Type.FIGHTING, 25, 0.2), 
	KARATE_CHOP(Type.FIGHTING, 13, 0.2),
	SUBMISSION(Type.FIGHTING, 20, 0.2),
	
	//poison
	ACID(Type.POISON, 10, 0.2), 
	POISON_GAS(Type.POISON, 20, 0.2), 
	POISON_STING(Type.POISON, 4, 0.2), 
	SLUDGE(Type.POISON, 16, 0.3),
	TOXIC(Type.POISON, 25, 0.1),
	
	//ground
	DIG(Type.GROUND, 20, 0.1), 
	EARTHQUAKE(Type.GROUND, 25, 0.2), 
	FISSURE(Type.GROUND, 15, 0.3), 
	SAND_ATTACK(Type.GROUND, 10, 0.2),
	
	//flying
	DRILL_PECK(Type.FLYING, 20, 0.1), 
	FLY(Type.FLYING, 23, 0.1), 
	GUST(Type.FLYING, 10, 0.3), 
	PECK(Type.FLYING, 9, 0.2),
	SKY_ATTACK(Type.FLYING, 35, 0.2),
	WING_ATTACK(Type.FLYING, 15, 0.1),
	
	//psychic 
	CONFUSION(Type.PSYCHIC, 13, 0.3), 
	DREAM_EATER(Type.PSYCHIC, 25, 0.1), 
	HYPNOSIS(Type.PSYCHIC, 20, 0.2), 
	PSYBEAM(Type.PSYCHIC, 16, 0.1),
	PSYCHIC(Type.PSYCHIC, 23, 0.2),
	PSYWAVE(Type.PSYCHIC, 10, 0.2),
	
	//bug
	LEECH_LIFE(Type.BUG, 20, 0.2), 
	PIN_MISSILE(Type.BUG, 6, 0.1), 
	STRING_SHOT(Type.BUG, 13, 0.2), 
	TWINEEDLE(Type.BUG, 6, 0.3),
	
	//rock
	ROCK_SLIDE(Type.ROCK, 19, 0.3), 
	ROCK_THROW(Type.ROCK, 12, 0.2),
	
	//ghost
	CONFUSE_RAY(Type.GHOST, 13, 0.3), 
	LICK(Type.GHOST, 8, 0.2), 
	NIGHT_SHADE(Type.GHOST, 20, 0.1),
	
	//dragon
	DRAGON_RAGE(Type.DRAGON, 13, 0.2), 
	DRAGONS_SMELL_BAD(Type.DRAGON, 20, 0.3),
	
	//for Testing
	MAX_HIT(Type.NORMAL, 100000, 1);
	
	// @formatter:ON;
	
	private int damage;
	private Type type;
	private double variability;

	private Move(Type type, int defaultDamage, double variability) {
		this.type = type;
		this.variability = variability;
		damage = defaultDamage;
		
		calculateDamage();
	}
	
	public static String convertEnumString(String original) {
		String returnString = "";
		String[] originalSplit = original.split("_");
		String subSplit = "";
		for (int i = 0; i < originalSplit.length; i++)
		{
			subSplit = originalSplit[i].substring(0, 1) + originalSplit[i].substring(1).toLowerCase();
			if (i < originalSplit.length - 1)
			{
				subSplit += " ";
			}
			returnString += subSplit;
		}
		return returnString;
	}
	
	@Override
	public String toString() {
		return convertEnumString(super.toString());
	}
	
	private void calculateDamage() {

		double random = new Random().nextDouble();
		double start = damage - (damage * variability);
		double end = damage + (damage * variability);
		double unRoundedDamage = (start) + (random * (end - start));

		// real program don't use below, loss of precision when cast double to float
		damage = Math.round((float) unRoundedDamage);
	}
	
	public int getDamage() {
		return damage;
	}

	public Type getType() {
		return type;
	}
}
