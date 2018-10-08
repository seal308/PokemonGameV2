package logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import constants.Move;
import creatures.Pokemon;
import creatures.Trainer;
import presentation.Scene;

public class Battle {
	private Trainer player;
	private Trainer computer;

	public Battle() {
		player = new Trainer("Drew");
		computer = new Trainer("Jessie");
	}

	private void computerTurn() {
		// TODO: If comp attack no effect, if another poke, go to next pokemon

		Scene.printToScreen("\n" + computer.getName() + "\'s turn...");

		Pokemon compPoke = computer.getCurrPokemon();
		// should have 4 moves in here
		HashSet<Move> compMoves = compPoke.getMoves();
		int randIndex = new Random().nextInt(compMoves.size());

		int i = 0;
		Move attackMove = null;
		// only 4 items so doesn't take long to search
		for (Move move : compMoves)
		{
			if (i == randIndex)
			{
				attackMove = move;
			}
			i++;
		}
		// player currPoke never null b/c we check if defeated before compTurn called
		compPoke.attack(player.getCurrPokemon(), attackMove);
	}

	private void playerTurn() {

		HashSet<Move> playerMovesSet = player.getCurrPokemon().getMoves();
		Move[] playerMoves = new Move[playerMovesSet.size()];
		// TODO: Understand how toArray method works later
		playerMovesSet.toArray(playerMoves);

		Scanner in;
		boolean validInput = false;
		while (validInput == false)
		{
			Scene.printToScreen("\nEnter the # of the move you want to use");

			for (int i = 0; i < playerMoves.length; i++)
			{
				System.out.print(i + 1 + ": " + playerMoves[i].toString() + "\n");
			}
			Scene.printToScreen("Or press 5 to switch out pokemon");
			try
			{
				in = new Scanner(System.in);
				int userIndex = in.nextInt();
				userIndex--;
				if (userIndex >= 0 && userIndex <= 3)
				{
					validInput = true;
					player.getCurrPokemon().attack(computer.getCurrPokemon(), playerMoves[userIndex]);
				} else if (userIndex == 4)
				{
					// switch out pokemon
					validInput = selectPlayerCurrPoke();

				} else
				{
					Scene.printToScreen("Invalid command #");
				}
			} catch (InputMismatchException e)
			{
				Scene.printToScreen("Invalid command #, this is not a number");
			}
		}
	}

	private boolean selectPlayerCurrPoke() {
		boolean switchMade = false;
		ArrayList<Pokemon> alPokemon = player.getAllPokemon();

		Scanner in;
		boolean validInput = false;
		while (validInput == false)
		{

			Scene.printToScreen("Enter the # of the move you want to use");
			int indexCounter = -1;
			for (Pokemon poke : alPokemon)
			{
				indexCounter++;
				Scene.printToScreen((indexCounter + 1) + ": " + alPokemon.get(indexCounter).getName());
			}
			Scene.printToScreen("Or press 0 to go back to attack screen");

			try
			{
				in = new Scanner(System.in);
				int userIndex = in.nextInt();
				userIndex--;
				if (userIndex == -1)
				{
					// decided to not switch
					validInput = true;
				} else if (userIndex >= 0 && userIndex <= alPokemon.size())
				{
					// switch to the new curr pokemon
					player.setCurrPokemon(alPokemon.get(userIndex));
					Scene.printToScreen(player.getName() + " sent out " + player.getCurrPokemon().getName());
					validInput = true;
					switchMade = true;
				} else
				{
					validInput = false;
				}
			} catch (InputMismatchException e)
			{

			}
		}

		return switchMade;
	}

	public Trainer getPlayer() {
		return player;
	}

	public Trainer getComputer() {
		return computer;
	}

	private boolean isGameOver() {
		boolean gameOver = false;
		if (player.checkLost() || computer.checkLost())
		{
			gameOver = true;
		}

		return gameOver;
	}

	private Trainer whoWon() {
		Trainer winner;
		if (player.checkLost())
		{
			winner = computer;
		} else
		{
			winner = player;
		}

		return winner;
	}

	public void startBattle() {

		while (isGameOver() == false)
		{
			displayTrainersAndPokemon();

			computerTurn();
			if (isGameOver() == false)
			{
				displayTrainersAndPokemon();
				Scene.printToScreen(
						"Trainer " + computer.getName() + " has " + computer.getAllPokemon().size() + " pokemon left.");
				playerTurn();
			}
			System.out.println("\n\n");
		}
		if (whoWon().equals(player))
		{
			Scene.printToScreen("Trainer " + player.getName() + " defeated Trainer " + computer.getName());
		} else
		{
			Scene.printToScreen("Trainer " + computer.getName() + " defeated Trainer " + player.getName());
		}
	}

	public void displayTrainersAndPokemon() {
		Scene.printToScreen("\n" + player.getName() + "\'s " + player.getCurrPokemon().getName() + " hp="
				+ player.getCurrPokemon().getHP() + " vs " + computer.getName() + "\'s "
				+ computer.getCurrPokemon().getName() + " hp=" + computer.getCurrPokemon().getHP());
	}

}
