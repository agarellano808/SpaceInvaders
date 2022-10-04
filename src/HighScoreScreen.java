import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class HighScoreScreen extends JPanel {
	private JButton J;
	private String playerInitials[];
	private String highScores[];
	private Frame frame;
	private AncestorListener ancestorListener;

	public HighScoreScreen() {
		setLayout(new BorderLayout());
		addButtons();
		addButtonActionListeners();
		setAncestorListener();
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

	public void initalizeHighScores() {
		playerInitials = new String[10];
		highScores = new String[10];
		for (int i = 0; i < 10; i++) {
			playerInitials[i] = "AAA";
			highScores[i] = "00000000";
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
		draw(g);
		setBackground(Color.black);
	}

	public void draw(Graphics g) {
		for (int i = 0; i < 10; i++) {
			g.setColor(Color.white);
			initalizeHighScores();
			g.drawString(playerInitials[i], 280, 50 + (30 * (i + 1)));
			g.drawString(highScores[i], 330, 50 + (30 * (i + 1)));

		}
	}

}
