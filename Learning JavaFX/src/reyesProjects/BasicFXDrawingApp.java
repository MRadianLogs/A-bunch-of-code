/*
 * File name: BasicFXDrawingApp.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: Apr 26, 2019
 */
package reyesProjects;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * This is a basic JavaFX application showing the capabilities of drawing in a canvas in JavaFX with minimal code.
 *
 * @author Michael Jesus Reyes
 *
 */
public class BasicFXDrawingApp extends Application
{
	//Declare scenes that will be used.
	Scene mainScene;
	
	//Declare variables that will be used.
	Group root;
	Canvas canvas;
	GraphicsContext gc;
	//Circle circle;
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage mainStage)
	{
		mainStage.setTitle("Canvas Stuff"); //Sets title of window.
		
		root = new Group(); //Container the scene will use.
	    mainScene = new Scene( root ); //Setting up scene.
	    mainStage.setScene( mainScene ); //Sets up stage.
	         
	    //Setting up canvas.
	    canvas = new Canvas( 400, 200 ); //Used to draw onto scene.
	    root.getChildren().add( canvas );
	         
	    //Getting ready to paint.
	    gc = canvas.getGraphicsContext2D(); //The brush for drawing on scene.
	         
	    gc.setFill( Color.RED );
	    gc.setStroke( Color.BLACK );
	    gc.setLineWidth(2);
	    Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
	    gc.setFont( theFont );
	    //Painting.
	    gc.fillText( "Hello, World!", 60, 50 );
	    gc.strokeText( "Hello, World!", 60, 50 );
	    //gc.fillOval(x, y, w, h);
	    
	    //Importing images and drawing them.
	    //Image earth = new Image( "earth.png" );
	    //gc.drawImage( earth, 180, 100 );
	         
	    mainStage.show();
	}
}
