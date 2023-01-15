package application;


import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class View extends GridPane
{
	/** A pointer to the model */
	private Model model;

	/** The submit button */
	private Button submitButton;

	/** The clear button */
	private Button clearButton;

	/** The number of credits text field */
	TextField independentTF;

	/** The year in school text field */
	TextField dependentTF;

	/** The constructor with a model object 
	 * @param inputModel Model object
	 */
	public View(Model inputModel)
	{

		// Initialize model
		model = inputModel;
		independentTF = new TextField();
		dependentTF = new TextField();
		submitButton = new Button("Submit");
		clearButton = new Button("Clear");
		GridPane mainPanel = new GridPane();

		// Adding components to panels
		GridPane numberOfCreditsP = new GridPane();
		numberOfCreditsP.add(independentTF, 0, 0);
		GridPane yearInSchoolP = new GridPane();
		yearInSchoolP.add(dependentTF, 0, 0);
		GridPane submitButtonP = new GridPane();
		submitButtonP.add(submitButton, 0, 0);
		GridPane clearButtonP = new GridPane();
		clearButtonP.add(clearButton, 1, 0);
		// Adding panels to main panel

		mainPanel.add( new Label("Independent"), 0, 0);
		mainPanel.add(numberOfCreditsP, 1, 0);
		mainPanel.add( new Label("Dependent"), 0, 1);
		mainPanel.add(yearInSchoolP, 1, 1);
		mainPanel.add(submitButtonP, 0, 2);
		mainPanel.add(clearButtonP, 1, 2);

		add(mainPanel, 0, 0);


	} 

	/**
	 * Return pointer to the submit button
	 * @return A pointer to the submit button
	 */
	public Button getSubmitButton()
	{
		return submitButton;
	}

	/**
	 * Return pointer to the clear button
	 * @return A pointer to the clear button
	 */
	public Button getClearButton()
	{
		return clearButton;
	}


	//TODO Set the independent IV
	// Automatically set the dependent IV textfield
	public void setValues()
	{
		model.setIndependent(Integer.parseInt(independentTF.getText()));
		dependentTF.setText(model.getDependent());
	}

	//TODO Resets the various textfields
	// back to empty spots
	public void clearValues()
	{
		independentTF.clear();
		dependentTF.clear();
	}

	/** 
	 * Adding action listeners to buttons
	 * @param parent The class that contains the action performed
	 */
	// Adds action listeners to the buttons
	public void activateButtons(EventHandler parent)
	{
		submitButton.setOnAction(parent);
		clearButton.setOnAction(parent);
	}


}
