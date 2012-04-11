// @author cfcurti2
//@author tdhowar2
import java.util.Timer;
import java.util.TimerTask;

public class Change {
	
	boolean endChange = false;
	Timer timer;

	public Change(int seconds) {
		timer = new Timer();
		timer.schedule(new EndChange(), seconds*1000);
		}
	
	public boolean getChange(){
		return endChange;
	}

	class EndChange extends TimerTask{
		public void run() {
			endChange = true;
			timer.cancel();
		}
	}
}

