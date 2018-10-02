import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * File name:  IOPRactice3.java 
 * 
 * Programmer:  Patricia Matsuda
 *  ULID: mpmatsu
 *
 *  Date:  Nov 3, 2016
 *
 *  Class: IT 168
 *  Lecture Section:   10, 13
 *  Lecture Instructor:   Ms. Patricia Matsuda  
 *  Lab Section:  11, 12, 14, 15
 *  Lab Instructor:  Bansal, Tokkar
 */

/**

 * @author Patricia Matsuda
 * * 
 */
public class IOPRactice3
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		PrintWriter output = null;
		char answer = ' ';
		
		String fName = null, lName = null, publisher = null;
		int age  = 0;
		
		try
		{
			output = new PrintWriter("PersonData.csv");
		} catch (Exception e)
		{
			System.out.println("Error opening file.");
			System.exit(2);
		}

		System.out.print("Do you want to enter person data? Y=Yes or N=No. ");
		answer = kb.next().toLowerCase().charAt(0);
		
		
		while(answer == 'y')
		{
			kb.nextLine();
			System.out.print("Enter first name: ");
			fName = kb.nextLine();
			System.out.print("Enter last name: ");
			lName = kb.nextLine();
			System.out.print("Enter age: ");
			age = kb.nextInt();
			
			output.println(fName + "," + lName + "," + age);
			
			System.out.print("Continue? Y=Yes or N=No.");
			answer = kb.next().toLowerCase().charAt(0);
		}
	}

}
