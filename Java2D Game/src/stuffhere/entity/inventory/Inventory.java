package stuffhere.entity.inventory;

import stuffhere.entity.inventory.items.EmptyItem;
import stuffhere.entity.inventory.items.Item;
import stuffhere.graphics.Sprite;

public class Inventory {

	private int inventorySize;
	// Use an array instead of arraylist because we can't expand the inventory
	private Item[] items;
	private int availableSlot;
	private boolean hasChanged = false;

	public Inventory(int size) {
		this.inventorySize = size;
		items = initItems();
	}

	private Item[] initItems() {
		Item emptyItem = new EmptyItem("Empty", "/HUD/empty.png");

		Item[] tempArray = new Item[getInventorySize()];
		for (int i = 0; i < getInventorySize(); i++) {
			tempArray[i] = emptyItem;
		}
		return tempArray;
	}

	private boolean findAvailableSlot() {
		for (int i = 0; i < getInventorySize(); i++) {
			if (items[i] instanceof EmptyItem) {
				availableSlot = i;
				return true;
			}
		}
		return false;
	}

	// Returns the sprites that will be used in the inventory
	public Sprite[] getInventoryItemSprites() {
		Sprite[] tempArray = new Sprite[getInventorySize()];
		for (int i = 0; i < getInventorySize(); i++) {
			if (getItem(i) != null)
				tempArray[i] = getItem(i).getInvSprite();
		}
		return tempArray;

	}

	public void insertItem(Item i) {
		if (findAvailableSlot()) {
			items[availableSlot] = i;
			setHasChanged(true);
		} else
			System.out.println("Inventory is full");
	}

	public void removeItem(int i) {
		if (i < getInventorySize()) {
			items[i] = null;
			setHasChanged(true);
		}
	}

	public void setInventorySize(int size) {
		Inventory temp = new Inventory(size);
		Item[] tempArray = temp.getItems();

		// Check if the new inventory is larger than the old one
		if (size > getInventorySize()) {
			for (int i = 0; i < getInventorySize(); i++) {
				tempArray[i] = getItemAtPos(i);
			}
			inventorySize = size;
			items  = initItems();
			setItems(tempArray);
		}
	}

	private void setItems(Item[] items) {
		this.items = items;
	}

	public Item[] getItems() {
		return items;
	}

	public Item getItem(int i) {
		return items[i];
	}

	public int getInventorySize() {
		return inventorySize;
	}

	private Item getItemAtPos(int pos) {
		return items[pos];
	}

	public boolean isHasChanged() {
		return hasChanged;
	}

	public void setHasChanged(boolean hasChanged) {
		this.hasChanged = hasChanged;
	}
}
