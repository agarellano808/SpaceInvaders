import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class EnterInitialsPanel extends JPanel {
	private Frame frame;
	private int score;
	private JLabel label1;
	private JLabel label2;
	private JTextField textField;
	private JButton submitButton;
	private DatabaseManager d;
	private AncestorListener ancestorListener;
	public EnterInitialsPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		addComponents();
		addButtonActionListeners();
		setAncestorListener();
	}
	
	public void addComponents() {
		label1= new JLabel("New high score!");
		add(label1);
		label1.setAlignmentX(CENTER_ALIGNMENT);
		add(Box.createRigidArea(new Dimension(0, 5)));
		label2= new JLabel("Enter your initials");
		label2.setAlignmentX(CENTER_ALIGNMENT);
		add(label2);
		add(Box.createRigidArea(new Dimension(0, 5)));
		textField= new JTextField();
		textField.setDocument(new JTextFieldLimit(3));
		textField.setAlignmentX(CENTER_ALIGNMENT);
		add(textField);
		add(Box.createRigidArea(new Dimension(0, 5)));
		submitButton = new JButton("Submit");
		submitButton.setAlignmentX(CENTER_ALIGNMENT);
		add(submitButton);
	}
	public void addButtonActionListeners(){
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d = new DatabaseManager();
				try {
					d.updateTable(textField.getText().toUpperCase(),score);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVgap(0);
				frame.setHgap(0);
				frame.setSize(640, 480);
				frame.changePanel("" + 3);
				frame.setFocus();
			}
		});
	}
	public void setScore(int score) {
		this.score=score;
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
