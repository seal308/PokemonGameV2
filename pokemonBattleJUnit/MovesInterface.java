package pokemonBattleJUnit;

/*
 * Trying to see if we can have enum implment this interface
 * add methods for calculate damage etc so don't also repeat?
 */

public interface MovesInterface {

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

}
