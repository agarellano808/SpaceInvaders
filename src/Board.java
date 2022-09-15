import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener {
	private Dimension d;
	private Player player;
	private Alien alien;
	private int direction= -1;
	private Timer timer;

	public Board() {
		setBackground(Color.black);
		setLayout(null);
		player=new Player();
		addKeyListener(new Controls(player));
		timer=new Timer(16,this);
		timer.start();
		setFocusable(true);
		d=new Dimension(480,640);
		
		
	}
	

	
	private void drawPlayer (Graphics g) {
		if (player.isVisible()) {
			
			g.drawImage(player.getImage(),player.getX(),player.getY(),null);
			
		}
		if (player.isDead()) {
			player.die();
		}
	}
	private void update() {
		player.move();
	}
	
	  private void doGameCycle() {
		  
	        update();
	        repaint();
	    }

      @Override
      public void actionPerformed(ActionEvent e) {
    	  System.out.println("Working");
          doGameCycle();
      }
	@Override
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		
		draw(g);
	}
	
	private void draw(Graphics g) {
		drawPlayer(g);
	}
}
