/*
 * File name: AuthentificationDriver.java
 *
 * Programmer: Ann Gauger
 * ULID: amgauge
 *
 * Date: Apr 15, 2019
 *
 * Class: IT 168
 * Lecture Section: 10
 * Lecture Instructor: Terry Plickebaum 
 * Lab Section: 12
 * Lab Instructor: Kumar Rakholia
 */
package helpingAnn41619;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *<insert class description here>”
 *
 * @author Ann Gauger
 *
 */
public class AuthentificationDriver
{
	
	public static String[] createMessageArrays(String role)
	{
		String[] messages = new String[5];
		
		switch (role)
		{
		case "zookeeper" :
			messages[0] = "Hello, Zookeeper!\r\n";
			messages[1] = "\r\nAs zookeeper, you have access to all of the animals' information and their daily monitoring logs.";
			messages[2] = "This allows you to track their feeding habits, habitat conditions, and general welfare.\r\n";
			break;
		case "veterinarian":
			messages[0] = "Hello, Veterinarian!\r\n" ;
			messages[1] = "\r\nAs veterinarian, you have access to all of the animals' health records.";
			messages[2]="This allows you to view each animal's medical history and current treatments/illnesses (if any)," +
					"and to maintain a vaccination log.\r\n";
			break;
		case "admin":
			messages[0] = "Hello, System Admin!\r\n"; 
			messages[1] = "\r\nAs administrator, you have access to the zoo's main computer system.";
			messages[2] = "This allows you to monitor users in the system and their roles.\r\n"; 
			break;
			
		}
		return messages;
	}
	
	public static void DisplayMenu()
	{
		System.out.println("Blomo's Zoo Data Access System\r\n" + 
				"Please select an option\r\n" + 
				"1)Log into System\r\n" + 
				"2)Exit System\r\n");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		MD5Digest myEncryption = new MD5Digest();
		User[] users = new User[50];
		InputOutput.readFile(users);
		Scanner scan = new Scanner(System.in);
		int input = 0;
		boolean isValidPassword;
		
		while (input != 2)
		{
			AuthentificationDriver.DisplayMenu();
			input = scan.nextInt();
			if ((input!=1)&&(input!=2))
			{
				System.out.println("Invalid input, please try again");
			}
			else if(input == 1)
			{
				isValidPassword = false;
				int numAttempts = 0;//the number of times system asks for password
				while (isValidPassword == false && numAttempts < 3) //Anns issue was here. She had a ; after the while loop which caused an infinite loop.
				{
					scan.nextLine();
					System.out.println("Please enter a username.");
					String username = scan.nextLine();
					System.out.println("Please enter your password.");
					String password = scan.nextLine();
					String encPassword = null;
					
					try
					{
						encPassword = myEncryption.encrypt(password);
					}
					catch (NoSuchAlgorithmException e)
					{
						e.printStackTrace();
					}
					
					for (int i = 0; i<users.length && users[i] != null && isValidPassword == false; i++)
					{
						if(username.equals(users[i].getUserName()))
						{
							if(encPassword.equals(users[i].getEncryption()))
							{
								isValidPassword = true;
							}
						}	
					}
					
					numAttempts++;
				}
				
				if (isValidPassword == true)
				{
					for (int i = 0; i<users.length; i++)
					{
						if (users[i].getRole().equals("zookeeper"))
						{
							System.out.println(AuthentificationDriver.createMessageArrays("zookeeper"));
						}
						else if (users[i].getRole().equals("admin"))
						{
							System.out.println(AuthentificationDriver.createMessageArrays("admin"));
						}
						else
						{
							System.out.println(AuthentificationDriver.createMessageArrays("veterinarian"));
						}
					}
				}
				else
				{
					System.out.println("Incorrect username or password, no tries remaining.");
				}				
				System.out.println("Logging out... Goodbye!");
			}	
		}	
		scan.close();
	}
}
