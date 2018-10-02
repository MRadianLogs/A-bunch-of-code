/*
 * File name: Store.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: Oct 28, 2017
 */
package edu.ilstu;

import java.util.Scanner;

/**
 * <Insert C;ass Description Here>
 *
 * @author Michael Jesus Reyes
 *
 */
public class Store
{
	private String location;
	
	public Store()
	{
		
	}
	
	public void selectLocation(Scanner input)
	{
		int locationChoice;
		System.out.println("Pick a location that is close to you by typing 1, 2 or 3:" + "\n\t1-207 W North St., Normal IL" + "\n\t2-305 S Main St., Normal IL" + "\n\t3-208 Landmark Blvd., Bloomington IL");
		locationChoice = input.nextInt();
		if(locationChoice == 1)
		{
			
		}
		else if(locationChoice == 2)
		{
			
		}
		else if(locationChoice == 3)
		{
			
		}
		else
		{
			
		}
	}
	
}
