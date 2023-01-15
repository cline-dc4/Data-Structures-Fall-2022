package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application  implements EventHandler<ActionEvent>
{
	/** A pointer to the model object */
	private Model model;

	/** A pointer to the view object */
	private View view;

	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//TODO #1 Initialize model and view
			model = new Model();
			view = new View(model);
			//TODO #2 Activate view
			view.activateButtons(this);
			root.setCenter(view);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	// When button is clicked, calls the setvalues function
	// to populate all the textfields
	public void handle(ActionEvent event) {
		{

			if (event.getSource() == view.getSubmitButton())
				view.setValues();
			else
				view.clearValues();
		}

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

