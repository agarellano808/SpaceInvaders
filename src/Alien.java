import javax.swing.ImageIcon;
public class Alien extends Sprite{
	private Missile missile;
	public Alien(int x,int y) {
		this.x=x;
		this.y=y;
	
		ImageIcon alienIcon=new ImageIcon("C:/Users/Owner/workspace/SpaceInvaders/src/Alien Spaceship.png");
		setImage(alienIcon.getImage());
		missile=new Missile(x+getImage().getWidth(null)/2,y+getImage().getHeight(null)/2);
	}
	
	public void move(int direction) {
		this.x +=direction;
	}
	
	public Missile getMissile() {
		return missile;
	}
}
