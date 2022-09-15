import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;

public class Player extends Sprite{
	private int width;
	public Player() {
			
		ImageIcon playerIcon=new ImageIcon("C:/Users/Owner/workspace/SpaceInvaders/src/Earth Space Fighter.png");
		width = playerIcon.getImage().getWidth(null);
		setImage(playerIcon.getImage());
		setX(300);
		setY(400);
	}
	
	public void move() {
		x+=dx;
		if (x<=2) {
			x=2;
		}
		
		if(x>=480-2*width) {
			x=480-2*width;
		}
		
	}

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }
}
