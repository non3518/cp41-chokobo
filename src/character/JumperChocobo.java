package character;
import simInterface.IObstructable;
public class JumperChocobo extends Chocobo implements IObstructable{
		private int turnCount;
		private int obstructedDuration;
		
		public JumperChocobo(){
			this.speed = 7.5;
			turnCount = 1;
			obstructedDuration = 0;
		}

		public int getObstructedDuration() {
			return obstructedDuration;
		}

		public void setObstructedDuration(int obstructedDuration) {
			this.obstructedDuration = obstructedDuration;
		}
		
		public void start()
		{
			this.distance = 0;
		}
		
		public void run()
		{
			if(turnCount == 0)
			{
				this.distance+=this.speed;
				turnCount=1;
				main.RacingManager.printCharacterDistance("JumperChocobo",this.getDistance());
			}
			else
			{
				turnCount--;
				main.RacingManager.printJumperChocoboPreparingToJump(distance);
			}
		}
		public void obstructed()
		{
			if(obstructedDuration == 0)
			{
				main.RacingManager.printJumperChocoboObstructed();
				this.speed/=2;
			   obstructedDuration = 2;
			}
		}

}
