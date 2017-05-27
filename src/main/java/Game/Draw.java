package Game;

import java.awt.Canvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Spring;

public class Draw {
	JFrame frame;
	Canvas canvas;
	String currentMapGround = Instances.Map1.mapImageGround;
	String currentMapObjects = Instances.Map1.mapImageObjects;
	MapHandler currentMap = Instances.Map1;

	BufferStrategy bufferStrategy;

	private int WIDTH = 640;
	private int HEIGHT = 640;

	int dx = 63;

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

		canvas.addKeyListener(new ButtonHandler());
	}

	void render() {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);
		render(g);
		g.dispose();
		bufferStrategy.show();
	}

	void render_init_combat() {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);
		render_combat(g);
		g.dispose();
		bufferStrategy.show();
	}

	private void render_combat(Graphics2D g) {
		try {
			g.drawImage(ImageIO.read(new File("src/main/resources/Images/background.png")), 0, 0, WIDTH, HEIGHT, null);
			g.setColor(Color.GREEN);
			g.drawRect(40, 40, 200, 20);
			g.fillRect(40, 40, 200 * Instances.player.getLife() / Instances.player.getCurrentLife(), 20);
			JPanel panel = new JPanel();
			JLabel jlabel = new JLabel();
			panel.add(jlabel);
			jlabel.setText(new Float(Instances.player.getX()).toString());

			jlabel.setFont(new Font("Verdana", 1, 20));
			jlabel.setBounds(260, 40, 50, 30);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	protected void render(Graphics2D g) {
		try {
			g.drawImage(ImageIO.read(new File(Instances.currentMap.mapImageGround)), 0, 0, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (Instances.player.right == true) {
			try {
				g.drawImage(ImageIO.read(new File("src/main/resources/Images/MoveRightSprite.png")),
						(int) Instances.player.getX(), (int) Instances.player.getY(),
						(int) Instances.player.getX() + 70, (int) Instances.player.getY() + 70,
						0 + dx * Instances.player.sprite_i, 0, dx + dx * Instances.player.sprite_i, 70, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (Instances.player.left == true) {
			try {
				g.drawImage(ImageIO.read(new File("src/main/resources/Images/MoveLeftSprite.png")),
						(int) Instances.player.getX(), (int) Instances.player.getY(),
						(int) Instances.player.getX() + 70, (int) Instances.player.getY() + 70,
						0 + dx * Instances.player.sprite_i, 0, dx + dx * Instances.player.sprite_i, 70, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (Instances.player.up == true) {
			try {
				g.drawImage(ImageIO.read(new File("src/main/resources/Images/MoveUpSprite.png")),
						(int) Instances.player.getX(), (int) Instances.player.getY(),
						(int) Instances.player.getX() + 70, (int) Instances.player.getY() + 70,
						0 + dx * Instances.player.sprite_i, 0, dx + dx * Instances.player.sprite_i, 70, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (Instances.player.down == true) {
			try {
				g.drawImage(ImageIO.read(new File("src/main/resources/Images/MoveDownSprite.png")),
						(int) Instances.player.getX(), (int) Instances.player.getY(),
						(int) Instances.player.getX() + 70, (int) Instances.player.getY() + 70,
						0 + dx * Instances.player.sprite_i, 0, dx + dx * Instances.player.sprite_i, 70, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
			try {
				g.drawImage(ImageIO.read(new File("src/main/resources/Images/MoveDownSprite.png")),
						(int) Instances.player.getX(), (int) Instances.player.getY(),
						(int) Instances.player.getX() + 70, (int) Instances.player.getY() + 70, 0, 0, 70, 70, null);
			} catch (IOException e) {
				e.printStackTrace();
			}

		if (Instances.player.getInventoryStatus() == true) {
			render_init_combat();
		}

		if (currentMapGround.equals(Instances.Falucska2.mapImageGround)) {
			try {
				g.drawImage(ImageIO.read(new File("src/main/resources/Images/food&Potion_vendor_onesprite.png")), 550,
						70, 625, 135, 0, 0, 75, 65, null);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		g.setColor(Color.red);
		g.drawRect((int) Instances.player.collisionTest.getX(), (int) Instances.player.collisionTest.getY(),
				(int) Instances.player.collisionTest.getWidth(), (int) Instances.player.collisionTest.getHeight());

		for (Rectangle rec : Instances.currentMap.unpassableRectangle) {
			g.drawRect((int) rec.x, (int) rec.y, (int) rec.getWidth(), (int) rec.getHeight());
		}

	}

}

/*
 * 
 * boolean Graphics.drawImage(Image img, int dstx1, int dsty1, int dstx2, int
 * dsty2, int srcx1, int srcy1, int srcx2, int srcy2, ImageObserver observer);
 */
