// @author cfcurti2
//@author tdhowar2

public class Pellet {

	protected int x;
	protected int y;
	protected int value;
	protected boolean eaten = false;
	private boolean eating;

	// sets and gets

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public boolean isEaten() {
		return eaten;
	}

	public void resetPellet() {
		eaten = false;
	}
	
	public void setEating(boolean eating){
		this.eating = eating;
	}
	
	public boolean getEating(){
		return eating;
	}
	
	//end sets and gets
	
	public Pellet() {
	}

	public Pellet(int x, int y) {
		this.x = x;
		this.y = y;
		value = 100;
	}

	public Pellet(Pellet other) {	//copy constructor
		this.x = other.x;
		this.y = other.y;
	}

	public void paint() {	
		Zen.setColor(255, 255, 255);	//set colour white
		Zen.fillOval(x - 5, y - 5, 10, 10);
	}

	public boolean isTouching(PacMan p) {	//same proximity check as ghost but within 30 pixels
		if (Math.abs(p.getX() + 30 - x) < 25
				&& Math.abs(p.getY() + 25 - y) < 30 && !eaten) {
			eaten = true;
			p.addScore(value);	//sets eaten to true and adds the score to the pacman object
			if(value == 1000)
				return true;
		}
		return false;
	}

}
