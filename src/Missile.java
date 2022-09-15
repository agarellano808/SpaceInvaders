import javax.swing.ImageIcon;

public class Missile extends Sprite{
	private int x;
	private int y;
	public Missile(int x,int y) {
		ImageIcon missleIcon=new ImageIcon("C:/Users/Owner/workspace/SpaceInvaders/src/Earth Space Fighter.png");
		setImage(missleIcon.getImage());
		this.x=x;
		this.y=y;
	}
	
	public void shootDown() {
		setX(x+6);
		setY(y-1);
	}
	
	public void shootUp() {
		
	}
	
}
