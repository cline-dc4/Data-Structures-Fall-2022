package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ButtonGrid extends GridPane implements EventHandler<ActionEvent>
{
	private Button [][] buttonArray;

	public ButtonGrid()
	{
		buttonArray = new Button [2][2];
		for (int i = 0; i < 2; i++)
		{
			for (int j = 0; j < 2; j++)
			{
				buttonArray[i][j] = new Button(i + " " + j);
				buttonArray[i][j].setOnAction(this);
				//using image for button background
				//if (i == 0 && j == 0)
				{
					try 
					{
						Image bgImage = new Image(new FileInputStream("background3.jpg"));
						ImageView iv = new ImageView(bgImage);
						buttonArray[i][j].setGraphic(iv);
						
						//can do all in one line...
						//buttonArray[i][j].setGraphic(new ImageView(new Image(new FileInputStream("background3.jpg"))));
					}
					catch (FileNotFoundException e) 
					{
						e.printStackTrace();
					}
				}
				//gridPane does columns then rows
				this.add(buttonArray[i][j], j, i);
			}
		}

	}

	public void handle(ActionEvent event) 
	{
		for (int i = 0; i < 2; i++)
		{
			for (int j = 0; j < 2; j++)
			{
				if (event.getSource() == buttonArray[i][j])
				{
					System.out.println(i + ", " + j);
				}
			}
		}
	}


}
