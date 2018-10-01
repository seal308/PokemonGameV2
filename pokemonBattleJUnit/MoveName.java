package pokemonBattleJUnit;

import java.util.Random;

public class MoveName {

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

	private static int calculateDamage(int damage, double variability) {

		double random = new Random().nextDouble();
		double start = damage - (damage * variability);
		double end = damage + (damage * variability);
		double unRoundedDamage = (start) + (random * (end - start));

		// real program don't use below, loss of precision when cast double to float
		damage = Math.round((float) unRoundedDamage);
		return damage;
	}

	public enum NORMAL {
		BODY_SLAM, FURY_SWIPES, HEADBUTT, HYPER_BEAM, POUND, QUICK_ATTACK, SWIFT;
		@Override
		public String toString() {
			return convertEnumString(super.toString());
		}
	}

	public enum FIRE {
		EMBER, FIRE_BLAST, FIRE_SPIN, FLAMETHROWER;
		@Override
		public String toString() {
			return convertEnumString(super.toString());
		}
	}

	public enum WATER {
		// @formatter:off
		BUBBLE(Type.WATER, 13, 0.2), 
		HYDRO_PUMP(Type.WATER, 13, 0.2), 
		SURF(Type.WATER, 13, 0.2), 
		WATER_GUN(Type.WATER, 13, 0.2), 
		WATERFALL(Type.WATER, 13, 0.2);
		// @formatter:ON
		
		private int damage;
		private Type type;
		
		@Override
		public String toString() {
			return convertEnumString(super.toString());
		}

		private WATER(Type type, int defaultDamage, double variability) {
			damage = calculateDamage(defaultDamage, variability);
			this.type = type;
		}
		
		public int getDamage() {
			return damage;
		}

		public Type getType() {
			return type;
		}

	}

	public enum ELECTRIC {
		THUNDER, THUNDER_SHOCK, THUNDER_WAVE, THUNDER_BOLT;
		@Override
		public String toString() {
			return convertEnumString(super.toString());
		}
	}

	public enum GRASS {
		LEECH_SEED, PETAL_DANCE, RAZOR_LEAF, SOLAR_BEAM, VINE_WHIP;
		@Override
		public String toString() {
			return convertEnumString(super.toString());
		}
	}

	public enum ICE {
		AURORA_BEAM, BLIZZARD, HAZE, ICE_BEAM, ICE_PUNCH, MIST;
		@Override
		public String toString() {
			return convertEnumString(super.toString());
		}
	}

	public enum FIGHTING {
		DOUBLIC_KICK, HIGH_JUMP_KICK, JUMP_KICK, KARATE_CHOP, SEISMIC_TOSS, SUBMISSION;
		@Override
		public String toString() {
			return convertEnumString(super.toString());
		}
	}

	public enum POISON {
		ACID, POISON_GAS, POISON_STING, SLUDGE, TOXIC;
		@Override
		public String toString() {
			return convertEnumString(super.toString());
		}
	}

	public enum GROUND {
		DIG, EARTHQUAKE, FISSURE, SAND_ATTACK;
		@Override
		public String toString() {
			return convertEnumString(super.toString());
		}
	}

	public enum FLYING {
		DRILL_PECK, FLY, GUST, PECK, SKY_ATTACK, WING_ATTACK;
		@Override
		public String toString() {
			return convertEnumString(super.toString());
		}
	}

	public enum PSYCHIC {
		CONFUSION, DREAM_EATER, HYPNOSIS, PSYBEAM, PSYCHIC, PSYWAVE;
		@Override
		public String toString() {
			return convertEnumString(super.toString());
		}
	}

	public enum BUG {
		LEECH_LIFE, PIN_MISSILE, STRING_SHOT, TWINEEDLE;
		@Override
		public String toString() {
			return convertEnumString(super.toString());
		}
	}

	public enum ROCK {
		ROCK_SLIDE, ROCK_THROW;
		@Override
		public String toString() {
			return convertEnumString(super.toString());
		}
	}

	public enum GHOST {
		CONFUSE_RAY, LICK, NIGHT_SHADE;
		@Override
		public String toString() {
			return convertEnumString(super.toString());
		}
	}

	public enum DRAGON {
		DRAGON_RAGE, DRAGONS_SMELL_BAD;
		@Override
		public String toString() {
			return convertEnumString(super.toString());
		}
	}
}
