package logic;

public class ItemCounter {
	private Item item;
	private int amount;

	// constructor
	public ItemCounter(Item item){
		this.setItem(item);
		this.setCount(1);
		
	}

	public ItemCounter(Item item, int count){
		this.setItem(item);
		if(count < 1) {
			count = 1;
		}
		this.setCount(count);
	}

	// methods
	public String toString() {
		//FILL CODE
		return this.getItem() + " x" + this.getCount();
	}

	// getter & setter
	public Item getItem() {
		return this.item;
	}
	
	public void setItem(Item item){
		this.item = item;
	}

	public int getCount() {
		return this.amount;
	}

	public void setCount(int count) {
		if(count < 0) {
			count = 0;
		}
		this.amount = count;
	}
}
