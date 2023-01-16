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
public class SportsEventPane extends GridPane implements EventHandler<ActionEvent>{
	
	/**
	 * This is the Textfield for the name of the sport event
	 */
	private TextField sportsNameTF;
	
	/**
	 * This is the Combobox for the location of the sports event
	 */
	private ComboBox<String> seLocationCB;
	
	/**
	 * This is the Textfield for the cost of the sport event
	 */
	private TextField seCostTF; 
	
	/**
	 * This is the Textfield for the sport name
	 */
	private TextField seSportTF;
	
	/**
	 * This is the Textfield for the number of spectators
	 */
	private TextField seNumberOfSpectatorsTF;
	
	/**
	 * This is the submit button for the SportsEvent
	 */
	private Button seSubmitB;
	
	/**
	 * This is a TextArea pointer
	 */
	private TextArea seTextArea;
	
	/**
	 * This initializes the variables and adds them to the root
	 */
	public SportsEventPane(TextArea taSEPointer)
	{
		sportsNameTF = new TextField();
		this.add(new Label("Name: "), 0, 0);
		add(sportsNameTF, 1, 0);
		
		seLocationCB = new ComboBox<String>();
		seLocationCB.getItems().addAll("Indoors", "Outdoors");
		this.add(new Label("Location: "), 0, 1);
		add(seLocationCB, 1,1);
		
		seCostTF = new TextField();
		this.add(new Label("Cost: "), 0, 2);
		add(seCostTF, 1, 2);
		
		seSportTF = new TextField();
		this.add(new Label("Sport: "), 0, 3);
		add(seSportTF, 1, 3);
		
		seNumberOfSpectatorsTF = new TextField();
		this.add(new Label("Number of Spectators: "), 0, 4);
		add(seNumberOfSpectatorsTF, 1, 4);
		
		seSubmitB = new Button("Submit Sports Event");
		seSubmitB.setOnAction(this);
		add(seSubmitB, 0, 5);
		
		seTextArea = taSEPointer;
		
		
		
	}

	@Override
	public void handle(ActionEvent event) {
		
		if (event.getSource() == seSubmitB)
		{
			try
			{
				String sportsEventName = sportsNameTF.getText();
				char seLocation = 'i';
				if (seLocationCB.getSelectionModel().getSelectedItem().equals("Indoors"))
					seLocation = 'i';
				else if (seLocationCB.getSelectionModel().getSelectedItem().equals("Outdoors"))
					seLocation = 'o';
				double seCost = Double.parseDouble(seCostTF.getText());
				String sportName = seSportTF.getText();
				int seNumberOfSpectators = Integer.parseInt(seNumberOfSpectatorsTF.getText());
				
				SportsEvent sportEvent = new SportsEvent(sportsEventName, seCost, seLocation, sportName, seNumberOfSpectators);		
				seTextArea.appendText(sportEvent.toString());
				
				sportsNameTF.setText("");
				seLocationCB.getSelectionModel().clearSelection();
				seCostTF.setText("");
				seSportTF.setText("");
				seNumberOfSpectatorsTF.setText("");
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
