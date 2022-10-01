import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class HighScoreScreen extends JPanel {
	private JButton J;
	public HighScoreScreen() {

	}
	public void init() {
		JFrame Jf= (JFrame) SwingUtilities.getWindowAncestor(this);
		
		J=new JButton("Back");
		J.setAlignmentX(CENTER_ALIGNMENT);
		J.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jf.setBackground(Color.black);
				Jf.setTitle("Space");
			}
		});
		add(J);
	}
}
