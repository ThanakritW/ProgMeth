package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

//You CAN modify the first line
public class DrawTwoCard extends EffectCard{
    // TODO Implement here
	public DrawTwoCard(CardColor color) {
		super(color, CardSymbol.DRAW_TWO);	
	}
	
	public String toString() {
		return this.getColor().toString() + " " + this.getSymbol().toString();
	}
	
	public boolean canPlay() {
		GameLogic now = GameLogic.getInstance();
		BaseCard topCard = now.getTopCard();
		if(this.getColor().equals(topCard.getColor())) {
			return true;
		}
		if(this.getSymbol().equals(topCard.getSymbol())) {
			return true;
		}
		return false;
	}
	
	public String performEffect() {
		GameLogic now = GameLogic.getInstance();
		String message = "";
		now.incrementDrawAmount(2);
		now.goToNextPlayer();
		while(now.getCurrentPlayerHand().isEmpty()) {
			now.goToNextPlayer();
		}
		boolean played = true;
		for(BaseCard currentCard : now.getCurrentPlayerHand()) {
			if(currentCard.getSymbol() == CardSymbol.DRAW_TWO){
				int handSize = now.getCurrentPlayerHand().size()-1;
				message = "Player " + now.getCurrentPlayer() + " played " + currentCard.toString() + ". " 
				+ handSize + " cards remaining.";
				message += "\n"+ currentCard.play();
				played = false;
				break;
			}
			else if(currentCard.getSymbol() == CardSymbol.DRAW_FOUR){
				int handSize = now.getCurrentPlayerHand().size()-1;
				message = "Player " + now.getCurrentPlayer() + " played " + currentCard.toString() + ". " 
				+ handSize + " cards remaining.";
				message += "\n"+ currentCard.play();
				played = false;
				break;
			}
		}
		if(played) {
			now.draw(now.getDrawAmount());
			message = "Player " + now.getCurrentPlayer() + " drew " + now.getDrawAmount() + " cards. " + now.getCurrentPlayerHand().size() + " cards remaining."; 
			now.setDrawAmount(0);
		}
		return message;
	}

}
