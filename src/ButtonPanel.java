import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ButtonPanel extends JPanel {
	private JButton playButton;
	private JButton highScoreButton;
	private JButton quitButton;
	
	public ButtonPanel() {
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		playButton = new JButton("PLAY");
		playButton.setAlignmentX(CENTER_ALIGNMENT);

		
		highScoreButton = new JButton("HIGH SCORE");
		highScoreButton.setAlignmentX(CENTER_ALIGNMENT);

		
		quitButton = new JButton("QUIT");
		quitButton.setAlignmentX(CENTER_ALIGNMENT);

	    add(playButton);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(highScoreButton);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(quitButton);
	}
	
	public void init() {
		Frame jf= (Frame) SwingUtilities.getWindowAncestor(this);
		playButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				jf.setVgap(0);
				jf.setHgap(0);
				jf.setSize(640,480);
				jf.changePanel(""+2);
				
			}
		});
		highScoreButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				jf.changePanel(""+3);
				jf.initializeHighscorescreen();
			}
		});
		
		quitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
				System.exit(0);
			}
		});
	}
}
