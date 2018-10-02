package practice;

import java.util.Scanner;

public class whatevr
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter seconds: ");
		int input = scan.nextInt();
		
		int hours = input/3600;
		input = input % 3600;
		
		int minutes = input/60;
		input = input % 60;
		
		int seconds = input;
		
		System.out.println("Hours: " + hours);
		System.out.println("Minutes: " + minutes);
		System.out.println("Seconds: " + seconds);
	}

}
