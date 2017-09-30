package character;

public class RunnerChocobo extends Chocobo {
	public RunnerChocobo()
	{
		this.speed = 3.0;
	}
	
	public void start()
	{
		this.distance = 0.0;
	}
	
	public void run()
	{
		this.distance += this.speed;
		main.RacingManager.printCharacterDistance("RunnerChocobo",this.getDistance());
	}
	
}
