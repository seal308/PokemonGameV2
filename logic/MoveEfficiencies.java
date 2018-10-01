package logic;

import java.util.ArrayList;
import java.util.HashMap;

import pokemonBattleJUnit.Constants;
import pokemonBattleJUnit.MoveTypeMismatchException;

public class MoveEfficiencies {

	static final String[] TYPES_DOUBLE = { "normal", "fire", "water", "electric", "grass", "ice", "fighting", "poison",
			"ground", "flying", "psychic", "bug", "rock", "ghost", "dragon" };

	// private ArrayList<String>[] superEffList = new ArrayList<String>[15];
	// Map<Integer,List<String>>

	static private HashMap<String, ArrayList<String>> superEffMap = new HashMap<String, ArrayList<String>>();
	static private HashMap<String, ArrayList<String>> notEffMap = new HashMap<String, ArrayList<String>>();

	public MoveEfficiencies() {
		try
		{
			confirmIndexes();
		} catch (MoveTypeMismatchException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void confirmIndexes() throws MoveTypeMismatchException {

		if (TYPES_DOUBLE.length == Constants.TYPES.length)
		{
			for (int i = 0; i < TYPES_DOUBLE.length; i++)
			{
				if (TYPES_DOUBLE[i].compareTo(Constants.TYPES[i]) != 0)
				{
					throw new MoveTypeMismatchException(
							"index: " + i + " DOUBLE: " + TYPES_DOUBLE[i] + " CONSTANTS: " + Constants.TYPES[i]);
				}

			}
		} else
		{
			throw new MoveTypeMismatchException("TYPES_DOUBLE AND CONSTANT's TYPE diff sizes");
		}

	}

	private void setSuperEffective() {

	}

	private void setInEffective() {

	}

	public void findAttackEffiency(String attackType, String defType) {

	}
}
