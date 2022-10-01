import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame{
	private JPanel buttonPanel;
	private CardLayout cl;
	public Frame() {
	//	add(new Board());
		
		setTitle("Space Invaders");
		cl=new CardLayout(100,160);
		setLayout(cl);
		setSize(640,480);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));
	
		JButton playButton = new JButton("PLAY");
		playButton.setAlignmentX(CENTER_ALIGNMENT);
		playButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				cl.setVgap(0);
				cl.setHgap(0);
				setSize(640,480);
				cl.show(getContentPane(),""+2);
				
			}
		});
		
		JButton highScoreButton = new JButton("HIGH SCORE");
		highScoreButton.setAlignmentX(CENTER_ALIGNMENT);
		highScoreButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				cl.show(getContentPane(),""+3);
			}
		});
		
		JButton quitButton = new JButton("QUIT");
		quitButton.setAlignmentX(CENTER_ALIGNMENT);
		quitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		});
		buttonPanel.add(playButton);
		buttonPanel.add(Box.createRigidArea(new Dimension(0,10)));
		buttonPanel.add(highScoreButton);
		buttonPanel.add(Box.createRigidArea(new Dimension(0,10)));
		buttonPanel.add(quitButton);
		getContentPane().add(buttonPanel,"1");
		getContentPane().add(new Board(),"2");
		HighScoreScreen s= new HighScoreScreen();
		getContentPane().add(s,"3");
		s.init();
		pack();
	}

}
