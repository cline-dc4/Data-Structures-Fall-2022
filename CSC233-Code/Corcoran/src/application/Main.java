package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * Homework Assignment 7
 * @author Savannah
 * Due Date: 10/03/22
 */
public class Main extends Application {
	
	/**
	 * This is the SportsEvent Variable
	 */
	private SportsEventPane sep;
	
	/**
	 * This is the TheaterEvent Variable
	 */
	private TheaterEventPane tep;
	
	/**
	 * This the center text area variable
	 */
	private TextArea centerTextArea;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1100,600);
			primaryStage.setTitle("HW 08");
			
			addComponents(root);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This sets the panes of the GUI
	 * @param root The GUI?
	 */
	public void addComponents(BorderPane root)
	{
		
		centerTextArea = new TextArea();
		root.setCenter(centerTextArea);
		
		sep = new SportsEventPane(centerTextArea);
		root.setLeft(sep);
		
		tep = new TheaterEventPane(centerTextArea);
		root.setRight(tep);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
