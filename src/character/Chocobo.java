package character;

import simInterface.ICharacter;

public abstract class Chocobo implements ICharacter{
	protected double speed;
	protected double distance;
	public double getSpeed() {
		return speed;
	}
	public double getDistance() {
		return distance;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public int compareTo(ICharacter o)
	{
		if(this.distance != o.getDistance()) 
		{
			return Double.compare(this.distance, o.getDistance());
		}
		if(this instanceof RunnerChocobo) return -1;
		if(this instanceof Pikachu) return 1;
		if(o instanceof Pikachu) return -1;
		if(o instanceof RunnerChocobo) return 1;
		return 0;
	}
}
