import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/*
 * File name:  IOPractice2.java 
 * 
 * Programmer:  Patricia Matsuda
 *  ULID: mpmatsu
 *
 *  Date:  Nov 1, 2016
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
public class IOPractice2
{
	public static void main(String[] args)
	{
		Scanner input = null;
		String parser = null;
		String data = null;
		Scanner dataParser = null;
		String title = null, author=null, publisher=null, isbn=null;
		double price=0;
		
		try
		{
			input = new Scanner(new File("BookList.csv"));
		} catch (FileNotFoundException e)
		{
			System.out.println("Error openiong file");
			System.out.println(e.getMessage());
			System.exit(2);
		}
		
		input.nextLine();
		
		while(input.hasNext())
		{
			data = input.nextLine();
			dataParser = new Scanner(data);
			dataParser.useDelimiter(",");
			title = dataParser.next();
			author = dataParser.next();
			publisher = dataParser.next();
			isbn=dataParser.next();
			price = dataParser.nextDouble();
						
			System.out.println(title);
			System.out.println(author);
			System.out.println(publisher);
			System.out.println(isbn);
			System.out.println(price);
			
		}

	}

}
