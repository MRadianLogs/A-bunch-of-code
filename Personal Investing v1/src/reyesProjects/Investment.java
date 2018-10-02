/*
 * File name: Investment.java
 *
 * Programmer: Michael Reyes
 * ULID: MJREYES
 *
 * Date: Jan 8, 2017
 * 
 */
package reyesProjects;

/**
 * The idea is to have a class where I enter a money amount and have it divided into different investments categories. This is the class which will represent 
 * one of those categories. 
 * This is version 1.
 * 
 * @author Michael Jesus Reyes
 *
 */
public class Investment
{
	private String name;
	private double moneySaved;
	
	public Investment(String name, double moneyAmount)
	{
		this.name = name;
		this.moneySaved = moneyAmount;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getMoneySaved()
	{
		return moneySaved;
	}
	
	public void setName(String newName)
	{
		this.name = newName;
	}
	
	public void setMoneySaved(double newMoneyAmount)
	{
		this.moneySaved = newMoneyAmount;
	}
	
	public void addMoney(double moneyAmount)
	{
		this.moneySaved = moneySaved + moneyAmount;
	}
	
	//A toString to print the data in the investment.
	public String toString()
	{
		String data = "";
		data = getName() + " Investment\nAmount Saved: $ " + getMoneySaved();
		return data;
	}
}
