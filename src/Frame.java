import javax.swing.JFrame;

public class Frame extends JFrame {

	public Frame() {
		add(new Board());
		setTitle("Space Invaders");
		setSize(640,480);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
