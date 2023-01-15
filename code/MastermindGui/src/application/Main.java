package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;

/**
 * The main class for the Mastermind GUI.
 * @author DC
 * @version 12/9/22
 */
public class Main extends Application
{
	private MastermindBackend game;
	private GameBoard gameBoard;
	private GuessButtons guessButtons;
	private BottomText bottomText;
	private TopBar topBar;

	/**
	 * the constructor for the main, initializes all GUI elements.
	 */
	public Main()
	{
		game = new MastermindBackend();
		gameBoard = new GameBoard(game, guessButtons);
		guessButtons = new GuessButtons(game, gameBoard);
		bottomText = new BottomText(game);
		topBar = new TopBar(game, bottomText, gameBoard, guessButtons);
	}
	
	/**
	 * adds all GUI elements to the BorderPane.
	 */
	public void start(Stage primaryStage) 
	{
		try
		{
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,300);
			
			primaryStage.setTitle("Mastermind - DC Cline");
			
			root.setLeft(gameBoard);
			root.setRight(guessButtons);
			root.setBottom(bottomText);
			root.setTop(topBar);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) 
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error adding guess");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
