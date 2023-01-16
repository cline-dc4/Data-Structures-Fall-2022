package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Homework Assignment 7
 * @author Savannah
 * Due Date: 10/03/22
 */
public class TheaterEventPane extends GridPane implements EventHandler<ActionEvent>{
	
	/**
	 * This is the textfield for the name of the Theater event
	 */
	private TextField teNameTF;
	
	/**
	 * This is the Combobox for the location of the Theater event
	 */
	private ComboBox<String> teLocationCB;
	
	/**
	 * This is the textfield for the cost of the Theater event
	 */
	private TextField teCostTF; 
	
	/**
	 * This is the Combobox for is it a Musical?
	 */
	private ComboBox<String> teIsMusicalCB;
	
	/**
	 * This is the textfield for the length of the Theater event
	 */
	private TextField teLengthTF;
	
	/**
	 * This is the submit button for the Theater event
	 */
	private Button teSubmitB;
	
	/**
	 * This is the TextArea pointer
	 */
	private TextArea teTextArea;
	
	/**
	 * This initializes the variables and adds them to the root
	 */
	public TheaterEventPane(TextArea taTEPointer)
	{
		teNameTF = new TextField();
		this.add(new Label("Name: "), 0, 0);
		add(teNameTF, 1, 0);
		
		teLocationCB = new ComboBox<String>();
		teLocationCB.getItems().addAll("Indoors", "Outdoors");
		this.add(new Label("Location: "), 0, 1);
		add(teLocationCB, 1, 1);
		
		teCostTF = new TextField();
		this.add(new Label("Cost: "), 0, 2);
		add(teCostTF, 1, 2);
		
		teIsMusicalCB = new ComboBox<String>();
		teIsMusicalCB.getItems().addAll("Yes", "No");
		this.add(new Label("Musical?: "), 0, 3);
		add(teIsMusicalCB, 1, 3);
		
		teLengthTF = new TextField();
		this.add(new Label("Length: "), 0, 4);
		add(teLengthTF, 1, 4);
		
		teSubmitB = new Button("Submit Theater Event");
		teSubmitB.setOnAction(this);
		add(teSubmitB, 0, 5);
		
		teTextArea = taTEPointer;
		
		
		
	}

	@Override
	public void handle(ActionEvent event) {
		
		if (event.getSource() == teSubmitB)
		{
			try
			{
				String theaterEventName = teNameTF.getText();
				char teLocation = 'i';
				if (teLocationCB.getSelectionModel().getSelectedItem().equals("Indoors"))
					teLocation = 'i';
				else if (teLocationCB.getSelectionModel().getSelectedItem().equals("Outdoors"))
					teLocation = 'o';
				double teCost = Double.parseDouble(teCostTF.getText());
				boolean isMusical = true;
				if (teIsMusicalCB.getSelectionModel().getSelectedItem().equals("Yes"))
					isMusical = true;
				else if(teIsMusicalCB.getSelectionModel().getSelectedItem().equals("No"))
					isMusical = false;
				int teLength = Integer.parseInt(teLengthTF.getText());
				
				TheaterEvent theaterEvent = new TheaterEvent(theaterEventName, teCost, teLocation, isMusical, teLength);
				teTextArea.appendText(theaterEvent.toString());
				
				teNameTF.setText("");
				teLocationCB.getSelectionModel().clearSelection();
				teCostTF.setText("");
				teIsMusicalCB.getSelectionModel().clearSelection();
				teLengthTF.setText("");
			}
			
			catch (Exception e)
			{
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error creating computer object");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
		}
		
	}
	
	

}
