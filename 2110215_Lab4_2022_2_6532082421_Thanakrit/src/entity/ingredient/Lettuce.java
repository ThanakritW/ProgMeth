package entity.ingredient;

import entity.base.Choppable;
import entity.base.Ingredient;

public class Lettuce extends Ingredient implements Choppable {

	private boolean chopState;
	public Lettuce() {
		super("Lettuce");
		this.setEdible(true);
		this.setChopState(false);
	}
	
	@Override
	public void chop() {
		if(this.isChopped())
			return;
		this.setChopState(true);
		this.setName("Chopped Lettuce");
	}

	@Override
	public boolean isChopped() {
		return this.chopState;
	}

	public void setChopState(boolean chopState) {
		this.chopState = chopState;
	}
	

}
