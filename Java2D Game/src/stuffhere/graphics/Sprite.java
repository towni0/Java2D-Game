package stuffhere.graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class Sprite {
	
	private BufferedImage image;

	public Sprite(Image i) {
		this.image = (BufferedImage) i;
	}
	
	public BufferedImage getImage() {
		return image;
	}
}
