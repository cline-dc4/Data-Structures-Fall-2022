import java.util.Scanner;

public class ConsoleMain 
{
	/**
	 * the main function for running Mastermind in the console.
	 */
	public static void main(String[] args)
	{
		//instance variables:
		Scanner keyboard = new Scanner(System.in);
		MastermindBackend game = new MastermindBackend();
		char [] guessArray = new char[game.CODE_LENGTH];
		//game loop
		while(!game.loseCondition() && !game.winCondition())
		{
			//testing
			System.out.println(game.codeArray);
			System.out.println(game);
			System.out.println("Please enter your guess. It must be " + game.CODE_LENGTH + " seperate characters chosen from the key at the top.");
			for(int i = 0; i < guessArray.length; i++)
			{
				guessArray[i] = keyboard.next().charAt(0);
			}
			try 
			{
				game.submitGuess(guessArray);
			} 
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
		if (game.loseCondition())
		{
			System.out.println("Sorry! You lost the game.");
		}
		else if (game.winCondition())
		{
			System.out.println("You win! Your score is: " + game.calculateScore());
		}

	}

}
