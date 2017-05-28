package Game;

import java.awt.Canvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Core of the Game. Draws the (fantastic) graphics.
 * 
 * @author Bencs Dániel
 *
 */
public class Draw {
	JFrame frame;
	Canvas canvas;
	MapHandler currentMap = Game.Instances.Map1;

	BufferStrategy bufferStrategy;

	/**
	 * The width of the game window.
	 */
	private int WIDTH = 640;
	/**
	 * The height of the game window.
	 */
	private int HEIGHT = 640;

	/**
	 * The amout between sprites.
	 */
	int dx = 63;

	/**
	 * Initializing the window and canvas.
	 */
	Draw() {

		frame = new JFrame("Basic Game");
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		panel.setLayout(null);

		canvas = new Canvas();
		canvas.setBounds(0, 0, WIDTH, HEIGHT);
		canvas.setIgnoreRepaint(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();

		frame.setResizable(false);
		frame.setVisible(true);

		panel.add(canvas);
		canvas.createBufferStrategy(2);
		bufferStrategy = canvas.getBufferStrategy();

		canvas.requestFocus();

		canvas.setBackground(Color.black);

		/**
		 * The calling of controller system(keyboard).
		 */
		canvas.addKeyListener(new ButtonHandler());
		/**
		 * The calling of controller system(mouse).
		 */
		canvas.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				 System.out.println("x = " + e.getX() + "/ y = " + e.getY());
				if (e.getX() >= 130 && e.getY() > 100 && e.getX() <= 530 && e.getY() <= 155 && Game.menustatus) {
					Game.menustatus = false;
					Game.Instances.player = new Player();
					Game.Instances.currentMap = Game.Instances.Falucska2;
				}
				if (e.getX() >= 130 && e.getY() > 200 && e.getX() <= 540 && e.getY() <= 255 && Game.menustatus) {
					DAO.saveGamePlay();

				}
				if (e.getX() >= 130 && e.getY() > 300 && e.getX() <= 550 && e.getY() <= 355 && Game.menustatus) {
					DAO.loadGamePlay();
					Game.menustatus = false;
				}
				if (e.getX() >= 130 && e.getY() > 400 && e.getX() <= 310 && e.getY() <= 455 && Game.menustatus) {
					System.exit(0);
				}
			}
		});

	}

	void render() {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);
		if (!Game.menustatus) {
			render(g);
		} else {
			render_menu(g);
		}
		g.dispose();
		bufferStrategy.show();
	}

	private void render_menu(Graphics2D g) {
		try {
			g.drawImage(ImageIO.read(this.getClass().getResource("/Images/background.png")), 0, 0, WIDTH, HEIGHT, null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Font font = new Font("century", Font.PLAIN, 64);
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString("NEW GAME", 140, 150);

		g.setFont(font);
		g.setColor(Color.black);
		g.drawString("SAVE GAME", 140, 250);

		g.setFont(font);
		g.setColor(Color.black);
		g.drawString("LOAD GAME", 140, 350);

		g.setFont(font);
		g.setColor(Color.black);
		g.drawString("EXIT", 140, 450);

	}

	void render_init_playerstat() {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);
		render_playerstat(g);
		g.dispose();
		bufferStrategy.show();
	}

	private void render_playerstat(Graphics2D g) {
		try {
			g.drawImage(ImageIO.read(this.getClass().getResource("/Images/background.png")), 0, 0, WIDTH, HEIGHT, null);

			Font font = new Font("Serif", Font.PLAIN, 96);
			g.setFont(font);
			g.setColor(Color.GRAY);
			g.drawString("Nealder", 150, 130);

			g.drawImage(ImageIO.read(Game.Instances.player.moveDownSprite), 280, 0, 350, 70, 0, 0, 70, 70, null);

			font = new Font("Serif", Font.PLAIN, 22);
			g.setFont(font);
			g.drawString("Life", 50, 190);
			g.drawString(":", 150, 190);
			g.drawString(new Integer(Game.Instances.player.getLife()).toString() + " / "
					+ Game.Instances.player.getCurrentLife(), 165, 192);
			g.drawString("Strength", 50, 220);
			g.drawString(":", 150, 220);
			g.drawString(new Integer(Game.Instances.player.getStrength()).toString(), 165, 222);
			g.drawString("Stamina", 50, 250);
			g.drawString(":", 150, 250);
			g.drawString(new Integer(Game.Instances.player.getStamina()).toString(), 165, 252);
			g.drawString("Magic", 50, 280);
			g.drawString(":", 150, 280);
			g.drawString(new Integer(Game.Instances.player.getMagic()).toString(), 165, 282);

			g.drawString("Armor", 50, 340);
			g.drawString(":", 190, 340);
			g.drawString(new Integer(Game.Instances.player.getMagic()).toString(), 205, 342);
			g.drawString("Critical chance", 50, 370);
			g.drawString(":", 190, 370);
			g.drawString(new Float(Game.Instances.player.getCritical_chance() * 100).toString(), 205, 372);
			g.drawString("%", 260, 372);
			g.drawString("Critical damage", 50, 400);
			g.drawString(":", 190, 400);
			g.drawString(new Float(Game.Instances.player.getCritical_dmg() * 100).toString(), 205, 402);
			g.drawString("%", 260, 402);

			g.drawImage(ImageIO.read(this.getClass().getResource("/Images/inventory.png")), 50, 450, 387, 159, null);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void render_init_interactionNPC(NPC npc) {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);
		render_interactionNPC(g, npc);
		g.dispose();
		bufferStrategy.show();
	}

	private void render_interactionNPC(Graphics2D g, NPC npc) {
		try {
			g.drawImage(ImageIO.read(Game.Instances.currentMap.mapImageGround), 0, 0, null);
			g.drawImage(ImageIO.read(Game.Instances.player.moveDownSprite), (int) Game.Instances.player.getX(),
					(int) Game.Instances.player.getY(), (int) Game.Instances.player.getX() + 70,
					(int) Game.Instances.player.getY() + 70, 0, 0, 70, 70, null);
			g.drawImage(ImageIO.read(this.getClass().getResource("/Images/background.png")), 100, 100, 440, 440, null);

			Font font = new Font("Serif", Font.PLAIN, 22);
			g.setFont(font);
			g.setColor(Color.BLACK);
			g.drawString(Game.Instances.food_potion_vendor.dialog, 235, 170);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	protected void render(Graphics2D g) {
		try {
			g.drawImage(ImageIO.read(Game.Instances.currentMap.mapImageGround), 0, 0, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (Game.Instances.player.getRight()) {
			try {
				g.drawImage(ImageIO.read(Game.Instances.player.moveRightSprite), (int) Game.Instances.player.getX(),
						(int) Game.Instances.player.getY(), (int) Game.Instances.player.getX() + 70,
						(int) Game.Instances.player.getY() + 70, 0 + dx * Game.Instances.player.sprite_i, 0,
						dx + dx * Game.Instances.player.sprite_i, 70, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (Game.Instances.player.getLeft()) {
			try {
				g.drawImage(ImageIO.read(Game.Instances.player.moveLeftSprite), (int) Game.Instances.player.getX(),
						(int) Game.Instances.player.getY(), (int) Game.Instances.player.getX() + 70,
						(int) Game.Instances.player.getY() + 70, 0 + dx * Game.Instances.player.sprite_i, 0,
						dx + dx * Game.Instances.player.sprite_i, 70, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (Game.Instances.player.getUp()) {
			try {
				g.drawImage(ImageIO.read(Game.Instances.player.moveUpSprite), (int) Game.Instances.player.getX(),
						(int) Game.Instances.player.getY(), (int) Game.Instances.player.getX() + 70,
						(int) Game.Instances.player.getY() + 70, 0 + dx * Game.Instances.player.sprite_i, 0,
						dx + dx * Game.Instances.player.sprite_i, 70, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (Game.Instances.player.getDown()) {
			try {
				g.drawImage(ImageIO.read(Game.Instances.player.moveDownSprite), (int) Game.Instances.player.getX(),
						(int) Game.Instances.player.getY(), (int) Game.Instances.player.getX() + 70,
						(int) Game.Instances.player.getY() + 70, 0 + dx * Game.Instances.player.sprite_i, 0,
						dx + dx * Game.Instances.player.sprite_i, 70, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
			try {
				g.drawImage(ImageIO.read(Game.Instances.player.moveDownSprite), (int) Game.Instances.player.getX(),
						(int) Game.Instances.player.getY(), (int) Game.Instances.player.getX() + 70,
						(int) Game.Instances.player.getY() + 70, 0, 0, 70, 70, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			g.drawImage(ImageIO.read(Game.Instances.currentMap.mapImageObjects), 0, 0, null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (Game.Instances.player.getInventoryStatus() == true) {
			render_init_playerstat();
		}
		if (Game.Instances.food_potion_vendor.getInteractionStatus() == true) {
			render_init_interactionNPC(Game.Instances.food_potion_vendor);
		}

		if (Game.Instances.currentMap.mapImageGround.equals(Game.Instances.Falucska2.mapImageGround)
				&& !Game.Instances.player.getInventoryStatus()) {
			try {
				g.drawImage(ImageIO.read(Game.Instances.food_potion_vendor.imageNPC),
						Game.Instances.food_potion_vendor.x, Game.Instances.food_potion_vendor.y,
						Game.Instances.food_potion_vendor.x + 70, Game.Instances.food_potion_vendor.y + 70, 0, 0, 75,
						65, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		g.setColor(Color.red);
		g.drawRect((int) Game.Instances.player.collisionTest.getX(), (int) Game.Instances.player.collisionTest.getY(),
				(int) Game.Instances.player.collisionTest.getWidth(),
				(int) Game.Instances.player.collisionTest.getHeight());
		if (Game.Instances.currentMap == Game.Instances.Falucska2) {
			g.setColor(Color.blue);
			g.drawRect(Game.Instances.food_potion_vendor.x, Game.Instances.food_potion_vendor.y,
					Game.Instances.food_potion_vendor.width, Game.Instances.food_potion_vendor.height);
		}

		g.setColor(Color.red);
		for (Rectangle rec : Game.Instances.currentMap.unpassableRectangle) {
			g.drawRect((int) rec.x, (int) rec.y, (int) rec.getWidth(), (int) rec.getHeight());
		}

	}

}

/*
 * 
 * boolean Graphics.drawImage(Image img, int dstx1, int dsty1, int dstx2, int
 * dsty2, int srcx1, int srcy1, int srcx2, int srcy2, ImageObserver observer);
 */
