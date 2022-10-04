import java.awt.CardLayout;
import javax.swing.JFrame;

public class Frame extends JFrame {
	private ButtonPanel buttonPanel;
	private CardLayout cl;
	private HighScoreScreen s;
	private Board board;
	public Frame() {

		setTitle("Space Invaders");
		cl = new CardLayout(100, 160);
		setLayout(cl);
		setSize(640, 480);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buttonPanel = new ButtonPanel();
		getContentPane().add(buttonPanel, "1");
		board=new Board();
		getContentPane().add(board, "2");
	    s = new HighScoreScreen();
		getContentPane().add(s, "3");
		
		pack();
	}
	
	public void setFocus() {
		board.requestFocus(true);
	}
	public void initializeHighscorescreen() {
		s.init();
	}

	public void changePanel(String s) {
		cl.show(getContentPane(), s);
	}

	public void setVgap(int i) {
		cl.setVgap(i);
	}

	public void setHgap(int i) {
		cl.setHgap(i);
	}
}
