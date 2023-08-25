package entity.counter;

import entity.base.Choppable;
import entity.base.Ingredient;
import logic.Player;

public class ChoppingBoard extends Counter{
	public ChoppingBoard() {
		super("Chopping Board");
	}
	public void interact(Player p) {
		if(!this.isPlacedContentEmpty()) {
			super.interact(p);
			return;
		}
		if(p.getHoldingItem() instanceof Ingredient) {
			Ingredient i = (Ingredient) p.getHoldingItem();
			if(i instanceof Choppable)
				((Choppable) i).chop();
			super.interact(p);
			
		}
	}
}
