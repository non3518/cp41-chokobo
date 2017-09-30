package simInterface;
public interface ICharacter extends Comparable<ICharacter>{
	public void start();
	public void run();
	public double getSpeed();
	public double getDistance();
	void setSpeed(double speed);
	void setDistance(double distance);
}
