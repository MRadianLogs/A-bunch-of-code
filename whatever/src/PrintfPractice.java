import java.util.Scanner;

/*
 * File name: PrintfPractice.java
 *
 * Programmer: Michael Reyes
 * ULID: MJREYES
 *
 * Date: Feb 22, 2017
 *
 * Class: IT 179
 * Lecture Section: 1
 * Lecture Instructor: Dr. Tonya Pierce
 */

/**
 * <Insert C;ass Description Here>
 *
 * @author Michael Jesus Reyes
 *
 */
public class PrintfPractice
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		//System.out.printf(format, args)
		//Example:
		System.out.print("Im going to round a number to two decimals. Enter a number: ");
		double number = input.nextDouble();
		System.out.printf("Your number: %.2f", number);
	}
}
