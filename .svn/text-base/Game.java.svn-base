// @author cfcurti2
//@author tdhowar2

public class Game {

	private static int level=1;
	public static int getLevel(){return level;}
	
	public Game() {

	}

	public static void main(String[] args) {
		Zen.create(840, 600, "stretch");	//makes game window 840x600

		PacMan pac = new PacMan();
		PelletList pList = new PelletList();
		GhostList gList = new GhostList();
		

		while (Zen.isRunning()) {
			if(pList.getEating()){
				gList.changeList(true);
				pList.setEating(false);
				gList.makeEating();	
			}
				gList.changeList(false);
				gList.moveAll(pac);	//moves all the ghosts
				paintBG(pac.getScore());	//paints background
				for (int i=0; i<3;i++)		//pacman moves 3 times every loop (see ghost list, normal ghosts move 2 times, super once)
				pac.move();
				pac.paint();
				if (pList.paintAll(pac)) {level++;gList.makeGhost();} 	// if the pellets are reset, level up and make a ghost
				gList.paintAll();	//paints the ghosts
				Zen.sleep(10);		//10ms delay
				Zen.flipBuffer();
				if(!pac.life){
					Zen.setColor(255, 0, 0);
					Zen.setFont("Courier-64");
					Zen.drawText("DEAD",20,40);
					break;	
				}
			}
		
		
		//this code for the game over screen does not work
		Zen.setColor(0, 0, 0);
		Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
		Zen.setColor(255, 0, 0);
		Zen.setFont("Courier-64");
		Zen.drawText("Sorry but the ghost got you",
				Zen.getZenWidth() / 2, Zen.getZenHeight() / 2);
		
		}

	public static void paintBG(int score) {	//paints the board, level and score
		Zen.setColor(0, 0, 255); 	//set colour blue
		Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());	
		Zen.setColor(0, 0, 0);		//set colour black
		Zen.fillRect(60, 60, (Zen.getZenWidth() - 120),
				(Zen.getZenHeight() - 120));
		Zen.setColor(0, 0, 255);//set colour blue
		Zen.fillRect(120, 120, (Zen.getZenWidth() - 240),
				(Zen.getZenHeight() - 240));
		Zen.setColor(0, 0, 0);	//set colour black
		Zen.fillRect(180, 180, (Zen.getZenWidth() - 360),
				(Zen.getZenHeight() - 360));

		Zen.fillRect(Zen.getZenWidth() / 2 - 30, 120, 60, 60);
		Zen.fillRect(Zen.getZenWidth() / 2 - 30, Zen.getZenHeight() - 180, 60,
				60);
		Zen.fillRect(120, Zen.getZenHeight() / 2 - 30, 60, 60);
		Zen.fillRect(Zen.getZenWidth() - 180, Zen.getZenHeight() / 2 - 30, 60,
				60);
		Zen.setColor(0, 0, 255); //set colour blue
		Zen.fillRect(240, 240, 360, 120);
		Zen.setColor(255, 255, 0); 	//set colour yellow
		Zen.setFont("Courier-32");
		Zen.drawText("Score: " + score, 20, 40);
		Zen.drawText("Level: "+ level, 400,40);
	}

}

