package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

//You CAN modify the first line
public class SkipCard extends EffectCard{
    // TODO Implement here
	public SkipCard(CardColor color) {
		super(color, CardSymbol.SKIP);	
	}
	
	public String toString() {
		return this.getColor().toString() + " " + this.getSymbol().toString();
	}
	
	public boolean canPlay() {
		GameLogic now = GameLogic.getInstance();
		BaseCard topCard = now.getTopCard();
		if(this.getColor() == topCard.getColor()) {
			return true;
		}
		if(this.getSymbol() == topCard.getSymbol()) {
			return true;
		}
		return false;
	}
	
	public String performEffect() {
		GameLogic now = GameLogic.getInstance();
		now.goToNextPlayer();
		while(now.getCurrentPlayerHand().isEmpty()) {
			now.goToNextPlayer();
		}
		return "Skipped player " + now.getCurrentPlayer();
	}


}
