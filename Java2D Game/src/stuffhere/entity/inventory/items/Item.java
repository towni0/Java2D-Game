package stuffhere.entity.inventory.items;

import stuffhere.graphics.Sprite;
import stuffhere.util.ResourceManager;

public class Item {
	
	protected String name;
	protected String invPath;
	protected Sprite invSprite;

	// First path in parhArray must be the inventory picture.
	public Item(String name, String path) {
		this.name = name;
		this.invPath = path;
		loadSprite();
	}

	private void loadSprite() {
		invSprite = new ResourceManager().getSprite(invPath);
	}

	public String getName() {
		return name;
	}

	public Sprite getInvSprite() {
		return invSprite;
	}

}
