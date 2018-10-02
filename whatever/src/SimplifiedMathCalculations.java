import java.util.Scanner;

/*
 * File name: SimplifiedMathCalculations.java
 *
 * Programmer: Michael Reyes
 * ULID: MJREYES
 *
 * Date: Feb 8, 2017
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
public class SimplifiedMathCalculations
{
	//Few instance variables needed.
	//Constants mainly.
	private static final double PI = 3.14159;
	private static final int GRAMS_SUGAR = 15;
	
	//Calculations done in methods. Variables needed for calculations involve user interaction.
	public double volumeOfCube(int length, int width, int height)
	{
		return (double)length * width * height;
	}
	
	public double volumeOfSphere(int radius)
	{
		return (double)(4/3)*PI*(radius * radius);
	}
	
	public static void main(String[]args)
	{
		SimplifiedMathCalculations order = new SimplifiedMathCalculations();
		Scanner input = new Scanner(System.in);
		int shape1 = 0;
		int shape2 = 0;
		//Radius not needed.. but oh well.
		int radius = 0;
		int length = 0;
		int width = 0;
		int height = 0;
		double volume1;
		double volume2;

		System.out.println("What kind of sugar thing do you want? Choose an outer shape(choose 1 for sphere or 2 for cube).");
		shape1 = input.nextInt();		
		System.out.println("What kind of sugar thing do you want on the inside of your sugar thing? Choose an outer shape(choose 1 for sphere or 2 for cube).");
		shape2 = input.nextInt();
		
		if(shape1 == 1)
		{
			System.out.println("Enter radius");
			volume1 = order.volumeOfSphere(input.nextInt());
		}
		else if(shape1 == 2)
		{
			
		}
		if(shape2 == 1)
		{
			
		}
		else if(shape2 == 2)
		{
			System.out.println("Enter length of cube");
			length = input.nextInt();
			System.out.println("Enter width of cube");
		}
	}
	
	
	
}
