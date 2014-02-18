package stuffhere.util;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import stuffhere.graphics.Sprite;

public class ResourceManager {

	private HashMap<String, Sprite> sprites = new HashMap<>();

	public static ResourceManager rm = new ResourceManager();

	public ResourceManager() {

	}

	public Sprite getSprite(String path) {

		// if we've already got the sprite in the cache
		// then just return the existing version
		if (sprites.get(path) != null) {
			System.out.println("There was a srpite ready" );
			return (Sprite) sprites.get(path);
		}

		// otherwise, go away and grab the sprite from the resource
		// loader
		BufferedImage sourceImage = null;

		try {
			sourceImage = ImageIO.read(getClass().getResource(path));
			

		} catch (IOException e) {
			System.out.println("Failed to load: " + path);
			e.printStackTrace();
		}

		// create an accelerated image of the right size to store our sprite in
		GraphicsConfiguration gc = GraphicsEnvironment
				.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();
		Image image = gc.createCompatibleImage(sourceImage.getWidth(),
				sourceImage.getHeight(), Transparency.BITMASK);

		// draw our source image into the accelerated image
		image.getGraphics().drawImage(sourceImage, 0, 0, null);

		// create a sprite, add it the cache then return it
		Sprite sprite = new Sprite(image);
		sprites.put(path, sprite);

		return sprite;
	}
	
	
	
	

}
