package entity.ingredient;

import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Egg extends Ingredient implements Cookable {

	private int cookedPercentage;
	
	public Egg() {
		super("Egg");
		this.setCookedPercentage(0);
	}
	
	@Override
	public void cook() {
		this.setCookedPercentage(this.getCookedPercentage()+12);
		if(this.getCookedPercentage() <=50) {
			this.setName("Raw Egg");
			this.setEdible(false);
		}
		else if(this.getCookedPercentage() <=80) {
			this.setName("Sunny Side Egg");
			this.setEdible(true);
		}
		else if(this.getCookedPercentage() <=100) {
			this.setName("Fried Egg");
			this.setEdible(true);
		}
		else{
			this.setName("Burnt Egg");
			this.setEdible(false);
		}
	}
	
	public boolean isBurnt() {
		if(this.getCookedPercentage() > 100)
			return true;
		return false;
	}
	
	public String toString() {
		return StringUtil.formatNamePercentage(this.getName(), this.getCookedPercentage());
 	}

	public int getCookedPercentage() {
		return cookedPercentage;
	}

	public void setCookedPercentage(int cookedPercentage) {
		this.cookedPercentage = cookedPercentage;
	}

	
}
