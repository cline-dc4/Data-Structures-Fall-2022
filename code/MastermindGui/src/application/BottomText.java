package application;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * this class controls all the text on the bottom of the screen.
 * @author DC
 * @version 12/9/22
 */
public class BottomText extends GridPane
{
	/** pointer to the game backend */
	private MastermindBackend game;
	/** the text that shows if player selects debug mode */
	private Label codeText;
	/** string used to hold the secret code */ 
	private String codeString;

	/**
	 * the constructor for the bottomText object, which controls the code text on the bottom.
	 * @param game a pointer to the game object.
	 */
	public BottomText(MastermindBackend game)
	{
		this.game = game;
		codeString = "";
		for (int i = 0; i < game.getCodeArray().length; i++)
		{
			codeString += game.getCodeArray()[i] + " ";
		}
		codeText = new Label("");
		this.add(codeText, 0, 0);
	}

	/**
	 * adds the code to the bottom text area, called by the menuItem debug.
	 */
	public void addCode()
	{
		codeText.setText("The secret code is " + codeString);
	}

	/**
	 * resets the code string when the game is reset.
	 */
	public void resetCode()
	{
		codeString = "";
		for (int i = 0; i < game.getCodeArray().length; i++)
		{
			codeString += game.getCodeArray()[i] + " ";
		}
		if(codeText.getText() != "")
		{
			addCode();
		}
	}

}
