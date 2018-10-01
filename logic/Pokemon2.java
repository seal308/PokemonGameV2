package logic;

import java.util.HashSet;

import pokemonBattleJUnit.Constants;
import pokemonBattleJUnit.Effectiveness;
import pokemonBattleJUnit.MoveEnum;
import pokemonBattleJUnit.PokemonTypeException;
import pokemonBattleJUnit.Type;

/*
 * TODO: Make a attack method
 * 		initially have just a damaged method but doesn't make sense command wise
 * 		would be like defencePokemon(AttackPokemon.move) or something
 * 		when something like attackPokemon.attack(defencePokemon) makes more sense
 */

public class Pokemon2 {
	private String name;
	private Type type;
	private HashSet<MoveEnum> moves;
	private int hp;
	private int maxHp;
	private boolean fainted;
	private TypeEffectiveness typeEff;

	private static final int MIN_HP = Constants.MIN_HP;

	public Pokemon2(String name, Type type) throws PokemonTypeException {
		this.name = name;
		this.type = type;

		// moves = new Move[4];
		fainted = false;
		typeEff = new TypeEffectiveness();

		hp = (int) (Math.random() * (MIN_HP / 2) + MIN_HP + 1);
		maxHp = hp;

		setMoves();
	}

	public int getHP() {
		return hp;
	}

	public Type getType() {
		return type;
	}

	public void damaged(MoveEnum attackMove) {

		int amount = attackMove.getDamage();
		Type attackType = attackMove.getType();

		Effectiveness effectiveness = typeEff.findEffectiveness(attackType, type);

		double multiplier;

		if (effectiveness == Effectiveness.SUPEREFFECTIVE)
		{
			multiplier = 2;
		} else if (effectiveness == Effectiveness.INEFFECTIVE)
		{
			multiplier = 0.5;
		} else if (effectiveness == Effectiveness.NOEFFECT)
		{
			multiplier = 0;
		} else
		{
			// must be normal effect
			multiplier = 1;
		}

		hp -= (amount * multiplier);
		checkFaint();
	}

	public void attack(PokemonOld defencePokemon) {
		// defencePokemon.damaged(amount);
		// damage with a move in parameter for damaged
	}

	public void checkFaint() {

		if (hp <= 0)
		{
			hp = 0;
			fainted = true;
		}
	}

	public int getMaxHP() {
		return maxHp;
	}

	public boolean getFainted() {
		return fainted;
	}

	public String getName() {
		return name;
	}

	private void setMoves() {
		MoveGenerator moveGen = new MoveGenerator();
		moves = moveGen.getMovesSet(type);
	}

	public HashSet<MoveEnum> getMoves() {
		return moves;
	}

}