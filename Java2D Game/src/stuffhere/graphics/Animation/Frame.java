package stuffhere.graphics.Animation;

import stuffhere.graphics.Sprite;
import stuffhere.util.ResourceManager;

public class Frame {

	private Sprite sprite;
	private int duration;
	
	public Frame(String path, int duration) {
		this.sprite = new ResourceManager().getSprite(path);
		this.duration = duration;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public int getDuration() {
		return duration;
	}

}
