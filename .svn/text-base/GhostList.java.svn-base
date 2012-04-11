// @author cfcurti2
//@author tdhowar2

public class GhostList {

	Ghost[] ghostArray = new Ghost[8];	// list array is orginiall 8 ghosts, uses doubling feature if it gets larger
	private int size = 0;
	Change change;

	//sets and gets
	
	public Ghost getGhost(int i) {
		return ghostArray[i];
	}

	public int getSize() {
		return ghostArray.length;
	}

	//end sets and gets
	
	public void changeList(boolean x){
		if(x)
			change = new Change(10);
		if(change != null && change.getChange())
			makeNormal(true); 
	}
	
	public void makeNormal(){
		Ghost[] temp = new Ghost[size];
		for(int i = 0; i < size; i++)
			temp[i] = new Ghost(ghostArray[i].getX(), ghostArray[i].getY(), ghostArray[i].getDirection());
		ghostArray = temp;
	}
	
	public void makeNormal(boolean eating){
		Ghost[] temp = new Ghost[size];
		for(int i = 0; i < size; i++)
			temp[i] = new Ghost(ghostArray[i].getX(), ghostArray[i].getY(), ghostArray[i].getDirection(), ghostArray[i].getEaten());
		ghostArray = temp;
	}
	
	
	public GhostList() {	//default constructor makes a single ghost on initialisation
		makeGhost();
	}

	public void makeGhost() {
		makeNormal();
		Ghost g1;
		if (Game.getLevel() % 2 == 0)		// every 5 levels make a super ghost
			g1 = new SuperGhost();
		else
			g1 = new Ghost();				// otherwise make a normal ghost
		add(g1);							// adds it to the list using the add function
	}

	public void add(Ghost g) {
		size++;
		if (size > ghostArray.length) {
			Ghost[] temp = new Ghost[size * 2];				//fill the ghost list and it becomes twice as big
			for (int i = 0; i < ghostArray.length; i++)
				temp[i] = ghostArray[i];
			ghostArray = temp;
		}
		ghostArray[size - 1] = g;
	}

	public void makeEating(){
		Ghost[] temp = new Ghost[size];
		for(int i = 0; i < size; i++)
			temp[i] = new EatingGhost(ghostArray[i].getX(), ghostArray[i].getY(), ghostArray[i].getDirection());
		ghostArray = temp;
	}
	
	public void paintAll() {					//paints all the ghosts in the list
		for (int i = 0; i < size; i++) {
			if(ghostArray[i].getEaten());
			else
				ghostArray[i].paint();
		}
	}

	public void moveAll(PacMan p) {					//moves all the ghosts in the list
		for (int i = 0; i < size; i++) {
			if (ghostArray[i] instanceof SuperGhost)	// if the ghost is a superghost it only moves once
				ghostArray[i].move(p);
			else{
				ghostArray[i].move(p);					// otherwise normal ghosts move twice
				ghostArray[i].move(p);

			}
			if (ghostArray[i].isTouching(p) && (ghostArray[i] instanceof EatingGhost))			// it also checks if any of the ghosts are touching pacman after moving them
				ghostArray[i].setEaten(true);
			else if(ghostArray[i].isTouching(p) && !(ghostArray[i].getEaten()))
				p.setLife();
				
		}
	}

}
