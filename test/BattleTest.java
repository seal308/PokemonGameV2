package test;

import org.junit.jupiter.api.Test;

import logic.Battle;

public class BattleTest {

	// TODO: Battle Tests, should have made them before and during writing

	@Test
	public void testCompTurn() {
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
