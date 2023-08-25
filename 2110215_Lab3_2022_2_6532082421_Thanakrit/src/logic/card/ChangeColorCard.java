package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

import java.util.ArrayList;

//You CAN modify the first line
public class ChangeColorCard extends EffectCard{
    // TODO Implement here
	public ChangeColorCard() {
		super(null, CardSymbol.CHANGE_COLOR);	
	}
	
	public String toString() {
		String cardName = this.getSymbol().toString();
		if(this.getColor() == null)
			return cardName;
		return cardName+" (" +this.getColor()+" color selected)";
	}
	
	public boolean canPlay() {
		return true;
	}
	
	public String performEffect() {
		ArrayList<BaseCard> currentHand= GameLogic.getInstance().getCurrentPlayerHand();
		if(currentHand.isEmpty()) {
			this.setColor(CardColor.RED);
		}
		else {
			this.setColor(currentHand.get(0).getColor());
			if(this.getColor()==null)
				this.setColor(CardColor.RED);
		}
		return "Set color to " + this.getColor();
	}
	
}
