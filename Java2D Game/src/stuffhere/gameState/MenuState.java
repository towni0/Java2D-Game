package stuffhere.gameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import stuffhere.Game;
import stuffhere.input.Keyboard;
import stuffhere.input.Mouse;
import stuffhere.util.ResourceManager;

public class MenuState extends GameState {

	private BufferedImage background;
	
	private int currentChoice = 0;

	private String[] options = { "Start", "Help", "Quit" };

	private Color normalColor;
	private Color selectedColor;
	private Font normalFont;
	private Font selectedFont;

	public MenuState(GameStateManager gsm) {
		this.gsm = gsm;
		init();
	}

	public void init() {
		background = new ResourceManager().getSprite("/menu/background2.png").getImage();
		
		normalColor = Color.RED;
		normalFont = new Font("Verdana", Font.BOLD, 30);
		
		selectedColor = Color.BLACK;
		selectedFont = new Font("Verdana", Font.BOLD, 40);
	}

	public void update(Keyboard key, Mouse mouse) {
		key.update();

		if (key.esc) {
			System.out.println("User pressed ESC, exiting program");
			System.exit(0);
		}
		
		if (key.up) currentChoice -= 1;
		if (currentChoice >= options.length) currentChoice = 0;
		
		if (key.down) currentChoice += 1;
		if (currentChoice < 0) currentChoice = options.length - 1;
		
		if (key.enter) select();
		
	}

	public void render(Graphics2D g2) {
		// Draw background
		g2.drawImage(background, 0, 0, 1080, 608, null);
		
		// Draw menu options
		g2.setFont(normalFont);
		for (int i = 0; i < options.length; i++) {
			if (i == currentChoice) {
				g2.setColor(selectedColor);
				g2.setFont(selectedFont);

			} else {
				g2.setColor(normalColor);
				g2.setFont(normalFont);
			}
			g2.drawString(options[i], Game.WIDTH / 2 - 30, (Game.HEIGHT / 2 - 150 + i * 40) );
		}

	}

	private void select() {
		if (currentChoice == 0) {
			System.out.println("Start game");
			gsm.setState(GameStateManager.PLAYSTATE);
		}
		
		if (currentChoice == 1) {
			System.out.println("Help");
			gsm.setState(GameStateManager.HELPSTATE);
		}
		
		if (currentChoice == 2) {
			System.out.println("Exit Game");
			System.exit(0);
		}
	}


}
