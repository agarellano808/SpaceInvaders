import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class HighScoreScreen extends JPanel {
	private JButton J;
	private DatabaseManager d;
	private String playerInitials[];
	private String highScores[];
	private Frame frame;
	private AncestorListener ancestorListener;

	public HighScoreScreen() throws SQLException {
		setLayout(new BorderLayout());
		addButtons();
		addButtonActionListeners();
		setAncestorListener();
		d =new DatabaseManager();
		initalizeHighScores();
	}

	public void addButtons() {
		J = new JButton("Back");
		J.setAlignmentX(CENTER_ALIGNMENT);
		add(J, BorderLayout.SOUTH);
	}

	private void addButtonActionListeners() {
		J.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.changePanel("1");
				frame.setHgap(100);
				frame.setVgap(160);
				frame.pack();
			}
		});
	}

	public void initalizeHighScores() throws SQLException {
		playerInitials = new String[10];
		highScores = new String[10];
		for (int i = 0; i < 10; i++) {
			playerInitials[i] = d.getInitials(i+1);
			highScores[i] =  Integer.toString(d.getScore(i+1));
		}
	}

	private void setAncestor() {
		frame = (Frame) SwingUtilities.getWindowAncestor(this);
	}

	private void setAncestorListener() {
		ancestorListener = new AncestorListener() {

			@Override

			public void ancestorAdded(AncestorEvent ancestorEvent) {
				setAncestor();
				frame.setHgap(0);
				frame.setVgap(0);
				frame.setSize(640, 480);
			}

			@Override
			// This method is not being used and has been left intentionally blank
			public void ancestorMoved(AncestorEvent ancestorEvent) {
			}

			@Override
			// This method is not being used and has been left intentionally blank
			public void ancestorRemoved(AncestorEvent ancestorEvent) {
			}

		};
		addAncestorListener(ancestorListener);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			
			draw(g);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBackground(Color.black);
	}

	public void draw(Graphics g) throws SQLException {
		g.setColor(Color.white);
		g.drawString("HIGHSCORES",285,20);
		g.drawString("RANK",255,55);
		g.drawString("PLAYER",300,55);
		g.drawString("SCORE",355,55);
		for (int i = 0; i < 10; i++) {
			g.drawString(Integer.toString(i+1),265,50+(30 * (i + 1)));
			g.drawString(playerInitials[i], 310, 50 + (30 * (i + 1)));
			g.drawString(highScores[i], 360, 50 + (30 * (i + 1)));

		}
	}

}
