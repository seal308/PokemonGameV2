package logic;

import pokemonBattleJUnit.Constants;
import pokemonBattleJUnit.MoveEnum;
import pokemonBattleJUnit.PokemonTypeException;

public class PokemonOld {
	private String name;
	private String type;
	private MoveEnum[] moves;
	private int hp;
	private int maxHp;
	private boolean fainted;

	private static final int MIN_HP = Constants.MIN_HP;

	public PokemonOld(String name, String type) throws PokemonTypeException {
		this.name = name;
		this.type = type;

		isValidType(type);

		moves = new MoveEnum[4];
		fainted = false;

		hp = (int) (Math.random() * (MIN_HP / 2) + MIN_HP + 1);
		maxHp = hp;
	}

	public int getHP() {
		return hp;
	}

	public String getType() {
		return type;
	}

	public void isValidType(String type) throws PokemonTypeException {

		int typeFound = 1;
		int typeArrCounter = 0;

		while (typeArrCounter < Constants.TYPES.length && typeFound != 0)
		{
			typeFound = type.compareTo(Constants.TYPES[typeArrCounter]);
			typeArrCounter++;
		}

		if (typeFound != 0)
		{
			throw new PokemonTypeException("Incorrect type: " + type);
		}
	}

	public void damaged(int amount) {
		hp -= amount;
		checkFaint();
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

}
