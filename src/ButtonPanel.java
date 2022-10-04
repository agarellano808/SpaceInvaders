import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class ButtonPanel extends JPanel {
	private JButton playButton;
	private JButton highScoreButton;
	private JButton quitButton;
	private Frame frame;
	private AncestorListener ancestorListener;

	public ButtonPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		addButtons();
		addButtonActionListeners();
		setAncestorListener();
	}

	private void addButtons() {
		playButton = new JButton("PLAY");
		playButton.setAlignmentX(CENTER_ALIGNMENT);

		highScoreButton = new JButton("HIGH SCORE");
		highScoreButton.setAlignmentX(CENTER_ALIGNMENT);

		quitButton = new JButton("QUIT");
		quitButton.setAlignmentX(CENTER_ALIGNMENT);

		add(playButton);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(highScoreButton);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(quitButton);
	}

	private void addButtonActionListeners() {
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVgap(0);
				frame.setHgap(0);
				frame.setSize(640, 480);
				frame.changePanel("" + 2);
				frame.setFocus();

			}
		});

		highScoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.changePanel("" + 3);
				frame.initializeHighscorescreen();
			}
		});

		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
	}

	private void setAncestor() {
		frame = (Frame) SwingUtilities.getWindowAncestor(this);

	}

	private void setAncestorListener() {
		ancestorListener = new AncestorListener() {

			@Override

			public void ancestorAdded(AncestorEvent ancestorEvent) {
				setAncestor();
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
}
