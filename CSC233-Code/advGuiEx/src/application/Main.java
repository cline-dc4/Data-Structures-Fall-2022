package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;


public class Main extends Application implements EventHandler<ActionEvent>{
	
	private MenuItem openFileMI;
	private MenuItem saveFileMI;
	private MenuItem clearTAMI;
	
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// adding a menu bar with menus and menu items
			MenuBar mb = new MenuBar();
			Menu fileMenu = new Menu("File");
			Menu editMenu = new Menu("Edit");
			
			//adding menu items to File menu
			openFileMI = new MenuItem("Open file");
			saveFileMI = new MenuItem("Save file");
			fileMenu.getItems().add(openFileMI);
			fileMenu.getItems().add(saveFileMI);
			
			// adding menu items to Edit menu
			clearTAMI = new MenuItem("Clear text area");
			openFileMI.setOnAction(this);
			saveFileMI.setOnAction(this);
			clearTAMI.setOnAction(this);
			editMenu.getItems().add(clearTAMI);
			mb.getMenus().add(fileMenu);
			mb.getMenus().add(editMenu);
			root.setTop(mb);
			// end adding menu bar
			
			//add gridpane of buttons to center
			ButtonGrid bg = new ButtonGrid();
			root.setCenter(bg);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void handle(ActionEvent event) {
		System.out.println("Button pressed");
		
		if (event.getSource() == openFileMI)
		{
			System.out.println("Open File MI pressed");
			FileChooser fc = new FileChooser();
			File returnedFile = fc.showOpenDialog(null);
			if (returnedFile != null)
			{
				System.out.println("Name of file: " + returnedFile);
				try 
				{
					Scanner fileInput = new Scanner(returnedFile);
					for (int i = 0; i < 10; i++)
					{
						int number = fileInput.nextInt();
						System.out.println("Number: " + number);
					}
				} 
				catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
			}
		}
		
		else if (event.getSource() == saveFileMI)
			
		{
			System.out.println("safe file MI pressed");
			FileChooser fc = new FileChooser();
			File returnedFile = fc.showSaveDialog(null);
			if (returnedFile != null)
			{
				System.out.println(returnedFile);
				//write to file
				try 
				{
					PrintWriter outputFile = new PrintWriter(returnedFile);
					for (int i = 0; i < 100; i++)
					{
						outputFile.println(i);
					}
					outputFile.close();
				} 
				catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
			}
		}
		else if (event.getSource() == clearTAMI)
			System.out.println("Edit pressed");
	}
}
