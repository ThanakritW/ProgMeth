package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

import java.util.ArrayList;

//You CAN modify the first line
public class DrawFourCard extends EffectCard{
    // TODO Implement here
	public DrawFourCard() {
		super(null, CardSymbol.DRAW_FOUR);	
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
		GameLogic now = GameLogic.getInstance();
		String message = "Set color to " + this.getColor() + "\n";
		now.incrementDrawAmount(4);
		now.goToNextPlayer();
		while(now.getCurrentPlayerHand().isEmpty()) {
			now.goToNextPlayer();
		}
		boolean played = true;
		for(BaseCard currentCard : now.getCurrentPlayerHand()) {
			if(currentCard.getSymbol() == CardSymbol.DRAW_FOUR){
				int handSize = now.getCurrentPlayerHand().size()-1;
				message += "Player " + now.getCurrentPlayer() + " played " + currentCard.getSymbol().toString() + ". " 
				+ handSize + " cards remaining.";
				message += "\n"+ currentCard.play();
				played = false;
				break;
			}
		}
		if(played) {
			now.draw(now.getDrawAmount());
			message += "Player " + now.getCurrentPlayer() + " drew " + now.getDrawAmount() + " cards. " + now.getCurrentPlayerHand().size() + " cards remaining."; 
			now.setDrawAmount(0);
		}
		return message;
	}


}
