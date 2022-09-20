import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.Timer;
import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener {
	private Player player;
	private ArrayList<Alien> aliens;
	private int direction = -1;
	private Timer timer;
	private boolean inGame = true;
	private String gameEndText = "GAME OVER";
	private int remainingAliens;

	public Board() {
		setBackground(Color.black);
		setLayout(null);
		player = new Player();
		addKeyListener(new Controls(player));
		timer = new Timer(16, this);
		timer.start();
		setFocusable(true);

		aliens = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 6; j++) {
				Alien alien = new Alien(120 + 60 * j, 15 + 70 * i);
				aliens.add(alien);
				remainingAliens++;
			}
		}
	}

	private void drawAliens(Graphics g) {
		for (Alien alien : aliens) {
			if (alien.isVisible()) {
				g.drawImage(alien.getImage(), alien.getX(), alien.getY(), null);
			}
			if (alien.isDead()) {
				alien.die();
			}
		}
	}

	private void drawPlayer(Graphics g) {
		if (player.isVisible()) {
			g.drawImage(player.getImage(), player.getX(), player.getY(), null);
		}

		if (player.isDead()) {
			player.die();
			inGame = false;
		}
	}

	private void drawPlayerMissile(Graphics g) {

		if (player.getMissile().isVisible()) {
			g.drawImage(player.getMissile().getImage(), player.getMissile().getX(), player.getMissile().getY(), null);
		}
	}

	private void drawAlienMissile(Graphics g) {
		for (Alien alien : aliens) {
			if (alien.getMissile().isVisible()) {
				g.drawImage(alien.getMissile().getImage(), alien.getMissile().getX(), alien.getMissile().getY(), null);
			}
		}
	}

	private void update() {
		if (remainingAliens == 0) {
			inGame = false;
			timer.stop();
			gameEndText = "YOU WIN!";
		}

		player.move();

		// Aliens
		for (Alien alien : aliens) {
			int x = alien.getX();

			if (x >= 640 - alien.getImage().getWidth(null) && direction != -1) {
				direction = -1;
				Iterator<Alien> i1 = aliens.iterator();

				while (i1.hasNext()) {
					Alien a2 = i1.next();
					a2.setY(a2.getY() + 15);
				}
			}
			if (x <= 5 && direction != 1) {
				direction = 1;
				Iterator<Alien> i2 = aliens.iterator();
				while (i2.hasNext()) {
					Alien a = i2.next();
					a.setY(a.getY() + 15);
				}
			}
		}

		Iterator<Alien> it = aliens.iterator();
		while (it.hasNext()) {
			Alien alien = it.next();
			if (alien.isVisible()) {
				int y = alien.getY();

				if (y > 290 - 12) {
					inGame = false;
				}
				alien.move(direction);
			}
		}

		// PlayerMissile
		if (player.getMissile().isVisible()) {
			int missileX = player.getMissile().getX();
			int missileY = player.getMissile().getY();
			for (Alien alien : aliens) {
				int alienX = alien.getX();
				int alienY = alien.getY();

				if (alien.isVisible() && player.getMissile().isVisible()) {

					if (missileX >= (alienX) && missileX <= (alienX + alien.getImage().getWidth(null))
							&& missileY >= (alienY) && missileY <= (alienY + alien.getImage().getHeight(null))) {
						alien.setDead(true);
						remainingAliens--;
						player.getMissile().die();
					}
				}
			}
			int y = player.getMissile().getY();
			y -= 4;
			if (y < 0) {
				player.getMissile().die();
			} else {
				player.getMissile().setY(y);
			}
		}

		// AlienMissile
		Random random = new Random();
		for (Alien alien : aliens) {

			int num = random.nextInt(2000);
			if (num == 5 && alien.isVisible() && !alien.getMissile().isVisible()) {

				alien.getMissile().setVisible(true);
				alien.getMissile().setX(alien.getX());
				alien.getMissile().setY(alien.getY());

			}
			int missileX = alien.getMissile().getX();
			int missileY = alien.getMissile().getY();
			int playerX = player.getX();
			int playerY = player.getY();

			if (player.isVisible() && alien.getMissile().isVisible()) {
				if (missileX >= (playerX) && missileX <= (playerX + player.getImage().getWidth(null))
						&& missileY >= (playerY) && missileY <= (playerY + player.getImage().getHeight(null))) {
					player.setDead(true);
					alien.getMissile().setVisible(false);
				}
			}

			if (alien.getMissile().isVisible()) {
				alien.getMissile().setY(alien.getMissile().getY() + 1);

				if (alien.getMissile().getY() >= 480 - alien.getMissile().getImage().getHeight(null)) {

					alien.getMissile().setVisible(false);
				}
			}
		}
	}

	private void doGameCycle() {

		update();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		doGameCycle();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	private void draw(Graphics g) {
		g.setColor(Color.green);

		if (inGame) {
			g.drawLine(0, 418, 640, 418);
			drawAliens(g);
			drawPlayer(g);
			drawPlayerMissile(g);
			drawAlienMissile(g);
		} else {
			if (timer.isRunning()) {
				timer.stop();
			}
			endGame(g);
		}
	}

	private void endGame(Graphics g) {
		g.setColor(Color.white);
		g.drawString(gameEndText, 290, 210);
	}
}
