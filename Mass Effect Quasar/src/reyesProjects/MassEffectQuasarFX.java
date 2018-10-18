/*
 * File name: MassEffectQuasarFX.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: Mar 13, 2018
 */
package reyesProjects;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * This is my Mass Effect Quasar game. It is my recreation of a popular slots game in the game Mass Effect. The goal of 
 * the game is to get as close to 20 as possible, without going over. This program implements a new form of graphics interface 
 * called JavaFX. The features of JavaFX implemented in this program include displaying text and buttons into neat arrangements 
 * on the screen, having clickable buttons that affect the program, and successfully implementing the rules of the game into 
 * code. Have fun!
 *
 * @author Michael Jesus Reyes
 *
 */
public class MassEffectQuasarFX extends Application
{
	private int creditWallet;
	private int score;	
	boolean roundActive;
	
	Scene menuScene;
	Scene gameScene;
	Label creditWalletDisplay;
	Label quasarExplanation;
	Label lowStakesExplanation;
	Label highStakesExplanation;
	Button chooseLowStakesButton;
	Button chooseHighStakesButton;
	boolean playingHighStakes;
	boolean playingLowStakes;
	Label scoreDisplay;
	Label payoutDisplay;
	Button chooseAddOneToEight;
	Button chooseAddFourToSeven;
	Button choosePayout;
	Label winLoseDisplay;
	Button choosePlayAgain;
	Button chooseQuit;
	
	public void startHighStakes()
	{
		creditWallet += -200;
		score = 0;
		scoreDisplay.setText("" + score);
		payoutDisplay.setText("Payout: " + calcHighStakesPayout(score));
		chooseAddOneToEight.setDisable(false);
		chooseAddFourToSeven.setDisable(false);
		choosePayout.setDisable(false);
		winLoseDisplay.setVisible(false);
		choosePlayAgain.setVisible(false);
		chooseQuit.setVisible(false);
		choosePayout.setVisible(false);
	}
	
	public void startLowStakes()
	{
		creditWallet += -20;
		score = 0;
		scoreDisplay.setText("" + score);
		payoutDisplay.setText("Payout: " + calcLowStakesPayout(score));
		chooseAddOneToEight.setDisable(false);
		chooseAddFourToSeven.setDisable(false);
		choosePayout.setDisable(false);
		winLoseDisplay.setVisible(false);
		choosePlayAgain.setVisible(false);
		chooseQuit.setVisible(false);
		choosePayout.setVisible(false);
	}
	
	public void payout()
	{
		if(playingLowStakes == true)
		{
			creditWallet += calcLowStakesPayout(score);
		}
		else
		{
			creditWallet += calcHighStakesPayout(score);
		}
	}
	
	public void addFourToSeven()
	{
		int random = (int) (Math.random() * 3 + 5);
		score+= random;
	}
	
	public void addOneToEight()
	{
		int random = (int) (Math.random() * 8 + 1);
		score += random;
	}
	
	public boolean payoutAboveZero(int score)
	{
		if(calcPayout(score)>0)
		{
			return true;
		}
		else return false;
	}
	
	public int calcPayout(int score)
	{
		if(playingLowStakes == true)
		{
			return calcLowStakesPayout(score);
		}
		else
		{
			return calcHighStakesPayout(score);
		}
	}
	
	public int calcLowStakesPayout(int score)
	{
		if(score == 15)
		{
			return 5;
		}
		else if(score == 16)
		{
			return 10;
		}
		else if(score == 17) {
			return 20;
		}
		else if(score == 18)
		{
			return 25;
		}
		else if(score == 19)
		{
			return 30;
		}
		else if(score == 20)
		{
			return 40;
		}
		else
		{
			return 0;
		}
	}
	
	public int calcHighStakesPayout(int score)
	{
		if(score == 15)
		{
			return 50;
		}
		else if(score == 16)
		{
			return 100;
		}
		else if(score == 17) {
			return 200;
		}
		else if(score == 18)
		{
			return 250;
		}
		else if(score == 19)
		{
			return 300;
		}
		else if(score == 20)
		{
			return 400;
		}
		else
		{
			return 0;
		}
	}
	
	public void displayPayoutButton()
	{
		if(payoutAboveZero(score) == false)
		{
			choosePayout.setVisible(false);
		}
		else
		{
			choosePayout.setVisible(true);
		}
	}
	
	public void checkWinLoseConditions()
	{
		if(score > 20)
		{
			chooseAddOneToEight.setDisable(true);
			chooseAddFourToSeven.setDisable(true);
			choosePayout.setDisable(true);
			winLoseDisplay.setText("You lose...");
			winLoseDisplay.setVisible(true);
			choosePlayAgain.setVisible(true);
			chooseQuit.setVisible(true);
		}
		else if(score == 20)
		{
			payout();
			chooseAddOneToEight.setDisable(true);
			chooseAddFourToSeven.setDisable(true);
			choosePayout.setDisable(true);
			winLoseDisplay.setText("You win!");
			winLoseDisplay.setVisible(true);
			choosePlayAgain.setVisible(true);
			chooseQuit.setVisible(true);
		}
	}

	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage)
	{		
		quasarExplanation = new Label("\t\t\tQuasar\nGet closest to 20 without going over.");
		lowStakesExplanation = new Label("Low Stakes Quasar\n20 credits to play\nPayouts\n14 or less: 0 credits\n15: 5 credits\n16: 10 credits\n17: 20 credits\n18: 25 credits\n19: 30 credits\n20: 40 credits\n21 or more: 0 credits");
		highStakesExplanation = new Label("High Stakes Quasar\n200 credits to play\nPayouts\n14 or less: 0 credits\n15: 50 credits\n16: 100 credits\n17: 200 credits\n18: 250 credits\n19: 300 credits\n20: 400 credits\n21 or more: 0 credits");
		creditWalletDisplay = new Label("Credits Wallet = " + creditWallet);
		chooseLowStakesButton = new Button("Low Stakes Quasar");
		chooseHighStakesButton = new Button("High Stakes Quasar");
		playingHighStakes = false;
		playingLowStakes = false;
		
		chooseLowStakesButton.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				startLowStakes();
				playingLowStakes = true;
				primaryStage.setScene(gameScene);
			}
		});
		
		chooseHighStakesButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				startHighStakes();
				playingHighStakes = true;
				primaryStage.setScene(gameScene);
			}
		});
		
		//Need 2 scenes. 1 for menu, 1 for round.
		
		scoreDisplay = new Label("" + score);
		payoutDisplay = new Label("Payout: " + calcPayout(score));
		chooseAddOneToEight = new Button("Add 1-8");
		chooseAddFourToSeven = new Button("Add 4-7");
		choosePayout = new Button("Pay Out");
		winLoseDisplay = new Label("You won/Lose");
		choosePlayAgain = new Button("Play Again?");
		chooseQuit = new Button("Quit");
		
		chooseAddOneToEight.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				addOneToEight();
				scoreDisplay.setText("" + score);
				payoutDisplay.setText("Payout: " + calcPayout(score));
				displayPayoutButton();
				checkWinLoseConditions();
			}
		});
		
		chooseAddFourToSeven.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				addFourToSeven();
				scoreDisplay.setText("" + score);
				payoutDisplay.setText("Payout: " + calcPayout(score));
				displayPayoutButton();
				checkWinLoseConditions();
			}
		});
		
		choosePayout.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				payout();
				chooseAddOneToEight.setDisable(true);
				chooseAddFourToSeven.setDisable(true);
				choosePayout.setDisable(true);
				winLoseDisplay.setText("You win!");
				winLoseDisplay.setVisible(true);
				choosePlayAgain.setVisible(true);
				chooseQuit.setVisible(true);				
			}
		});
		
		chooseQuit.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				creditWalletDisplay.setText("Credits Wallet = " + creditWallet);
				primaryStage.setScene(menuScene);
				playingLowStakes = false;
				playingHighStakes = false;
			}
		});
		
		choosePlayAgain.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				if(playingLowStakes == true)
				{
					startLowStakes();
				}
				else
				{
					startHighStakes();
				}
			}
		});
		
		Label test = new Label("Quasar\nGet closest to 20 without going over.");
		GridPane menuGrid = new GridPane();
		menuGrid.setAlignment(Pos.CENTER);
		menuGrid.setPadding(new Insets(20));
		menuGrid.setHgap(10);
		menuGrid.setVgap(20);
		menuGrid.add(quasarExplanation, 1, 0, 3, 1);
		GridPane.setHalignment(quasarExplanation, HPos.CENTER);
		menuGrid.add(lowStakesExplanation, 0, 2, 1, 1);
		menuGrid.add(highStakesExplanation, 4, 2, 1, 1);
		menuGrid.add(creditWalletDisplay, 4, 5, 1, 1);
		menuGrid.add(chooseLowStakesButton, 1, 4, 1, 1);
		//GridPane.setHalignment(chooseLowStakesButton, HPos.LEFT);
		menuGrid.add(chooseHighStakesButton, 2, 4, 1, 1);
		//GridPane.setHalignment(chooseHighStakesButton, HPos.CENTER);
		
		
		GridPane gameGrid = new GridPane();
		gameGrid.setAlignment(Pos.CENTER);
		gameGrid.setPadding(new Insets(20));
		gameGrid.setHgap(10);
		gameGrid.setVgap(20);
		gameGrid.add(scoreDisplay, 1, 0, 3, 3);
		GridPane.setHalignment(scoreDisplay, HPos.CENTER);
		gameGrid.add(payoutDisplay, 1, 5, 3, 1);
		GridPane.setHalignment(payoutDisplay, HPos.CENTER);
		gameGrid.add(chooseAddOneToEight, 0, 4, 1, 1);
		gameGrid.add(chooseAddFourToSeven, 4, 4, 1, 1);
		gameGrid.add(choosePayout, 1, 4, 3, 1);
		GridPane.setHalignment(choosePayout, HPos.CENTER);
		gameGrid.add(winLoseDisplay, 1, 6, 3, 1);
		GridPane.setHalignment(winLoseDisplay, HPos.CENTER);
		gameGrid.add(choosePlayAgain, 1, 7, 1, 1);
		gameGrid.add(chooseQuit, 3, 7, 1, 1);
		
		//VBox vbox = new VBox(quasarExplanation, lowStakesExplanation, highStakesExplanation, creditWalletDisplay, chooseLowStakesButton, chooseHighStakesButton);
		//VBox vbox2 = new VBox(scoreDisplay, payoutDisplay, chooseAddOneToEight, chooseAddFourToSeven, choosePayout, winLoseDisplay, choosePlayAgain, chooseQuit);
		
		menuScene = new Scene(menuGrid, 655, 500);
		gameScene = new Scene(gameGrid, 655, 500);
		
		primaryStage.setScene(menuScene);
		primaryStage.setTitle("Quasar");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
