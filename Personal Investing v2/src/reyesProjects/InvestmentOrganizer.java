/*
 * File name: InvestmentOrganizer.java
 *
 * Programmer: Michael Reyes
 * ULID: MJREYES
 *
 * Date: Jan 8, 2017
 *
 */
package reyesProjects;

import java.util.ArrayList;

/**
 * The idea is to have a class where I enter a money amount and have it divided into different investments categories. This class handles all the different 
 * categories that money can be divided into.
 * This is version 1.
 *
 * @author Michael Jesus Reyes
 *
 */
public class InvestmentOrganizer
{
	ArrayList <Investment> Investments; 
	int numberOfInvestments = 0;
	double amountToInvest;//Is this even needed? Do I want to use it?
		
	//Do I need a constructor? You always do, right? But what is it even for?
	//Creates the list
	public InvestmentOrganizer()
	{
		Investments = new ArrayList<Investment>();
	}
	
	public int getNumberInvestments()
	{
		return numberOfInvestments;
	}
	
	public String getInvestmentName(int index)
	{
		return Investments.get(index-1).getName();
	}
	
	public void addCategory(String name, double moneyAmount)
	{
		Investment category = new Investment(name, moneyAmount);
		Investments.add(category);
		numberOfInvestments++;
	}
	
	public void deleteCategory(int categoryNumber)
	{
		Investments.remove(categoryNumber-1);
		numberOfInvestments--;
	}
	
	public void investInOne(int categoryNumber, double moneyAmount)
	{
		Investments.get(categoryNumber-1).addMoney(moneyAmount);
	}
	
	public void investInAll(double moneyAmount)
	{
		double amountInEach = moneyAmount/numberOfInvestments;
		for(int i = 0; i < numberOfInvestments; i++)
		{
			Investments.get(i).addMoney(amountInEach);
		}
		System.out.println("You invested $" + amountInEach + " in each investment.");
	}
	
	public double getAmountToInvest()
	{
		return amountToInvest;
	}
	
	public void setAmountToInvest(double newAmount)
	{
		this.amountToInvest = newAmount;
	}
	
	//A method to print out all investments and information on them. 
	//Calls the Investment class toString?
	public String toString()
	{
		String listData = "Investments:\n\n";
		for(int i = 0; i < Investments.size(); i++)
		{
			listData += Investments.get(i).toString() + "\n\n";
		}
		return listData;
	}
	
}
