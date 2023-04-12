package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * The main function for the GUI, creates it and
 * uses SportsEventPane and TheaterEventPane
 * to create the left and right sides.
 * @author DC
 *@version 10/2/22
 */
public class Main extends Application 
{
	/** variable for the sportsEvent elements on the left side. */
	private SportsEventPane sportsP;
	/** variable for the theaterEvent elements on the right side. */
	private TheaterEventPane theaterP;
	/** pointer for the TextArea so other classes can access it. */
	private TextArea centerTA;
	
	/**
	 * This function creates the GUI using both
	 * SportsEventPane and TheaterEventPane.
	 */
	public void start(Stage primaryStage) 
	{
		try 
		{
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,700,400);
			
			primaryStage.setTitle("HW 7");
			centerTA = new TextArea();
			root.setCenter(centerTA);
			sportsP = new SportsEventPane(centerTA);
			root.setLeft(sportsP);
			theaterP = new TheaterEventPane(centerTA);
			root.setRight(theaterP);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
}
	
