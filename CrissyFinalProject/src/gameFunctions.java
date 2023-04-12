/** 
 * CSC233 Final Project
 * @author crissy sanders 
 * @version December 1, 2022
 */
public class gameFunctions 
{
	/** this is the instance variable for the number of guesses the user has submitted */
	private int numberGuesses;

	/** this is the instance variable for the color code for the user to guess */
	private ColorCode codeToGuess;

	/** this is the instance variable for the array of guesses the user has submitted*/
	private ColorCode [] arrayOfGuesses;

	/** this is the instance variable for the two-dimensional array of feedback pegs */
	private int [][] arrayOfFeedbackPegs;

	/** this is the instance variable to keep track of feedback pegs so it doesn't double count */
	private char [] pegCounter;

	public gameFunctions ()
	{
		codeToGuess = new ColorCode();

	}

	/**
	 * this method determines if the user has reached the limit of 10 guesses
	 * @return true if the limit is reached, false if they still have guesses remaining
	 */
	public boolean guessLimitReached ()
	{
		if (numberGuesses == 10)
			return true;
		else 
			return false;
	}

	/**
	 * this method adds the black and white pegs to the array of feedback for each guess
	 * @param userGuess the guess for which feedback is being recorded
	 */
	public void addFeedback (ColorCode userGuess)
	{
		for (int feedbackPegs = 0; feedbackPegs < 2; feedbackPegs++)
		{
			if (feedbackPegs == 0)
				arrayOfFeedbackPegs[numberGuesses][feedbackPegs] = numberCorrect(userGuess);
			else if (feedbackPegs == 1)
				arrayOfFeedbackPegs[numberGuesses][feedbackPegs] = numberMisplaced(userGuess);
		}
	}

	/**
	 * this method adds the user's guess to the array of all guesses
	 * @param userGuess the guessed code being added to the array
	 */
	public void addGuess (ColorCode userGuess)
	{
		arrayOfGuesses = new ColorCode [10];
		arrayOfGuesses[numberGuesses] = userGuess;
		numberGuesses += 1;
	}

	/**
	 * This method checks for the number of correct colors within the guessed code. 
	 * @param guessedCode The guessed code submitted by the user
	 * @return The number of correct colors (black pegs)
	 */
	public int numberCorrect (ColorCode guessedCode)
	{ 
		
		pegCounter = new char [4];
		for (int index = 0; index < 4; index++)
		{
			pegCounter[index] = codeToGuess.getColor(index);
		}
		int numberCorrect = 0;
		for (int index = 0; index < 4; index++)
		{
			if (pegCounter[index] == guessedCode.getColor(index))
			{
				pegCounter[index] = 'x';
				numberCorrect += 1;
			}
		}
		return numberCorrect;
	}

	/**
	 * This method checks for the number of misplaced colors within the guessed code
	 * @param guessedCode The guessed code the user submitted
	 * @return The number of correct but misplaced colors (white pegs)
	 */
	public int numberMisplaced (ColorCode guessedCode)
	{
		int numberMisplaced = 0;
		for (int index = 0; index < 4; index++)
		{
			for (int otherIndex = 0; otherIndex < 4; otherIndex++)
			{
				if (pegCounter[index] != 'x' && index != otherIndex)
				{
					if (guessedCode.getColor(otherIndex) == pegCounter[index])
					{
						pegCounter[index] = 'x';
						numberMisplaced += 1;
					}
				}
			}
		}
//		for (int index = 0; index < 4; index++)
//		{
//			for (int correctIndex = 0; correctIndex < 4; correctIndex++)
//			{
//				if (pegCounter[index] != 'x' && correctIndex != index && guessedCode.getColor(index) == pegCounter[index])
//				{
//					pegCounter[index] = 'x';
//					numberMisplaced += 1; 
//				}
//			}
//		}
		return numberMisplaced;
	}


	/**
	 * This returns a string for the user to see the feedback on their guess
	 * @param guessedCode The guessed code submitted by the user
	 * @return The string containing feedback for the user 
	 */
	public String guessFeedback (ColorCode guessedCode)
	{
		// this line will need to be deleted - it's just for testing purposes
		System.out.println("Code: " + codeToGuess);
		
		String feedbackString = "";
		feedbackString += "Guess number " + numberGuesses + ": You guessed: " + guessedCode ;
		if (numberCorrect(guessedCode) == 4)
			return "YOU WON!";
		else
			feedbackString += "Black pegs: " + numberCorrect(guessedCode) + " ";
		feedbackString += "White pegs: " + numberMisplaced(guessedCode) + "\n";
		return feedbackString;
	}
	
//	public String toString()
//	{
//		String stringToPrint = "";
//		for (int index = 0; index < numberGuesses - 1; index++)
//		{
//			stringToPrint += guessFeedback(arrayOfGuesses[index]);
//		}
//		return stringToPrint;
//	}
}
