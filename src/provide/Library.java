package provide;

import java.util.Random;

public class Library {
	private static Random rnd = new Random(12345L);
	private static int random = 0;
	
	public Library()
	{}
	public static int randomChance()
	{
		random = rnd.nextInt()%100 + 1;
		return random;
	}
}
