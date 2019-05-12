/*
 * File name: InputOutput.java
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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputOutput {
	public static User[] readFile(User[] user) 
	{
		boolean found = false;
		int count = 0;
		try {
			User u;		
			File input = new File("credentials.txt");
			Scanner readFile = new Scanner(input);
			String credentials;
			String userId;
			String encryption;
			String password;
			String role;
			String creds;
			while((readFile.hasNext())&&(!found))
			{	
				creds = readFile.nextLine();
				userId = creds.substring(0, creds.indexOf("\t"));
				creds = creds.substring(creds.indexOf("\t")+1);
				encryption = creds.substring(0, creds.indexOf("\t"));
				creds = creds.substring(creds.indexOf("\t")+1);
				password = creds.substring(0, creds.indexOf("\t"));
				creds = creds.substring(creds.indexOf("\t")+1);
				role = creds;
				u = new User(userId.trim(), encryption.trim(), password.trim(), role.trim());
				user[count] = u;
				count++;
				
			}		
		}
		catch(FileNotFoundException e){
			System.out.println("File not found. ");
		}
		return user;
	}

}
