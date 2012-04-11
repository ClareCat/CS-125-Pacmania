// @author cfcurti2
//@author tdhowar2
public class SuperGhost extends Ghost {

	public SuperGhost() {
		super(Zen.getZenWidth() / 2, Zen.getZenHeight() / 2);	// makes a super ghost in the centre of the board
	}

	public void move(PacMan p) {									// new move logic
		if (Math.abs(super.getX() - p.getX()) < 250
				&& Math.abs(super.getY() - p.getY()) < 250) {		// if pacman is within 250 pixels of the super ghost it moves

			if (super.getX() > p.getX())							// movement logic makes it home in on pacman
				super.setX(super.getX() - 1);						
			else
				super.setX(super.getX() + 1);
			if (super.getY() > p.getY())
				super.setY(super.getY() - 1);
			else
				super.setY(super.getY() + 1);
		}
	}

	public void paint() {
		Zen.drawImage("ghost_red.gif", super.getX(), super.getY());		// paints the red super ghost gif
	}

}
