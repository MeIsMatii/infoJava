import greenfoot.Actor;
import greenfoot.Greenfoot;

public class Rock extends ImprovedActor
{
	private int remainingHits;

	public Rock() {
		setHits(Greenfoot.getRandomNumber(10));
	}

	public Rock(int remainingHits) {
		setHits(remainingHits);
	}


	public void setHits(int newAmount) {
		this.remainingHits = newAmount;
	}
	public int getHits() {
		return this.remainingHits;
	}
	
	/**
	 * Will be called on a hit.
	 */
	public void hit(){
		getWorld().addObject(new Star(), getX(), getY()); //Bei einem Treffer wird kurz ein Stern eingeblendet
		setHits(getHits() -1);

		if(getHits() < 1) {
			getWorld().removeObject(this);
		}
		draw(getHits());
	}

}