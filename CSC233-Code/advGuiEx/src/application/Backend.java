package application;
/**
 * an interface made to hold javadocs and static final chars
 * to make the MastermindBackend class more clean and readable.
 * @author DC
 * @version 11/22/22
 */
public interface Backend 
{
	/** used to compare chars, r is used for red */
	public static final char COLOR_RED = 'r';
	
	/** used to compare chars, l is used for blue */
	public static final char COLOR_BLUE = 'l';
	
	/** used to compare chars, y is used for yellow */
	public static final char COLOR_YELLOW = 'y';
	
	/** used to compare chars, g is used for green*/
	public static final char COLOR_GREEN = 'g';
	
	/** used to compare chars, o is used for orange */
	public static final char COLOR_ORANGE = 'o';
	
	/** used to compare chars, b is used for brown */
	public static final char COLOR_BROWN = 'b';

	/** used to store the # of rows for history arrays. */
	public static final int NUM_ROWS = 10;
	
	/** used to store the # of columns for hintHistoryArray */
	public static final int NUM_HINT_COL = 2;
	
	/** used to store the length of the code */
	public static final int CODE_LENGTH = 4;
	
	/**
	 * calculates the score earned by the player.
	 * @return the score, calculated by 10 - numberGuesses + 1
	 */
	public int calculateScore();
	
	/**
	 * checkHintPegs changes the instance variable currentHint[]
	 * The first int corresponds with the number of white pegs
	 * the player earned.
	 * The second int corresponds with the number of black pegs
	 * the player earned.
	 */
	public void checkHintPegs(char guess []) throws Exception;
	
	/**
	 * uses random numbers mod 6 to create the code, stored
	 * in an instance variable. Each number 0-5 corresponds 
	 * with a char that will be stored in the code.
	 * this function will also update both 2D arrays that
	 * hold the guess and hint history of the current game.
	 */
	public void generateCode();
	
	/**
	 * allows the player to enter and submit their guess. User
	 * can enter Strings separated by a space which are then 
	 * converted into the appropriate chars. Will first list 
	 * appropriate strings before allowing user to input them.
	 * 
	 * @throws Exception if user enters more or less than 4 
	 * separated strings, or if user enters a string that isn't
	 * one of the colors listed
	 */
	public void submitGuess(char guessArray []) throws Exception;
	
	/**
	 * checks if the player has lost the game or not
	 * @return true if numberGuesses == 10, else false.
	 */
	public boolean loseCondition();
	
	/**
	 * simply returns the variable win.
	 * @return win
	 */
	public boolean winCondition();
	
	/**
	 * this toString will convert the 2D arrays into a readable
	 * string for the console version of the game. Will look
	 * similar to the board of the game and include a key that
	 * tells the user which character corresponds to each color.
	 * @return the string described above.
	 */
	public String toString();
}
