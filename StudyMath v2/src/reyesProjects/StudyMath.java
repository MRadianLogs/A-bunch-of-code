/*
 * File name: StudyMath.java
 *
 * Programmer: Michael Reyes
 * 
 * Date: Jan 31, 2017
 *
 */
package reyesProjects;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <Insert C;ass Description Here>
 *
 * @author Michael Jesus Reyes
 *
 */
public class StudyMath
{
	private int numberCorrect;
	private int numberIncorrect;
	
	//I should add a time variable. I don't know how to do this yet.
	
	public void practiceAllMultiplications(int howMany, int maxNumber, Scanner inputScanner)
	{
		numberCorrect = 0;
		numberIncorrect = 0;
		int firstNumber;
		int secondNumber;
		int answer;
		int input;
		for(int i = 0; i < howMany; i++)
		{
			firstNumber = (int) (Math.random()*(maxNumber+1));
			secondNumber = (int) (Math.random()*(maxNumber+1));
			answer = firstNumber * secondNumber;
			System.out.println("Problem: " + (i+1));
			System.out.println(" " + firstNumber + " * " + secondNumber + " = ___?");
			try
			{
				input = inputScanner.nextInt();
			}
			//Need to fix this. Should I just do a while loop for verification?
			catch(InputMismatchException e)
			{
				System.out.print("Please enter in a NUMBER: ");
				input = inputScanner.nextInt();
			}
			
			if(input == answer)
			{
				numberCorrect++;
			}
			else
			{
				numberIncorrect++;
			}
		}
		System.out.println("FINISHED!");
		System.out.println("You entered " + numberCorrect + " problems CORRECT. (" + numberCorrect + "/" + howMany + ")");
		System.out.println("You entered " + numberIncorrect + " problems INCORRECT. (" + numberIncorrect + "/" + howMany + ")");
	}
	
	public void practiceSpecificMultiplications(int whichNumber, int howMany, int maxNumber, Scanner inputScanner)
	{
		numberCorrect = 0;
		numberIncorrect = 0;
		int firstNumber = whichNumber;
		int secondNumber;
		int answer;
		for(int i = 0; i < howMany; i ++)
		{
			secondNumber = (int) (Math.random()*(maxNumber+1));
			answer = firstNumber * secondNumber;
			System.out.println("Problem: " + (i+1));
			System.out.println(" " + firstNumber + " * " + secondNumber + " = ___?");
			if(inputScanner.nextInt() == answer)
			{
				numberCorrect++;
			}
			else
			{
				numberIncorrect++;
			}
		}
		System.out.println("FINISHED!");
		System.out.println("You entered " + numberCorrect + " problems CORRECT. (" + numberCorrect + "/" + howMany + ")");
		System.out.println("You entered " + numberIncorrect + " problems INCORRECT. (" + numberIncorrect + "/" + howMany + ")");
	}
}
