package pokemonBattleJUnit;

import java.util.Arrays;

import logic.TypeEffectiveness;
import presentation.Scene;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scene battle = new Scene();

		TypeEffectiveness typeEff = new TypeEffectiveness();

		System.out.println(Arrays.asList(Type.GRASS, Type.BUG).equals(typeEff.getSuperEff(Type.POISON)));

		/*
		
		System.out.println(Arrays.asList(Types.BUG, Types.FIRE, Types.GROUND)
				.equals(Arrays.asList(Types.BUG, Types.FIRE, Types.GROUND)));
				
				*/

		battle.start();

	}

}
