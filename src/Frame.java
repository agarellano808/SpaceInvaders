import java.awt.CardLayout;
import java.sql.SQLException;

import javax.swing.JFrame;

public class Frame extends JFrame {
	private ButtonPanel buttonPanel;
	private CardLayout cl;
	private HighScoreScreen s;
	private Board board;
	private EnterInitialsPanel initialsPanel;
	public Frame() throws SQLException {

		setTitle("Space Invaders");
		cl = new CardLayout(100, 160);
		setLayout(cl);
		setSize(640, 480);
		setResizable(false);
		addPanels();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
	
	private void addPanels() throws SQLException {
		buttonPanel = new ButtonPanel();
		getContentPane().add(buttonPanel, "1");
		board=new Board();
		getContentPane().add(board, "2");
	    s = new HighScoreScreen();
		getContentPane().add(s, "3");
		initialsPanel = new EnterInitialsPanel();
		getContentPane().add(initialsPanel, "4");
	}
	public void setFocus() {
		board.requestFocus(true);
	}
	
	public void setScore(int score) {
		initialsPanel.setScore(score);
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
