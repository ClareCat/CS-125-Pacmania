// @author cfcurti2
//@author tdhowar2

public class Ghost {

	protected int x;

	protected int y;

	protected int direction = 0;
	private int id;
	private static int count;
	protected boolean eaten = false;

	//sets and gets 
	
	public void setEaten(boolean eaten){
		this.eaten = eaten;
	}
	
	public boolean getEaten(){
		return eaten;
	}
	
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setDirection(int d) {
		this.direction = d;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	public int getDirection() {
		return direction;
	}
	
	public int getId() {
		return id;
	}

	//end sets and gets
	
	public Ghost() { //default constructor- makes a ghost in the bottom middle of the map
		this.x = 392;
		this.y = 482; 
		id = count;
		eaten = false;
	}

	public Ghost(int x, int y) { //set your own position
		this.x = x;
		this.y = y;
		id = count;
		eaten = false;
	}
	
	public Ghost(int x, int y, int direction){
		this.x = x;
		this.y = y;
		this.direction = direction;
		eaten = false;
	}
	
	public Ghost(int x, int y, int direction, boolean eaten){
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.eaten = eaten;
	}

	public static void resetCount() {
		count = 0;
	}

	public static int getNumGhostsCreated() {
		return count;
	}

	public void move(PacMan p) { //ghost move method, is passed a pacman but does not use it because the super ghost move does use it

		if (direction == 0
				&& (Zen.getZenWidth() - x + 2 > 120 && ((y == 62) || (y == 482) 	//same logic as pacman for allowed movement
						|| (y == 181 && x >= 182 && x <= 602)
						|| (y == 363 && x >= 182 && x < 603)
						|| (y >= 267 && y <= 277 && x > 602) || y >= 267
						&& y <= 277 && x <= 182))) {
			if (x == 392)
				direction = ((int) (Math.random() * 4));
			x++;
		}

		else if (direction == 1
				&& (x - 2 > 60 && (((y == 62) || (y == 482)
						|| (y == 181 && x >= 183 && x <= 603)
						|| (y == 363 && x >= 183 && x <= 603)
						|| (y >= 267 && y <= 277 && x > 602) || y >= 267
						&& y <= 277 && x <= 183)))) {
			if (x == 392)
				direction = ((int) (Math.random() * 4));

			x--;
		}

		else if (direction == 2
				&& (Zen.getZenHeight() - y + 2 > 120 && !((y == 272 && (x > 62
						&& x < 182 || x > 603 && x < 722))
						|| (y == 363 && ((x > 181 && x < 392 || x > 392
								&& x < 721)))
						|| (y == 181 && x > 182 && x < 603)
						|| (y == 482 && (x >= 182 && x < 392 || x > 392
								&& x < 603)) || (y == 62 && (x > 62 && x < 392 || x > 392
						&& x < 722))))) {
			if (y == 272)
				direction = ((int) (Math.random() * 4));
			y++;
		}

		else if (direction == 3
				&& (y - 2 > 60 && !((y == 272 && (x > 62 && x < 182 || x > 603
						&& x < 722))
						|| (y == 363 && x > 182 && x < 603)
						|| (y == 181 && (x >= 182 && x < 392 || x > 392
								&& x < 604)) || (y == 482 && ((x > 62
						&& x < 392 || x > 392 && x < 722)))))) {
			if (y == 272)
				direction = ((int) (Math.random() * 4));
			y--;
		} else
			direction = ((int) (Math.random() * 4));	//this statement lets the pick random direction if it gets stuck

	}

	public boolean isTouching(PacMan p) { //checks if packman is within 40 pixels of the ghost
		if (Math.abs(p.getX() - x) < 40 && Math.abs(p.getY() - y) < 40){
			return true;
		}
		return false;
					
	}

	public void paint() {
		Zen.drawImage("ghost_inky.gif", x, y);	//paints the default ghost gif
/*
			Zen.drawText( "g direction " + direction + (direction == 0 && ((y ==
			62) || (y == 482 && x < 722 & x > 62) || (y == 181 && x >= 182 && x
			<= 602) || (y == 363 && x >= 182 && x <= 602) || (y >= 267 && y <=
			277 && x > 603) || y >= 267 && y <= 277 && x <= 182)) + (direction ==
			1 && (x - 2 > 60 && (((y == 62) || (y == 482) || (y == 181 && x >=
			183 && x <= 602) || (y == 363 && x >= 183 && x <= 602) || (y >= 267
			&& y <= 277 && x > 602) || y >= 267 && y <= 277 && x <= 183)))) +
			(direction == 2 && (Zen.getZenHeight() - y + 2 > 120 && !((y == 272
			&& (x > 62 && x < 182 || x > 602 && x < 722)) || (y == 363 && ((x >
			181 && x < 392 || x > 392 && x < 721))) || (y == 181 && x > 182 && x
			< 602) || (y == 482 && (x >= 182 && x < 392 || x > 392 && x < 603))
			|| (y == 62 && (x > 62 && x < 392 || x > 392 && x < 721))))) +
			(direction == 3 && (y - 2 > 60 && !((y == 272 && (x > 62 && x < 182
			|| x > 602 && x < 722)) || (y == 363 && x > 182 && x < 602) || (y ==
			181 && (x >= 182 && x < 392 || x > 392 && x < 603)) || (y == 482 &&
			((x > 62 && x < 392 || x > 392 && x < 721)))))) + "  " + x + "," + y,
			10, 40);// for debugging - outputs ghost x and y and directional booleans
*/

	}
}
