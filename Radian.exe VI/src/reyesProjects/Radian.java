/*
 * File name: RadianApp.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: Jun 6, 2017
 */
package reyesProjects;

import java.util.Scanner;

/**
 * <Insert C;ass Description Here>
 *
 * @author Michael Jesus Reyes
 *
 */
public class Radian
{
	private static void displayChoices()
	{
		System.out.println("1. \"What are you?\" "
				+ "\n2. \"What do you do?\""
				+ "\n3. \"What can you tell me about your creator?\""
				+ "\n4. Quit");
		
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		boolean active = true;
		int choice = -1;
		
		System.out.println("Hello, I am Radian.");
		while(active == true)
		{
			System.out.println("\nWhat would you like to know?");
			//Options to choose from:
			displayChoices();
			choice = input.nextInt();
			System.out.print("\n");
			
			//Reading choice
			if(choice == 1)
			{
				System.out.println("I am a virtual interface, also known as VI, named Radian. I was created by Michael Reyes based off the "
						+ "many VI from the Mass Effect franchise.");
			}
			else if(choice == 2)
			{
				System.out.println("I am currently in my most basic form, version 1, to be specific. This form consists of only text based "
						+ "communication with users. I can currently only provide information via text on your screen. In the future, I "
						+ "hope to be upgraded in ways that increase my possible methods of communicating with users, provide me with more "
						+ "uses to users, and more.");
			}
			else if(choice == 3)
			{
				int learnMore = 1;
				while(learnMore == 1)
					{
						System.out.println("What do you want to know about him?");
						System.out.println("1. \"What does he do?\""
									+ "\n2. \"Where was he from?\""
									+ "\n3. \"What does he do for fun?\""
									+ "\n4. \"Nevermind\"");
						choice = input.nextInt();
						System.out.println();
						if(choice == 1)
						{
							System.out.println("Michael is currently a student, working towards getting his first degree in Computer Science. "
										+ "After that, he plans on getting a job in some IT field, but he's not sure what kind of job yet. Eventually, "
										+ "he plans on getting a doctorate in computer science or engineering so he can become The Computer Doctor or "
										+ "\"Doctor Java\" as some people might know him. ");
						}
						else if(choice == 2)
						{
							System.out.println("Michael grew up in a suburb of Chicago. He is currently living at his university.");
						}
						else if(choice == 3)
						{
							System.out.println("For fun, Michael likes to program, watch Star Trek and other space themed shows or movies, and even game quite a bit to get ideas. He also likes to go running and work out. He even just likes to learn about sciences or things related to his life. For example, he once watched a bunch of videos about the physics and science behind warp theory like that in Star Trek, Star Wars, Mass Effect, and other popular space themed medias.");
						}
						else if(choice == 4)
						{
							learnMore = 0;
						}
						
						if(learnMore!= 0)
						{
							System.out.println("\nDo you want to learn more about my creator?");
							System.out.println("1. \"Yes\" " + " \n2. \"No\"");
							learnMore = input.nextInt();
							System.out.println();
						}
					}
			}
			else if(choice == 4) //Quit
			{
				active = false;
				System.out.println("Goodbye.");
			}
		}
		input.close();
	}
}
