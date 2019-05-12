/*
 * File name: Credentials.java
 *
 * Programmer: Ann Gauger
 * ULID: amgauge
 *
 * Date: Apr 14, 2019
 *
 * Class: IT 168
 * Lecture Section: 10
 * Lecture Instructor: Terry Plickebaum 
 * Lab Section: 12
 * Lab Instructor: Kumar Rakholia
 */
package helpingAnn41619;

/**
 *<insert class description here>”
 *
 * @author Ann Gauger
 *
 */
public class Credentials
{
	private String[] Users;
	private int elementsInArray;


	 public Credentials (String[] Users, int elementsInArray)
	 {
		 this.Users = Users;
		 this.elementsInArray = elementsInArray;
	 }


	public int getElementsInArray()
	{
		return elementsInArray;
	}


	public void setElementsInArray(int elementsInArray)
	{
		this.elementsInArray = elementsInArray;
	}
	 
	public String [] getUsers()
	{
		String [] tempArray = new String [Users.length];
		for (int i = 0; i<Users.length; i++)
		{
			tempArray[i] = Users[i];
		}
		return tempArray;
	}
	
	public void setUsers(String[] User)
	{
		String [] UserBackup = new String[User.length];  
		for (int i = 0; i<User.length; i++)
		{
			UserBackup[i]=User[i];
		}
	}
}
