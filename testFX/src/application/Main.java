package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


public class Main extends Application 
{
	
	private LeftPane lp;
	private TextArea centerTA;
	
	public void start(Stage primaryStage) 
	{
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			primaryStage.setTitle("My first GUI");
			addComponents(root);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addComponents(BorderPane root)
	{
		TextField topTF = new TextField();
		root.setTop(topTF);
		Label bottomL = new Label("This will show up in the bottom");
		root.setBottom(bottomL);
		centerTA = new TextArea();
		root.setCenter(centerTA);
		//Button leftB = new Button("Left button");
		//root.setLeft(leftB);
		lp = new LeftPane(centerTA);
		root.setLeft(lp);
		ComboBox<String> rightCB = new ComboBox<String>();
		rightCB.getItems().addAll("Apple", "Banana", "Cantaloupe");
		root.setRight(rightCB);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
