package choosing;
import java.util.Random;
import java.util.Scanner;

public class RandomChooser
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("What game do you want to play? Click enter to find out!");
		String []games = {"Metroid Prime 2","Monster Hunter 3", "Monster Hunter 4", "Monster Hunter Generations", "Hyrule Warriors Legends","Metroid Prime 3: Corruption", "Super Smash Bros"};
		input.nextLine();
		//Is this the correct way to use Math.random()? Is the range correct?
		//System.out.println("You should play " + games[(int)(Math.random()*games.length)] + "!");
		
		//Better way of "randoming"? How do we know?
		Random randomizor = new Random();
		System.out.println("You should play " + games[randomizor.nextInt(games.length)] + "!");
		input.close();
	}

}
