package logic;

import exception.NameBlankException;

public class Item {

	private String itemName;
	private int price;

	// constructor
	public Item(String itemName) throws NameBlankException {
		if(itemName.isBlank()) {
			throw new NameBlankException();
		}
		this.setItemName(itemName);
		this.setPrice(0);
		
	}

	public Item(String itemName, int price) throws NameBlankException{
		if(itemName.isBlank()) {
			throw new NameBlankException();
		}
		this.setItemName(itemName);
		this.setPrice(price);
	}

	// methods
	public boolean equals(Item other) {
		return this.itemName.equals(other.itemName);
	}

	public String toString() {
		//FILL CODE
		return this.getItemName() + " $" + this.getPrice();
	}

	// getter & setter
	public String getItemName() {
		//FILL CODE
		return this.itemName;
	}

	public void setItemName(String itemName) throws NameBlankException {
		if(itemName.isBlank()) {
			throw new NameBlankException();
		}
		this.itemName = itemName;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		if(price < 0) {
			price = 0;
		}
		this.price = price;
	}

}
