package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

//You CAN modify the first line
public abstract class EffectCard extends BaseCard{
	public EffectCard(CardColor color, CardSymbol symbol) {
		super(color,symbol);
	}
	public abstract String performEffect();
	public String play() {
		GameLogic.getInstance().getCurrentPlayerHand().remove(this);
		GameLogic.getInstance().setTopCard(this);
		return performEffect();
	}
}
