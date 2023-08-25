package logic.card;

import logic.game.CardSymbol;
import logic.game.CardColor;
import logic.game.GameLogic;

//You CAN modify the first line
public class NumberCard extends BaseCard{
    // TODO Implement here
	public NumberCard(CardColor color, CardSymbol symbol) {
		super(color,symbol);
	}
	
	public String toString() {
		return this.getColor().toString() + " " + this.getSymbol().toString();
	}
	
	public boolean canPlay() {
		GameLogic now = GameLogic.getInstance();
		BaseCard topCard = now.getTopCard();
		if(this.getColor() == topCard.getColor()){
			return true;
		}
		if(this.getSymbol() == topCard.getSymbol()) {
			return true;
		}
		return false;
	}
	public String play() {
		GameLogic.getInstance().getCurrentPlayerHand().remove(this);
		GameLogic.getInstance().setTopCard(this);
		return null;
	}


}
