package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * this class creates all the buttons used to submit guesses on the
 * right side of the gui.
 * @author DC
 * @version 12/9/22
 */
public class GuessButtons extends GridPane implements EventHandler<ActionEvent>, ColorCodes
{

	/** the button to submit red */
	private Button redButton;
	/** the button to submit blue */
	private Button blueButton;
	/** the button to submit yellow */
	private Button yellowButton;
	/** the button to submit green */
	private Button greenButton;
	/** the button to submit orange */
	private Button orangeButton;
	/** the button to submit purple */
	private Button purpleButton;
	/** the button that submits the guess */
	private Button submitButton;
	/** the button that clears the current guess */
	private Button clearButton;
	/** pointer to the MastermindBackend object */
	private MastermindBackend game;
	/** pointer to the GameBoard elements of the GUI */
	private GameBoard gameBoard;
	/** an int that stores how many button presses a user has made on the colored buttons.. */
	private int buttonPresses;
	/** array that holds guesses for the MastermindBackend object */
	char [] guess;

	/**
	 * the constructor that initializes every intractable button on the right side of the GUI.
	 * @param game a pointer to the game object.
	 * @param gameBoard a pointer to the gameBoard elements of the GUI
	 */
	GuessButtons(MastermindBackend game, GameBoard gameBoard)
	{
		this.game = game;
		this.gameBoard = gameBoard;
		guess = new char[Backend.CODE_LENGTH];
		buttonPresses = 0;

		try 
		{
			//setting the images and initializing the buttons
			Image redImage;
			redImage = new Image(new FileInputStream("colorImages\\red.png"));
			ImageView redIV = new ImageView(redImage);
			redButton = new Button();
			redButton.setGraphic(redIV);

			Image orangeImage;
			orangeImage = new Image(new FileInputStream("colorImages\\orange.png"));
			ImageView orangeIV = new ImageView(orangeImage);
			orangeButton = new Button();
			orangeButton.setGraphic(orangeIV);

			Image yellowImage;
			yellowImage = new Image(new FileInputStream("colorImages\\yellow.png"));
			ImageView yellowIV = new ImageView(yellowImage);
			yellowButton = new Button();
			yellowButton.setGraphic(yellowIV);

			Image greenImage;
			greenImage = new Image(new FileInputStream("colorImages\\green.png"));
			ImageView greenIV = new ImageView(greenImage);
			greenButton = new Button();
			greenButton.setGraphic(greenIV);
			
			Image blueImage;
			blueImage = new Image(new FileInputStream("colorImages\\blue.png"));
			ImageView blueIV = new ImageView(blueImage);
			blueButton = new Button();
			blueButton.setGraphic(blueIV);


			Image purpleImage;
			purpleImage = new Image(new FileInputStream("colorImages\\purple.png"));
			ImageView purpleIV = new ImageView(purpleImage);
			purpleButton = new Button();
			purpleButton.setGraphic(purpleIV);

			submitButton = new Button("Submit");
			clearButton = new Button("Clear");
		} 
		catch (FileNotFoundException e) 
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("File doesn't exist");
			alert.setContentText("Missing an image that is used in the GUI");
			alert.showAndWait();
		}
		//adding the buttons
		submitButton.setOnAction(this);
		this.add(redButton, 0, 1);
		this.add(orangeButton, 1, 1);
		this.add(yellowButton, 2, 1);
		this.add(greenButton, 0, 2);
		this.add(blueButton, 1, 2);
		this.add(purpleButton, 2, 2);
		this.add(submitButton, 0, 3);
		this.add(clearButton, 1, 3);

		//setting the actions
		redButton.setOnAction(this);
		blueButton.setOnAction(this);
		yellowButton.setOnAction(this);
		greenButton.setOnAction(this);
		orangeButton.setOnAction(this);
		purpleButton.setOnAction(this);

		clearButton.setOnAction(this);
	}

	/**
	 * returns the buttonPresses variable
	 * @return buttonPresses
	 */
	public int getButtonPresses()
	{
		return buttonPresses;
	}

	/**
	 * a function that clears the guess[] instance variable.
	 */
	public void clearGuess()
	{
		for (int i = 0; i < guess.length; i++)
		{
			guess[i] = '\0';
		}
		buttonPresses = 0;
	}

	/**
	 * controls all the buttons' responses to being clicked on.
	 */
	public void handle(ActionEvent event)
	{
		//error handling
		if(event.getSource() != clearButton && event.getSource() != submitButton && buttonPresses >= Backend.CODE_LENGTH)
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error adding guess");
			alert.setContentText("You can only add 4 guesses at a time.\nPress clear if you would like to change your guess.");
			alert.showAndWait();
		}
		//red button
		else if(event.getSource() == redButton)
		{
			gameBoard.showInput(0, buttonPresses);
			guess[buttonPresses] = Backend.COLOR_RED;
			buttonPresses++;
		}	
		//blue button
		else if(event.getSource() == blueButton)
		{
			gameBoard.showInput(1, buttonPresses);
			guess[buttonPresses] = Backend.COLOR_BLUE;
			buttonPresses++;
		}
		//yellow button
		else if(event.getSource() == yellowButton)
		{
			gameBoard.showInput(2, buttonPresses);
			guess[buttonPresses] = Backend.COLOR_YELLOW;
			buttonPresses++;
		}
		//green button
		else if(event.getSource() == greenButton)
		{
			gameBoard.showInput(3, buttonPresses);
			guess[buttonPresses] = Backend.COLOR_GREEN;
			buttonPresses++;
		}
		//orange button
		else if(event.getSource() == orangeButton)
		{
			gameBoard.showInput(4, buttonPresses);
			guess[buttonPresses] = Backend.COLOR_ORANGE;
			buttonPresses++;
		}
		//brown button
		else if(event.getSource() == purpleButton)
		{
			gameBoard.showInput(5, buttonPresses);
			guess[buttonPresses] = Backend.COLOR_PURPLE;
			buttonPresses++;
		}
		//clear button
		else if(event.getSource() == clearButton)
		{
			gameBoard.clearRow();
			buttonPresses = 0;
			for(int i = 0; i < guess.length; i++)
			{
				guess[i] = '\0';
			}
		}
		//submit button
		else if(event.getSource() == submitButton)
		{
			try 
			{
				game.submitGuess(guess);
			} 
			catch (Exception e) 
			{
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error submitting guess");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
			gameBoard.getHint();
			buttonPresses = 0;
			for(int i = 0; i < guess.length; i++)
			{
				guess[i] = '\0';
			}	
			//win alert
			if(game.winCondition())
			{
				Alert winAlert = new Alert(Alert.AlertType.INFORMATION);
				winAlert.setTitle("You won!!!");
				winAlert.setContentText("Congrats! You won the game with " + game.calculateScore() + " points! If you would like to play again, "
						+ "go click on \"Reset Game\" in the options menu.");
				winAlert.showAndWait();
			}
			//lose alert
			if(game.loseCondition())
			{
				Alert loseAlert = new Alert(Alert.AlertType.INFORMATION);
				loseAlert.setTitle("You lost. :(");
				loseAlert.setContentText("Sorry, you lost the game. If you would like to play again,"
						+ "go click on \"Reset Game\" in the options menu.");
				loseAlert.showAndWait();
			}
		}
	}

}
