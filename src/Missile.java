import javax.swing.ImageIcon;

public class Missile extends Sprite{
	
	public Missile() {
		setVisible(false);
	}
	public Missile(int x,int y) {
		ImageIcon missleIcon=new ImageIcon(System.getProperty("user.dir")+"/src/Missile.png");
		setVisible(false);
		setImage(missleIcon.getImage());
		setX(x);
		setY(y);
	}
}
