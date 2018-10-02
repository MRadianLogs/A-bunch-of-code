import java.util.Scanner;

/*
 * File name: Vending.java
 *
 * Programmer: Michael Reyes
 * ULID: MJREYES
 *
 * Date: Aug 31, 2016
 *
 * Class: IT 168
 * Lecture Section: 10
 * Lecture Instructor: Ms. Patricia Matsuda
 * Lab Section: 12
 * Lab Instructor: Sumit Tokkar
 */

/**
 * This class is a test class to practice my programming.
 *
 * @author Michael Jesus Reyes
 *
 */
public class Vending
{
	public static void main(String[] args)
	{
		System.out.println("Enter the price of the item.");
		Scanner scanner = new Scanner(System.in);
		double price = scanner.nextDouble();
		System.out.println("You entered $" + price +".");
		
		
		double change = 1 - price;
		change = (int)(change * 100);
		change = change/100;
		System.out.println("Your change is $" + change);
		
		int quarters = (int)(change/.25);
		System.out.println("You are receiving " + quarters + " quarters.");
		if(quarters > 0)
		{
		change = change % .25;
		}
		
		int dimes = (int)(change/.10);
		System.out.println("You are receiving " + dimes + " dimes.");
		if(dimes > 0)
		{
		change = change % .10;
		}
		//Nickels dont count right?
		int nickels = (int)(change/.05);
		System.out.println("You are receiving " + nickels + " nickels.");
		
		System.out.println("Have a nice day!");
		
	
		

	}

}
