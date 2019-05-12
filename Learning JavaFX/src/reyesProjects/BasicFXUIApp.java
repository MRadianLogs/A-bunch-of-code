/*
 * File name: BasicFXUIApp.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: Apr 26, 2019
 */
package reyesProjects;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * This is a basic JavaFX application showing the capabilities of UI in JavaFX with minimal code.
 *
 * @author Michael Jesus Reyes
 *
 */
public class BasicFXUIApp extends Application
{
	//Declare scenes that will be used.
	Scene mainScene;
	Scene newScene;
	
	//Declare variables that will be used.
	Label exampleLabel;
	Button exampleButton;
	Image testImage;
	
	public void start(Stage mainStage)
	{		
		//Set up variables of UI.
		exampleLabel = new Label("Test label!");
		exampleButton = new Button("Name of button");
		
		exampleButton.setOnAction(new EventHandler<ActionEvent>() //Setting up what happens when a button is clicked.
		{
			public void handle(ActionEvent event)
			{
				//Do stuff!
				mainStage.setScene(newScene); //Set a new scene?
			}
		});
		
		//Make container/grid to place variables in.
		GridPane menuGrid = new GridPane();
		//GridPane testGrid = new GridPane(); //You can add other grids to grids.
		menuGrid.setAlignment(Pos.CENTER);
		menuGrid.setPadding(new Insets(20));
		menuGrid.setHgap(10);
		menuGrid.setVgap(20);
		menuGrid.add(exampleLabel, 1, 0, 3, 1);
		menuGrid.add(exampleButton, 0, 0);
		
		Group testGroup = new Group();
		
		//Set up scene.
		mainScene = new Scene(menuGrid, 655, 500);
		newScene = new Scene(testGroup, 500,500);
		
		//Setting up stage.
		mainStage.setScene(mainScene);
		mainStage.setTitle("Title of Window");
		mainStage.setResizable(false);
		//mainStage.setHeight(value);
		mainStage.show(); //Brings up window.
	}
	
	public static void main(String[] args)
	{
		launch(args); //Launches the application; Calls start();
	}
}
