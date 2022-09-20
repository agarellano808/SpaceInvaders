import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;

public class Player extends Sprite{
	private int width;
	private int height;
	private Missile missile;
	public Player() {
		missile=new Missile();
		ImageIcon playerIcon=new ImageIcon("C:/Users/Owner/workspace/SpaceInvaders/src/Earth Space Fighter.png");
		width = playerIcon.getImage().getWidth(null);
		height = playerIcon.getImage().getHeight(null);
		setImage(playerIcon.getImage());
		setX(320-width/2);
		setY(480-height*2);
	}
	
	public void move() {
		x+=dx;
		if (x<=2) {
			x=2;
		}
		
		if(x>=640-width) {
			x=640-width;
		}
		
	}
	
	public Missile getMissile() {
		return missile;
	}

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }
		
        if(key == KeyEvent.VK_SPACE) {
			if(!missile.isVisible()) {
				missile= new Missile((x-3)+width/2,y);
				missile.setVisible(true);
				
			}
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
