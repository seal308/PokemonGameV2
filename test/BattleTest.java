package test;

import org.junit.jupiter.api.Test;

import logic.Battle;

class BattleTest {

	@Test
	void testCompTurn() {
		Battle battle = new Battle();

		battle.startBattle();

		// Trainer player = battle.getPlayer();
		// Trainer computer = battle.getComputer();

		// if no effect, endless loop!
		/*
		while (player.checkLost() == false && computer.checkLost() == false)
		{
			battle.computerTurn();
		}
		*/

	}

}
