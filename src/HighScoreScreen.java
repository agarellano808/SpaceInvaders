import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class HighScoreScreen extends JPanel {
	private JButton J;
	private String playerInitials[];
	private String highScores[];

	public HighScoreScreen() {
		setLayout(new BorderLayout());
		J = new JButton("Back");
		J.setAlignmentX(CENTER_ALIGNMENT);
		add(J, BorderLayout.SOUTH);
	}

	public void init() {
		Frame Jf = (Frame) SwingUtilities.getWindowAncestor(this);
		Jf.setHgap(0);
		Jf.setVgap(0);
		Jf.setSize(640, 480);
		
		J.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Jf.changePanel("1");
				Jf.setHgap(100);
				Jf.setVgap(160);
				Jf.pack();
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
