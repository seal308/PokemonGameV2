package creatures;

import java.util.HashSet;

import constants.Constants;
import constants.Effectiveness;
import constants.Move;
import constants.PokemonName;
import constants.Type;
import generators.MoveGenerator;
import logic.TypeEffectiveness;
import presentation.Scene;

/*
 * TODO: Make a attack method
 * 		initially have just a damaged method but doesn't make sense command wise
 * 		would be like defencePokemon(AttackPokemon.move) or something
 * 		when something like attackPokemon.attack(defencePokemon) makes more sense
 */

public class Pokemon {
	private String name;
	private Type type;
	private HashSet<Move> moves;
	private int hp;
	private int maxHp;
	private boolean fainted;
	private TypeEffectiveness typeEff;

	Trainer trainer;

	private static final int MIN_HP = Constants.MIN_HP;

	public Pokemon(PokemonName name, Trainer trainer) {
		this.name = name.toString();
		// this.type = type;
		type = name.getType();

		this.trainer = trainer;

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

	public void damaged(Move attackMove) {

		int amount = attackMove.getDamage();
		Type attackType = attackMove.getType();

		Effectiveness effectiveness = typeEff.findEffectiveness(attackType, type);

		double multiplier;

		if (effectiveness == Effectiveness.SUPEREFFECTIVE)
		{
			multiplier = 2;
			Scene.printToScreen("It's supereffective!");
		} else if (effectiveness == Effectiveness.INEFFECTIVE)
		{
			multiplier = 0.5;
			Scene.printToScreen("It's not very effective...");
		} else if (effectiveness == Effectiveness.NOEFFECT)
		{
			multiplier = 0;
			Scene.printToScreen("It doesn't affect " + name + "...");
		} else
		{
			// must be normal effect
			multiplier = 1;
		}
		int oldHP = hp;
		hp -= (amount * multiplier);
		checkFaint();
		if (fainted == false)
		{
			Scene.printToScreen(name + " lost " + (oldHP - hp) + " hps. Current hp = " + hp);
		}
	}

	public void attack(Pokemon defencePokemon, Move attackMove) {
		// defencePokemon.damaged(amount);
		// damage with a move in parameter for damaged
		Scene.printToScreen(name + " used " + attackMove.toString());
		defencePokemon.damaged(attackMove);
	}

	public void checkFaint() {

		if (hp <= 0)
		{
			Scene.printToScreen(name + " fainted!");
			hp = 0;
			fainted = true;
			trainer.partyPokeFainted(this);
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

	public HashSet<Move> getMoves() {
		return moves;
	}

}
