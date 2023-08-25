package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;
import logic.game.PlayDirection;

//You CAN modify the first line
public class ReverseCard extends EffectCard{
    // TODO Implement here
	public ReverseCard(CardColor color) {
		super(color, CardSymbol.REVERSE);	
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
		PlayDirection playDirection = now.getPlayDirection(); 
		now.setPlayDirection(playDirection.getOpposite());
		return "Set direction to " + now.getPlayDirection().toString();
	}

}
