/*
 * File name: MathCalculations.java
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
 * This class shows how math calculations can be done using instance variables with getters/setters.
 *
 * @author Michael Jesus Reyes
 *
 */
public class MathCalculations
{
	//Instance variables needed.
	//EX: length, width, height, radius, etc.
	private int length;
	private int width;
	private int height;
	private int radius;
	private final static double PI = 3.14159;
	private final static double GRAMS_SUGAR = 15;
	
	//Getters and setters?
	public void setLength(int length)
	{
		this.length = length;
	}
	public void setWidth(int width)
	{
		this.width = width;
	}
	public void setHeight(int height)
	{
		this.height = height;
	}
	public int getLength()
	{
		return length;
	}
	//Do this for all needed variables. You will call these to ask the user for information.
	
	//Calculations, such as area, volume, etc. are done in methods. 
	public double volumeOfCube()
	{
		return (double)length * width * height;
	}
	
	public double volumeOfSphere()
	{
		return (double)(4/3)*PI*(radius*radius);
	}
	
	public double twoShapes(double shape1Volume, double shape2Volume)
	{
		return shape1Volume - shape2Volume;
	}
	
	public static void main(String[] args)
	{
		MathCalculations order = new MathCalculations();
		order.setLength(36);
		order.setHeight(54);
		order.setWidth(79);
		
		System.out.println("Volume of cube: " + order.volumeOfCube());
		
		
	}
}
