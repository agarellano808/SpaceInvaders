import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controls extends KeyAdapter{
	private Player player;
	public Controls (Player player){
		this.player=player;
	}
	
	public void keyReleased(KeyEvent e) {
		player.keyReleased(e);
	}
	
	public void keyPressed(KeyEvent e) {
		player.keyPressed(e);
		int x= player.getX();
		int y = player.getY();
		int key = e.getKeyCode();
			}

}
