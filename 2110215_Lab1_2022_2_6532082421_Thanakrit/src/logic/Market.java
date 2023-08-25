package logic;

import java.util.ArrayList;

public class Market {

	// fields
	ArrayList<Item> allItems;

	// constructors
	public Market() {
		this.setAllItems(new ArrayList<Item>());
	}

	public Market(ArrayList<Item> items) {
		this.setAllItems(new ArrayList<Item>());
		this.addAllItems(items);
	}

	// methods
	public String toString() {
		String out = "\n";
		for (int i = 0; i < allItems.size(); i++) {
			out += i + 1;
			out += ". ";
			out += allItems.get(i).toString();
			out += "\n";
		}
		return out;
	}

	//"ItemName" is duplicated, Item will not be added
	//"ItemName $Price" Added to the market.
	public boolean ExistingItem(Item item) {
		for(int i=0;i<this.allItems.size();i++){
			if(this.allItems.get(i).equals(item)) {
				return true;
			}
		}
		return false;
	}
	
	
	public void addAllItems(ArrayList<Item> items) {
		if(items == null){
			return;
		}
		for(int i=0;i<items.size();i++) {
			if(ExistingItem(items.get(i))) {
				System.out.println("\""+items.get(i).getItemName()+"\" is duplicated, Item will not be added.");		
			}
			else {				
				this.allItems.add(items.get(i));
				System.out.println("\"" + items.get(i).toString() + "\" Added to the market.");
			}
		}
	}

	//getter setters 
	public ArrayList<Item> getAllItems(){
		return this.allItems;
	}
	public void setAllItems(ArrayList<Item> items){
		this.allItems = items;
	}


}
