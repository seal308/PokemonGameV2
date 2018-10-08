

import logic.Battle;
import presentation.Scene;

/*
 * Main file for PokemonV2
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scene scene = new Scene();
		Battle battle = new Battle();
		scene.start();
		battle.startBattle();
	}

}
