/*
 * File name: InvestmentOrganizerApp.java
 *
 * Programmer: Michael Reyes
 * ULID: MJREYES
 *
 * Date: Jan 8, 2017
 * 
 */
package reyesProjects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * The idea is to have a class where I enter a money amount and have it divided into different investments categories. This is the application class that 
 * will run the program. It will be responsible for user interaction. It will use a menu-like system to operate. It will also use File IO to save data.
 *
 * @author Michael Jesus Reyes
 *
 */
public class InvestmentOrganizerApp
{
	//I may need to make some methods back in the other classes. Or even in this class before the main method..
	//The programs we did in class are/were so weird, I probably shouldnt look at them for help.. I should focus on what I want. Not the references.
	/*
	 * A private method to allow option to make new "saved data" text file using File IO.
	 * A private method to allow option to load "saved data" text file using File IO Scanner.
	 * A private method to "save" data when application is quit.
	 * 
	 */

	private File data = new File("data.txt");
	
	//Should this use a regular scanner to get the information from a file?
	private void loadInvestments(InvestmentOrganizer app)
	{
		Scanner load = null;
		//Opens file
		try
		{
			load = new Scanner(data);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error loading data...");
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		//Loads information from file
		//Need to ensure it reads data correctly by matching the input with the toStrings?
		int count = 0; //Why did I make this?
		String name = "";
		double moneyAmount  = 0;
		load.nextLine();
		load.nextLine();
		while(load.hasNext())
		{
			name = load.next();
			String next = load.next();
			while(!next.equals("Investment"))
			{
				name += " " + next;
				next = load.next();
			}
			
			load.nextLine();
			load.next();
			load.next();
			load.next();
			moneyAmount = load.nextDouble();
						
			load.nextLine();
			app.addCategory(name, moneyAmount);
		}
	}
	
	//This method does the job of creating a new file. This erases the old file if it exists.
	private void SaveNewInvestments(InvestmentOrganizer app)
	{
		PrintWriter writer = null;
		//Creates new file
		try
		{
			writer = new PrintWriter(data);
		}
		catch(IOException e)
		{
			System.out.println("Error saving data...");
			System.out.println(e.getMessage());
			System.exit(2);
		}
		
		//Saves any data in list
		writer.print(app.toString());
		writer.close();
	}
	
	public void run()
	{
		//Creates the list in the app.
				InvestmentOrganizer app = new InvestmentOrganizer();
				
				Scanner input = new Scanner(System.in);
				boolean quit = false;
				int userChoice;
				String investmentName = "";
				double moneyAmount = 0.0;
				//boolean valid = false;
				
				System.out.println("Welcome.");
				System.out.println("\nWould you like to start new investments or load previous ones?\nCAUTION: Starting new investments overwrites the old ones!");
				System.out.println("1:Load old investments\n2:Start new investments");
				System.out.print("Please enter 1 or 2: ");
				userChoice = input.nextInt();
				
				//This is validation and it works for numbers. I need to learn how to validate so that it doesn't crash with letters entered.
				while(userChoice != 1 && userChoice != 2 )
				{
					System.out.print("Please enter 1 or 2: ");
					userChoice = input.nextInt();
				}
				if(userChoice == 1)
				{
					//File input
					loadInvestments(app);
				}
				else if(userChoice == 2)
				{
					//File overwriting
					SaveNewInvestments(app);
				}
				
				//Clearing input buffer before Menu choices.
				input.nextLine();
				while(quit!=true)
				{
					/* Test Investments
					app.addCategory("Test 1", 250.56);
					app.addCategory("Emils soul", 24000.00);
					app.addCategory("Dog Fun(d)", 5000);
					*/
					
					//These are all the choices/options the user can choose from. The toString prints all the investments
					System.out.println();
					System.out.print(app.toString());
					if(app.getNumberInvestments() == 0)
					{
						System.out.println("You have no investments!\n");
					}
					System.out.println("\tMenu");
					System.out.println("1: Add money to investment/s.");
					System.out.println("2: Add an investment.");
					System.out.println("3: Remove an investment.");
					System.out.println("4: ---.");
					System.out.println("5: Quit InvestmentOrganizer.");
					
					System.out.print("\nPlease choose a option: ");
					userChoice = input.nextInt();
					
					//Code to perform actions.
					if(userChoice == 1)
					{
						//If no investments exist.
						if(app.getNumberInvestments()==0)
						{
							System.out.println("You have no investments to invest in!");
							System.out.print("Would you like to make an investment?(Enter 1 for yes, 2 for no): ");
							userChoice = input.nextInt();
							input.nextLine();
							while(userChoice!= 1 && userChoice!= 2)
							{
								System.out.print("Please enter 1 or 2: ");
								userChoice = input.nextInt();
								input.nextLine();
							}
							if(userChoice==1)
							{
								System.out.print("\nPlease enter a name for the investment: ");
								investmentName = input.nextLine();
								System.out.print("\nPlease enter a money amount to start in it: ");
								moneyAmount = input.nextDouble();
								input.nextLine();
								app.addCategory(investmentName, moneyAmount);
								System.out.println();
							}
						}
						//If investments exist.
						else
						{
							
							System.out.println("Would you like to invest in one category or divide money into all of them?");
							System.out.print("Enter 1 for one category, 2 for all: ");
							userChoice = input.nextInt();
							while(userChoice!= 1 && userChoice!= 2)
							{
								System.out.print("Please enter 1 or 2: ");
								userChoice = input.nextInt();
								input.nextLine();
							}
							//One category
							if(userChoice == 1)
							{
								System.out.print("Which category would you like to invest in? Enter corresponding number: ");
								userChoice = input.nextInt();
								System.out.print("How much money do you want to invest? Enter amount: ");
								moneyAmount = input.nextDouble();
								input.nextLine();
								app.investInOne(userChoice, moneyAmount);
							}
							//All categories
							else if(userChoice == 2)
							{
								System.out.print("Enter the amount to divide into all categories: ");
								moneyAmount = input.nextDouble();
								app.investInAll(moneyAmount);
								input.nextLine();
							}
						}
					}
					else if(userChoice == 2)
					{
						input.nextLine(); //Need an input buffer here for some reason. Could this problem be fixed somewhere else?
						System.out.print("\nPlease enter a name for the investment: ");
						investmentName = input.nextLine();
						System.out.print("\nPlease enter a money amount to start in it: ");
						moneyAmount = input.nextDouble();
						input.nextLine();
						app.addCategory(investmentName, moneyAmount);
						System.out.println();
					}
					else if(userChoice == 3)
					{
						System.out.print("\nWhich investment would you like to remove? Please enter the corresponding number: "); //Get an error right here for some reason. Maybe need a getter for investment?
						int categoryNumber = input.nextInt();
						System.out.print("Are you sure you want to remove the " + app.getInvestmentName(userChoice) + "investment?(Enter 1 for yes, 2 for no): ");
						userChoice = input.nextInt();
						if(userChoice == 1)
						{
							app.deleteCategory(categoryNumber);
						}
					}
					else if(userChoice == 4)
					{
						
					}
					else if(userChoice == 5)
					{
						SaveNewInvestments(app);
						quit = true;
						System.out.println("Good-bye.");
					}
					
				}
				
			
	}

	
	public static void main(String[] args)
	{
		InvestmentOrganizerApp appRun = new InvestmentOrganizerApp();
		appRun.run();
	}

}
