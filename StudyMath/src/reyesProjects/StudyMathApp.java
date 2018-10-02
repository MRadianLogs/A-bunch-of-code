/*
 * File name: StudyMathApp.java
 *
 * Programmer: Michael Reyes
 * 
 * Date: Jan 31, 2017
 *
 */
package reyesProjects;

import java.util.Scanner;

/**
 * <Insert C;ass Description Here>
 *
 * @author Michael Jesus Reyes
 *
 */
public class StudyMathApp
{
	public static void main(String[] args)
	{
		StudyMath app = new StudyMath();
		
		Scanner input = new Scanner(System.in);
		boolean quit = false;
		int userChoice;
		
		System.out.println("Welcome.");
		
		while(quit!= true)
		{
			System.out.println("\n\tMath Topics");
			System.out.println("1: Multiplication Tables");
			System.out.println("2: Fractions(Coming soon)");
			System.out.println("3: Algebra(Coming soon)");
			System.out.println("4: Graphs(Coming soon)");
			System.out.println("5: Quit");
			
			System.out.print("\nPlease choose a Math topic to practice: ");
			userChoice = input.nextInt();
			
			if(userChoice == 1)
			{
				System.out.println("Do you want to practice a specific multiplication table? Or a mix of numbers?");
				System.out.println("1: A mix of numbers");
				System.out.println("2: A specific multiplication table");
				System.out.print("Choose 1 or 2: ");
				userChoice = input.nextInt();
				
				if(userChoice == 1)
				{
					int howMany;
					int maxNumber;
					
					System.out.println("\nYou chose to practice a mix of multiplications!");
					System.out.print("How many would you like to practice: ");
					howMany = input.nextInt();
					System.out.print("What is the max number you wish to practice(EX: 12): ");
					maxNumber = input.nextInt();
					System.out.println("\nLets get started!");
					app.practiceAllMultiplications(howMany, maxNumber, input);
					
				}
				else if(userChoice == 2)
				{
					int howMany;
					int maxNumber;
					int whichNumber;
					
					System.out.println("\nYou chose to practice a specific multiplication table!");
					System.out.print("Which number would you like to practice: ");
					whichNumber = input.nextInt();
					System.out.print("How many would you like to practice: ");
					howMany = input.nextInt();
					System.out.print("What is the max number you wish to practice(EX: 12): ");
					maxNumber = input.nextInt();
					System.out.println("\nLets get started!");
					app.practiceSpecificMultiplications(whichNumber, howMany, maxNumber, input);
				}
			}
			else if(userChoice == 5)
			{
				System.out.println("Goodbye!");
				quit = true;
			}
		}
		input.close();
	}

}
