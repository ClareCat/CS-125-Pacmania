import java.awt.event.KeyEvent;

//@author cfcurti2
//@author tdhowar2

public class PacMan {

	private int x, y, direction;
	private int score = 0;
	protected boolean life = true;

	public PacMan() {
		this.x = 392; //sets pacman to the initial position
		this.y = 62; //centre of the top track
	}

	//sets and gets
	
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

	public int getScore() {
		return score;
	}
	
	public void setLife(){
		life = !life;
	}
	
	//end sets and gets

	public void addScore(int n) { //the is the game/player score increment method
		score += n;
	}
	
	public void move() { // move function just for pacman
	
		
		if (Zen.isVirtualKeyPressed(KeyEvent.VK_RIGHT))  // if the right arrow is pressed
			if (Zen.getZenWidth() - x + 2 > 120
					&& ((y == 62) || (y == 482)
							|| (y == 181 && x >= 182 && x <= 602)		// this logic is for where pacman is ALLOWED to move right
							|| (y == 363 && x >= 182 && x < 603)
							|| (y >= 267 && y <= 277 && x > 602) || y >= 267	// it is done with pixel values x and y
							&& y <= 277 && x <= 182)){
				x++;
				direction=0;	//sets direction for the paint method
			}
		if (Zen.isVirtualKeyPressed(KeyEvent.VK_LEFT))
			if (x - 2 > 60
					&& (((y == 62) || (y == 482)
							|| (y == 181 && x >= 183 && x <= 603)	//logic for pacman ALLOWED to move left
							|| (y == 363 && x >= 183 && x <= 603)
							|| (y >= 267 && y <= 277 && x > 602) || y >= 267
							&& y <= 277 && x <= 183))){
				direction=1;
				x--;
	}
		if (Zen.isVirtualKeyPressed(KeyEvent.VK_DOWN))
			if (Zen.getZenHeight() - y + 2 > 120
					&& !((y == 272 && (x > 62 && x < 182 || x > 603 && x < 722))	//the logic for up and down are different from left and right
							|| (y == 363 && ((x > 181 && x < 392 || x > 392			// up and down are logic for when pacman is NOT ALLOWED to move up or down
									&& x < 722)))
							|| (y == 181 && x > 182 && x < 603)
							|| (y == 482 && (x >= 182 && x < 392 || x > 392
									&& x < 603)) || (y == 62 && (x > 62
							&& x < 392 || x > 392 && x < 722)))){
				direction=2;
				y++;
			}
		if (Zen.isVirtualKeyPressed(KeyEvent.VK_UP))
			if (y - 2 > 60
					&& !((y == 272 && (x > 62 && x < 182 || x > 603 && x < 722))
							|| (y == 363 && x > 182 && x < 603)
							|| (y == 181 && (x >= 182 && x < 392 || x > 392
									&& x < 604)) || (y == 482 && ((x > 62
							&& x < 392 || x > 392 && x < 721))))){
				y--;
				direction=3;
			}
	}
	
	public void paint() {
		Zen.setColor(255, 255, 0); //set colour yellow
		if (direction==0) Zen.drawImage("pacmanR1.gif", x, y);			//paints different states of pacman for up/down/left/right movement
		else if (direction==1) Zen.drawImage("pacmanL1.gif", x, y);		// for direction 0=right,1=left,2=down,3=up
		else if (direction==2) Zen.drawImage("pacmanD1.gif", x, y);
		else Zen.drawImage("pacmanU1.gif", x, y);
		//Zen.drawText(x + "," + y, 10, 10);// for debugging, puts pacmans x and y position on the screen

	}
}
