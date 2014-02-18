package stuffhere.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
public static final int NUM_KEYS = 200;
	
	private boolean[] keys = new boolean[NUM_KEYS];
	public boolean up, down, left, right, space, esc, inv, menu, back, enter;


	public void update() {
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		space = keys[KeyEvent.VK_SPACE];
		esc = keys[KeyEvent.VK_ESCAPE];
		inv = keys[KeyEvent.VK_I];
		menu = keys[KeyEvent.VK_M];
		back = keys[KeyEvent.VK_B];
		enter = keys[KeyEvent.VK_ENTER];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
