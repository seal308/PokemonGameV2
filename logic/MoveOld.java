package logic;

import java.util.Random;

import pokemonBattleJUnit.Type;

public class MoveOld {
	private String name;
	private Type type;
	private double variability;
	private int damage;

	public MoveOld(String name, Type type, int defaultDamage, double variability) {
		this.name = name;
		this.type = type;
		this.damage = defaultDamage;
		this.variability = variability;

		calculateDamage();
	}

	private void calculateDamage() {

		/*
		 * eg dmg = 13
		 * variability = 0.2
		 * 
		 * 13*0.2 = 2.6
		 * changeAmount (if normal type dmg) = random float between -2.6 and 2.6
		 * changeAmount (if supereffective) = random float between 2.6/2 and 2.6
		 * changeAMount (if not very effect) = random float between -2.6 and -2.6/2
		 * 
		 * actual damange = dmg + changeAmount
		 * Round damage to nearest int
		 */

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
