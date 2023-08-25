package entity.ingredient;

import entity.base.Choppable;
import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Meat extends Ingredient implements Choppable, Cookable {

	private boolean chopState;
	private int cookedPercentage;
	
	public Meat() {
		super("Meat");
		this.setChopState(false);
	}	
	
	@Override
	public void cook() {
		if(this.isChopped()) {
			this.setCookedPercentage(this.getCookedPercentage()+15);
			if(this.getCookedPercentage() <=80) {
				this.setName("Raw Burger");
				this.setEdible(false);
			}
			else if(this.getCookedPercentage() <=100) {
				this.setName("Cooked Burger");
				this.setEdible(true);
			}
			else{
				this.setName("Burnt Burger");
				this.setEdible(false);
			}
		}
		else {	
			this.setCookedPercentage(this.getCookedPercentage()+10);
			if(this.getCookedPercentage() <=50) {
				this.setName("Raw Meat");
				this.setEdible(false);
			}
			else if(this.getCookedPercentage() <=80) {
				this.setName("Medium Rare Steak");
				this.setEdible(true);
			}
			else if(this.getCookedPercentage() <=100) {
				this.setName("Well Done Steak");
				this.setEdible(true);
			}
			else{
				this.setName("Burnt Steak");
				this.setEdible(false);
			}
		}
	}

	@Override
	public boolean isBurnt() {
		return this.getCookedPercentage()>100;
	}

	@Override
	public void chop() {
		if(this.isChopped() || this.getCookedPercentage()>0)
			return;
		this.setName("Minced Meat");
		this.setChopState(true);
	}

	public String toString() {
		return StringUtil.formatNamePercentage(this.getName(), this.getCookedPercentage());
	}
	
	@Override
	public boolean isChopped() {
		return this.chopState;
	}
	
	public void setChopState(boolean chopState) {
		this.chopState = chopState;
	}


	public int getCookedPercentage() {
		return cookedPercentage;
	}


	public void setCookedPercentage(int cookedPercentage) {
		this.cookedPercentage = cookedPercentage;
	}

	
	

}
