/*
 * File name: Card.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: Aug 2, 2018
 */
package reyesProjects;

/**
 * <Insert C;ass Description Here>
 *
 * @author Michael Jesus Reyes
 *
 */
public class Card
{	
	//Typical Card stuff
	private String suite;
	private int cardNumber;
	
	//Atypical Matt's Game stuff
	private int initialHealth; //Health the card starts with, aka its number.
	private int currentHealth; //Some of the positions can give cards extra health, and cards can lose health, so this keeps track of the current health of a card.
	private String cardPosition; //This is the special position/formation a card is in. It is determined by a roll of dice. MORE INFO LATER.
	
	public Card(String cardSuite, int cardNumber, int initialHealth)
	{
		this.suite = cardSuite;
		this.cardNumber = cardNumber;
		this.initialHealth = initialHealth;
		this.currentHealth = initialHealth;
		this.cardPosition = "None";
	}
	
	//Card methods for creating the cards or accessing the data.
	public String getSuite()
	{
		return suite;
	}
	
	public int getCardNumber()
	{
		return cardNumber;
	}
	
	public int getInitialHealth()
	{
		return initialHealth;
	}
	public void setInitialHealth(int newHealth)
	{
		this.initialHealth = newHealth;
	}
	
	public int getCurrentHealth()
	{
		return currentHealth;
	}
	public void setCurrentHealth(int newHealth)
	{
		this.currentHealth = newHealth;
	}
	
	public String getCardPosition()
	{
		return cardPosition;
	}
	public void setCardPosition(String newPosition)
	{
		this.cardPosition = newPosition;
	}

}
