// @author cfcurti2
//@author tdhowar2

public class PelletList {

	Pellet[] pelletArray = new Pellet[100];
	private int size = 0;
	private boolean eating = false;

	// sets and gets
	
	public Pellet getPellet(int i) {
		return pelletArray[i];
	}

	public int getSize() {
		return pelletArray.length;
	}
	
	public boolean getEating(){
		return eating;
	}
	
	public void setEating(boolean eating){
		this.eating = eating;
	}
	// end sets and gets

	public PelletList() { 				//default constructor reads the pellet data from the text file and fills the array

		TextIO.readFile("data.txt");
		while (!TextIO.eof()) {
			String line = TextIO.getln();
			int index = line.indexOf(',');
			Pellet p = new Pellet(Integer.parseInt(line.substring(0, index)),		// x and y values are comma separated
					Integer.parseInt(line.substring(index + 1, line.length())));
			add(p);
		}
	}

	public void add(Pellet p) {			// basic add method with array doubling if full
		size++;
		if (size > pelletArray.length) {
			Pellet[] temp = new Pellet[size * 2];
			for (int i = 0; i < pelletArray.length; i++)
				temp[i] = pelletArray[i];
			pelletArray = temp;
		}
		pelletArray[size - 1] = p;
	}

	public boolean paintAll(PacMan p) {	
		int count = 0;
		for (int i = 0; i < size; i++) {
			boolean a = pelletArray[i].isTouching(p);		// checks if pacman is touching any of the pellets
			if(a && pelletArray[i] instanceof SuperPellet)
				eating = true;
			if (!pelletArray[i].isEaten())		// if the pellet has not been eaten
				pelletArray[i].paint();			// paint pellet
			else
				count++;						// counts the number of eaten pellets

			if (count == size) {				// if all of them are eaten then reset the pellets
				resetPellets();
				return true;
			}
		}
		return false;							// the booleans returned here are for level incrementation
												// true for new level/all pellets eaten, false otherwise
	}

	public void resetPellets() {
		for (int i = 0; i < size; i++) {
			if (pelletArray[i] instanceof SuperPellet)			// if the pellet is a super pellet
				pelletArray[i] = new Pellet(pelletArray[i]);	// change it back to a normal pellet at the same location using copy constructor
			pelletArray[i].resetPellet();						// reset the pellet
		}
		if (Game.getLevel() > 0) {											// if the game level is over 1
			int random = (int) (Math.random() * size);						// get a random pellet
			pelletArray[random] = new SuperPellet(pelletArray[random]);		// make it a super pellet at the same position
		}

	}
}