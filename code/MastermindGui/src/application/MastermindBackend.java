package application;
import java.util.Random;

/**
 * The class that handles all the backend for the game
 * Mastermind.
 * Note: many javadocs are stored in Backend.java
 * @author DC
 * @version 12/9/22
 */
public class MastermindBackend implements Backend
{
	/** stores how many guesses the user has made */
	private int numberGuesses;

	/** stores the code the user is guessing */
	//TODO change public to private when done testing
	private char [] codeArray;

	/** a 2D array that holds all guesses made during the game */
	private char [][] guessHistoryArray;

	/** a 2D array that holds all hints given during the game */
	private int [][] hintHistoryArray;

	/** a boolean that will break the game loop if true */
	private boolean win;

	/**
	 * the constructor for MastermindBackend
	 * this sets all states to default values appropriate to the
	 * rules of the Mastermind game.
	 */
	public MastermindBackend()
	{
		numberGuesses = 0;
		codeArray = new char[CODE_LENGTH];
		generateCode();
		guessHistoryArray = new char[NUM_ROWS][CODE_LENGTH];
		hintHistoryArray = new int[NUM_ROWS][NUM_HINT_COL];
		win = false;
	}

	public int calculateScore()
	{
		return (11 - numberGuesses);
	}

	public int getNumberGuesses()
	{
		return (numberGuesses);
	}

	public int [][] getHintHistoryArray()
	{
		return hintHistoryArray;
	}

	public char [] getCodeArray()
	{
		return codeArray;
	}

	public void resetGame()
	{
		numberGuesses = 0;
		codeArray = new char[CODE_LENGTH];
		generateCode();
		guessHistoryArray = new char[NUM_ROWS][CODE_LENGTH];
		hintHistoryArray = new int[NUM_ROWS][NUM_HINT_COL];
		win = false;
	}

	public void checkHintPegs(char guess []) throws Exception
	{
		//copies the code array so it can be changed.
		char [] tempCode = new char[CODE_LENGTH];
		for (int i = 0; i < tempCode.length; i++)
		{
			tempCode[i] = codeArray[i];
		}
		// this loop checks for black pegs and changes the
		// tempCode array to avoid double counting.
		for (int i = 0; i < codeArray.length; i++)
		{
			if(guess[i] == tempCode[i])
			{
				guess[i] = '~';
				tempCode[i] = '~';
				hintHistoryArray[numberGuesses][0]++;
			}
		}

		//this nested loop checks for white pegs.
		for (int i = 0; i < codeArray.length; i++)
		{
			for(int j = 0; j < codeArray.length; j++)
			{
				if(i != j && tempCode[j] != '~' && guess[i] != '~' && guess[i] ==  tempCode[j])
				{
					guess[i] = '~';
					tempCode[j] = '~';
					hintHistoryArray[numberGuesses][1]++;
				}
			}
		}
		//win condition
		if(hintHistoryArray[numberGuesses][0] == 4)
		{
			win = true;
		}
	}

	public void generateCode()
	{
		Random generator = new Random();
		for (int i = 0; i < codeArray.length; i++)
		{
			switch(generator.nextInt(6))
			{
			case 0:
			{
				codeArray[i] = COLOR_RED;
				break;
			}
			case 1:
			{
				codeArray[i] = COLOR_BLUE;
				break;
			}
			case 2:
			{
				codeArray[i] = COLOR_YELLOW;
				break;
			}
			case 3:
			{
				codeArray[i] = COLOR_GREEN;
				break;
			}
			case 4:
			{
				codeArray[i] = COLOR_ORANGE;
				break;
			}
			case 5:
			{
				codeArray[i] = COLOR_PURPLE;
				break;
			}
			}
		}
	}

	public void submitGuess(char guessArray []) throws Exception 
	{
		//exceptions
		for(int i = 0; i < guessArray.length; i++)
		{
			if(guessArray[i] != COLOR_RED && guessArray[i] != COLOR_BLUE && guessArray[i] != COLOR_YELLOW
					&& guessArray[i] != COLOR_GREEN && guessArray[i] != COLOR_ORANGE && guessArray[i] != COLOR_PURPLE)

			{
				throw new Exception("The guesses must be completely filled in and must be one of the six colors listed.");
			}
		}
		//update guessHistoryArray
		for(int i = 0; i < guessHistoryArray[numberGuesses].length; i++)
		{
			guessHistoryArray[numberGuesses][i] = guessArray[i];
		}

		checkHintPegs(guessArray);
		numberGuesses++;
	}

	public boolean loseCondition()
	{
		if (numberGuesses >= 10)
		{
			return true;
		}
		return false;
	}

	public boolean winCondition()
	{
		return win;
	}

	public String toString()
	{
		String boardString = "";
		boardString += "Key: \nr: Red\nl: Blue\ny: Yellow\ng: Green\no: Orange\nb: Brown\n****************\n";
		//prints out a line each iteration.
		for (int i = 0; i < numberGuesses; i++)
		{
			//guesses
			boardString += guessHistoryArray[i][0] + " " + guessHistoryArray[i][1] + " " +
					guessHistoryArray[i][2] + " " + guessHistoryArray[i][3] + "  ";
			//hints
			boardString += "Hints: # black pegs: " + hintHistoryArray[i][0] + 
					" # white pegs: " + hintHistoryArray[i][1] + "\n";
		}

		return boardString;
	}

}
