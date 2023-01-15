package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
/**
 * This class adds the game board, which is a 2-dimensional array of buttons, 
 * to the GUI.
 * @author DC
 * @version 12/12/22
 */


public class GameBoard extends GridPane implements ColorCodes
{

	/** pointer to the game object */
	private MastermindBackend game;
	/** array of buttons that serves as the game board */
	private Button [][] guesses;
	/** array of buttons that shows the hint pegs */
	private Button [][] hint;
	/** pointer to the guessButtons object */
	private GuessButtons guessButtons;

	/*
	 * the constructor that initializes all elements in the game board.
	 */
	public GameBoard(MastermindBackend game, GuessButtons guessButtons)
	{
		guesses = new Button[Backend.NUM_ROWS][Backend.CODE_LENGTH];
		hint = new Button[Backend.NUM_ROWS][Backend.CODE_LENGTH];
		this.guessButtons = guessButtons;
		this.game = game;
		for (int i = 0; i < guesses.length; i++)
		{
			for (int j = 0; j < guesses[0].length; j++)
			{
				guesses[i][j] = new Button();
			}
		}
		for (int i = 0; i < guesses.length; i++)
		{
			for(int j = 0; j < guesses[0].length; j++)
			{
				guesses[i][j].setStyle(CODE_WHITE);
				this.add(guesses[i][j], j, i);
			}
		}

		for(int i = 0; i < hint.length; i++)
		{
			for(int j = 0; j < hint[0].length; j++)
			{
				hint[i][j] = new Button();
			}
		}
		for(int i = 0; i < hint.length; i++)
		{
			for(int j = 0; j < hint[0].length; j++)
			{
				hint[i][j].setStyle(CODE_WHITE);
				this.add(hint[i][j], j + Backend.CODE_LENGTH, i);
			}
		}
	}

	/**
	 * will output the hint pegs to the GUI.
	 * should only be called after submitGuess in MastermindBackend has been called.
	 * @param guessArray is an char array of length CODE_LENGTH that contains user input.
	 */
	public void getHint()
	{
		//will allow two separate loops for changing button colors/borders.
		int index = 0;
		//adds the black pegs, which are shown as a black background.
		for (int i = 0; i < game.getHintHistoryArray()[game.getNumberGuesses() - 1][0]; i++)
		{
			hint[(game.getNumberGuesses() - 1)][i].setStyle(CODE_BLACK);
			index++;
		}
		//adds the white pegs, which are shown as borders.
		for (int i = 0; i < (game.getHintHistoryArray()[(game.getNumberGuesses() - 1)][1]); i++)
		{
			hint[(game.getNumberGuesses() - 1)][i + index].setStyle(CODE_BORDER);
		}
	}

	/**
	 * function that adds buttons when a user clicks one of the colored buttons on the right.
	 * @param colorIndex 0 for red, 1 for blue, 2 for yellow, 3 for green, 4 for orange, 5 for brown
	 */
	public void showInput(int colorIndex, int buttonPresses)
	{
		switch(colorIndex)
		{
		//red
		case 0:
		{
			guesses[game.getNumberGuesses()][buttonPresses].setStyle(CODE_RED);
			break;
		}
		//blue
		case 1:
		{
			guesses[game.getNumberGuesses()][buttonPresses].setStyle(CODE_BLUE);
			break;
		}
		//yellow
		case 2:
		{
			guesses[game.getNumberGuesses()][buttonPresses].setStyle(CODE_YELLOW);
			break;
		}
		//green
		case 3:
		{
			guesses[game.getNumberGuesses()][buttonPresses].setStyle(CODE_GREEN);
			break;
		}
		//orange
		case 4:
		{
			guesses[game.getNumberGuesses()][buttonPresses].setStyle(CODE_ORANGE);
			break;
		}
		//brown
		case 5:
		{
			guesses[game.getNumberGuesses()][buttonPresses].setStyle(CODE_PURPLE);
			break;
		}
		}
	}

	/**
	 * causes the current row based on numberGuesses to be set to white.
	 */
	public void clearRow()
	{
		for (int i = 0; i < guesses[0].length; i++)
		{
			guesses[game.getNumberGuesses()][i].setStyle(CODE_WHITE);
		}
	}

	/**
	 * causes every button in the array guesses to be set to white,
	 * and resets the guess array.
	 */
	public void clearBoard()
	{
		//clear guesses
		for (int i = 0; i < guesses.length; i++)
		{
			for (int j = 0; j < guesses[0].length; j++)
			{
				guesses[i][j].setStyle(CODE_WHITE);
			}
		}

		//clear hints
		for (int i = 0; i < hint.length; i++)
		{
			for (int j = 0; j < hint[0].length; j++)
			{
				hint[i][j].setStyle(CODE_WHITE);
			}
		}
	}
}
