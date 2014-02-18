package stuffhere;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import stuffhere.gameState.GameStateManager;
import stuffhere.input.Keyboard;
import stuffhere.input.Mouse;

@SuppressWarnings("serial")

public class Game extends Canvas implements Runnable {

	// TILE SIZE
	public static int TILE_SIZE = 48;
	
	// Dimensions
	public static final int WIDTH = 1080;
	public static final int HEIGHT = WIDTH / 16 * 9; // ca 608

	// Game thread
	private Thread thread;
	private boolean gameRunning = false;
	
	// GMS
	private GameStateManager gsm;
	
	// Timer 
	private long lastTime = 0;
	private long timer = 0;
	private final double ns = 1000000000.0 / 60.0;
	private double delta = 0;
	private int frames = 0;
	private int updates = 0;

	// BufferStrategy
	private BufferStrategy strategy;

	// Frame
	private static JFrame frame;
	
	// Player Input
	private Keyboard key;
	private Mouse mouse;
	
	public Game() {

		// Set frame properties
		frame = new JFrame("Towni0s paradise");
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.add(this);
		frame.setIgnoreRepaint(true);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		requestFocus();

		// Creates the buffer strategy
		createBufferStrategy(3);
		strategy = getBufferStrategy();
		
		// Initialize the Input
		key = new Keyboard();
		mouse = new Mouse();
		
		// Add listeners
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		addKeyListener(key);

		// GameStateManager
		gsm = new GameStateManager();

	}

	public synchronized void stop() {
		gameRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void start() {
		gameRunning = true;
		thread = new Thread(this, "DisplayThread");
		thread.start();
	}

	public void run() {
		// Initialize the timing variables
		initTiming();

		// GameLoop
		while (gameRunning) {

			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			// Makes sure that we don't update faster than 60 time/s
			while (delta >= 1) {
				update(key, mouse);
				updates++;
				delta--;
			}

			// Get graphics from the strategy we created
			Graphics2D g2 = (Graphics2D) strategy.getDrawGraphics();
			
			// Clear the screen
			clearScreen(g2);

			// Render
			render(g2);

			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle("Project X - 2D," + updates + " ups, " + frames
						+ " fps");
				updates = 0;
				frames = 0;
			}

			g2.dispose();
			strategy.show();
		}

	}

	private void clearScreen(Graphics2D g2) {
		g2.setColor(Color.black);
		g2.fillRect(0, 0, WIDTH, HEIGHT);
	}
	
	// Render stuff goes here
	public void render(Graphics2D g2) {
		gsm.render(g2);
	}

	// update stuff goes here
	public void update(Keyboard key, Mouse mouse) {
		gsm.update(key, mouse);
	}

	public void initTiming() {
		lastTime = System.nanoTime();
		timer = System.currentTimeMillis();
		delta = 0;
		frames = 0;
		updates = 0;
	}

	public static void main(String[] args) {
		
		// Start the game
		new Game().start();
	}

}