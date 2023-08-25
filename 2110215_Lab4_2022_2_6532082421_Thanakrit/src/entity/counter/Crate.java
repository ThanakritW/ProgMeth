package entity.counter;

import logic.InvalidIngredientException;
import logic.LogicUtil;
import logic.Player;

public class Crate extends Counter{
	private String myIngredient;
	public Crate(String s) {
		super(s+" Crate");
		this.setMyIngredients(s);
	}
	public String getMyIngredient() {
		return myIngredient;
	}
	public void setMyIngredients(String myIngredients) {
		this.myIngredient = myIngredients;
	}
	public void interact(Player p){
		if(!p.isHandEmpty() || !this.isPlacedContentEmpty()) {
			super.interact(p);
			return;
		}
		try {
			p.setHoldingItem(LogicUtil.createIngredientFromName(myIngredient));
		} catch (InvalidIngredientException e) {
			p.setHoldingItem(null);
		}
	}
}
