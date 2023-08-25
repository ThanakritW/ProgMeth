package entity.counter;

import entity.base.Item;
import entity.base.Updatable;
import entity.container.Pan;
import logic.Player;

public class Stove extends Counter implements Updatable{
	public Stove() {
		super("Stove");
	}
	public Stove(Item content) {
		super("Stove");
		this.setPlacedContent(content);
	}
	public void interact(Player p) {
		if(!this.isPlacedContentEmpty() || (p.getHoldingItem() instanceof Pan)) {
			super.interact(p);
		}
	}
	public void update() {
		if(this.getPlacedContent() instanceof Pan) {
			((Pan)this.getPlacedContent()).cook();
		}
	}
}
