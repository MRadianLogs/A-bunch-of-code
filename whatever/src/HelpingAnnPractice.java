/*
 * File name: HelpingAnnPractice.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: Apr 1, 2019
 */

/**
 * This class was made to test one of Ann's homework problems. She was correct in her output!
 *
 * @author Michael Jesus Reyes
 *
 */
public class HelpingAnnPractice
{
	public static void main(String[] arg)
	{
		int c = 0;
		for(int a = 0; a <5;a++)
		{
			for(int b = 0; b <5;b++)
			{
				System.out.print(b + " ");
				c = a +b;
				System.out.println(c);
			}
			System.out.println();
		}
	}
}
