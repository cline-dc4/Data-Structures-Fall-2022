import java.util.Random;
import java.util.Scanner;

/** 
 * CSC233 Final Project
 * @author crissy sanders
 * @version December 1, 2022
 */
public class projectMain 
{
	
	public static void main (String [] args) 
	{
		gameFunctions game = new gameFunctions();
		
		// opening scanner for user input
		Scanner userInput = new Scanner(System.in);
		
		// introduction and instructions for gameplay
		String introText = "";
		introText += "Welcome to Mastermind. Guess the four-color code within ten tries to win! \n";
		introText += "Color options: Red, Orange, Yellow, Green, Blue, or Purple \n";
		introText += "To guess one of these colors, type the first letter (lowercase) of the corresponding color. \n";
		introText += "Make sure to put a space between each letter of your guess. \n";
		introText += "Insert your guess here: ";
		System.out.print(introText);
		

		while (game.guessLimitReached() == false)
		{
			char [] guessedCode = new char [4];
			for (int guessIndex = 0; guessIndex < 4; guessIndex++)
			{
				guessedCode[guessIndex] = userInput.next().charAt(0);
			}
			ColorCode userGuess = new ColorCode(guessedCode);
			game.addGuess(userGuess);
			System.out.print(game.guessFeedback(userGuess));
			//System.out.println(game);
		}	
		if (game.guessLimitReached() == true)
		{
			System.out.println("YOU LOSE");
		}
		
	}
}
