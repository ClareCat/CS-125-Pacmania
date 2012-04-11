// @author cfcurti2
//@author tdhowar2
class SuperPellet extends Pellet {

	SuperPellet() {
	}

	SuperPellet(Pellet p) { 	// takes in a pellet
		super(p);				// makes a new one using the copy constructor
		super.setValue(1000);	// sets value to super value
	}

	SuperPellet(int x, int y) {	
		super(x, y);
		super.setValue(1000);
	}

	public void paint() {
		Zen.setColor((int) (Math.random() * 256), (int) (Math.random() * 256),	// paints the super pellets, larger than normal and flashing colours
				(int) (Math.random() * 256));
		Zen.fillOval(x - 8, y - 8, 16, 16);
	}
}
