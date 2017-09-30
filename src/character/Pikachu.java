package character;

import simInterface.ICharacter;
import simInterface.IObstructable;

public class Pikachu extends Chocobo implements ICharacter,IObstructable{
    private double speed;
    private double distance;
    private int obstructedDuration;
    
    public Pikachu() {
    	speed = 4.0;
    	obstructedDuration = 0;
    }

	public double getSpeed() {
		return speed;
	}

	public double getDistance() {
		return distance;
	}

	public int getObstructedDuration() {
		return obstructedDuration;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public void setObstructedDuration(int obstructedDuration) {
		this.obstructedDuration = obstructedDuration;
	}
    
    public void start()
    {
    	this.distance = 0.0;
    }
    
    public void run()
    {
    	this.distance += this.speed;
    	main.RacingManager.printCharacterDistance("Pikachu",this.getDistance());
    }
    
    public void obstructed()
    {
    	if(obstructedDuration == 0)
    	{
    		main.RacingManager.printPikachuObstructed();
    		this.speed = 0;
    		obstructedDuration = 1;
    	}
    }

	@Override
	public int compareTo(ICharacter o) {
		return super.compareTo(o);
	}

    
}
