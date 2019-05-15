/*
 * File name: BasicFXGameApp.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: Apr 27, 2019
 */
package reyesProjects;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * This class takes the concepts of UI and drawing and combines then into a single "game-like" class. Using these 
 * two concepts allows us to make games in javaFX.
 *
 * @author Michael Jesus Reyes
 *
 */
public class BasicFXGameApp extends Application
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
		    canvas = new Canvas( 600, 600 ); //Used to draw onto scene.
		    root.getChildren().add( canvas );
		         
		    //Getting ready to paint.
		    gc = canvas.getGraphicsContext2D(); //The brush for drawing on scene.
		    
		    Image earth = new Image( "file:AnnsDog32bit.png");
		   //BackgroundImage background = new BackgroundImage(earth, null, null, null, null);
		    Image sun   = new Image( "file:pigoooooo copy.png" );
		    
		    final long startNanoTime = System.nanoTime();
		    
		    //The update() method essentially.
		    new AnimationTimer()
		    {
		        public void handle(long currentNanoTime)
		        {
		        	//Clear the canvas.
		        	gc.clearRect(0, 0, 512, 512);
		        	
		        	double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
		        	 
		            double x = 232 + 128 * Math.cos(t);
		            double y = 232 + 128 * Math.sin(t);
		 
		            // background image clears canvas
		            gc.drawImage( earth, x, y );
		            gc.drawImage( sun, 196, 196 );
		        }
		    }.start();
		         
		    mainStage.show();
		}
}
