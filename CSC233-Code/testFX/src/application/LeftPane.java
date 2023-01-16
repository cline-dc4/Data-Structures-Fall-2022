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

public class LeftPane extends GridPane implements EventHandler<ActionEvent>
{
	private TextField idTF;
	private TextField updateTF;
	private TextField locationTF;
	private ComboBox<String> laptopCB;
	private Button submitB;
	private TextArea centerTA;


	public LeftPane(TextArea centerTA)
	{
		this.centerTA = centerTA;
		
		idTF = new TextField();
		this.add(new Label("Computer ID: "), 0, 0);
		add(idTF, 1, 0);

		updateTF = new TextField();
		this.add(new Label("Update Year: "), 0, 1);
		add(updateTF, 1, 1);

		laptopCB = new ComboBox<String>();
		laptopCB.getItems().addAll("Yes", "No");
		laptopCB.getSelectionModel().select("Yes");
		this.add(new Label("Laptop? "), 0, 2);
		add(laptopCB, 1, 2);

		locationTF = new TextField();
		this.add(new Label("Location: "), 0, 3);
		add(locationTF, 1, 3);

		submitB = new Button("Submit");
		submitB.setOnAction(this);
		add(submitB, 0, 4);
		
	}


	@Override
	public void handle(ActionEvent event)
	{
		if(event.getSource() == submitB)
		{
			try
			{
				String id = idTF.getText();
				int updateYear = Integer.parseInt(updateTF.getText());
				//string to float: double x = Double.parseDouble("2.34")
				String location = locationTF.getText();
				boolean isLaptop = true;
				if(laptopCB.getSelectionModel().getSelectedItem().equals("Yes"))
					isLaptop = true;
				else if(laptopCB.getSelectionModel().getSelectedItem().equals("No"))
					isLaptop = false;

				Computer c = new LabComputer(id, isLaptop, updateYear, location);
				centerTA.appendText(c.toString());
				
				System.out.println(c);
				idTF.setText("");
				laptopCB.getSelectionModel().select("Yes");
				locationTF.setText("");
				updateTF.setText("");
			}
			catch(Exception e)
			{
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error creating Computer object");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
			/*
			System.out.println("Submit button pressed");
			idTF.setText("Button pressed");

			//grab text from update year and display it in console
			String updateYearString = updateTF.getText();
			System.out.println("String: " + updateYearString);

			try
			{
				int updateYear = Integer.parseInt(updateYearString);
				System.out.println("Update year: " + updateYear);
			}
			catch(Exception e)
			{
				System.out.println("Error: " + e.getMessage());
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}

			//Interacting with the combobox
			String laptopOption = laptopCB.getSelectionModel().getSelectedItem();
			System.out.println("Laptop option: " + laptopOption);
			 */

		}
	}

}
