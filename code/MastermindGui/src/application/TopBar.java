package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.control.MenuBar;

/**
 * This class controls the top menuBar in the Mastermind game.
 * @author DC
 * @version 12/9/22
 */
public class TopBar extends GridPane implements EventHandler<ActionEvent>
{
	/** a pointer to the game backend */
	private MastermindBackend game;
	/** a pointer to the bottom text area. */
	private BottomText bottomText;
	/** pointer to the gameBoard */
	private GameBoard gameBoard;
	/** pointer to the guessButtons */
	private GuessButtons guessButtons;
	/** will cause the game to start fresh */
	private MenuItem resetGame;
	/** will print out the code in the bottom gridPane */
	private MenuItem debug;
	/** will exit the GUI */
	private MenuItem quit;

	/**
	 * the constructor for the top bar
	 * @param game a pointer to the game object
	 * @param bottomText a pointer to the bottomText object
	 * @param gameBoard a pointer to the gameBoard object
	 * @param guessButtons a pointer to the guessButtons object
	 */
	TopBar(MastermindBackend game, BottomText bottomText, GameBoard gameBoard, GuessButtons guessButtons)
	{
		this.game = game;
		this.bottomText = bottomText;
		this.gameBoard = gameBoard;
		this.guessButtons = guessButtons;
		
		MenuBar mb = new MenuBar();
		Menu optionsMenu = new Menu("Options");

		resetGame = new MenuItem("Reset Game");
		debug = new MenuItem("Debug Mode");
		quit = new MenuItem("Quit");
		optionsMenu.getItems().add(resetGame);
		optionsMenu.getItems().add(debug);
		optionsMenu.getItems().add(quit);

		resetGame.setOnAction(this);
		debug.setOnAction(this);
		quit.setOnAction(this);

		mb.getMenus().add(optionsMenu);

		this.add(mb, 0, 0);	}
	
	/**
	 * the handle method that makes the buttons
	 * do what they are supposed to do
	 */
	public void handle(ActionEvent event)
	{

		if(event.getSource() == resetGame)
		{
			gameBoard.clearBoard();
			guessButtons.clearGuess();
			game.resetGame();
			bottomText.resetCode();
			
		}
		if(event.getSource() == debug)
		{
			bottomText.addCode();
		}
		if(event.getSource() == quit)
		{
			System.exit(0);
		}

	}
}
