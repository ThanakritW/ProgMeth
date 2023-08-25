package test.student;

import logic.card.BaseCard;
import logic.card.ChangeColorCard;
import logic.card.NumberCard;
import logic.card.SkipCard;
import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameLogicTest {

    ArrayList<BaseCard> hand0;
    ArrayList<BaseCard> hand1;

    NumberCard c1;
    SkipCard c2;
    NumberCard c3;
    ChangeColorCard c4;

    @BeforeEach
    void setup() {
        c1 = new NumberCard(CardColor.YELLOW, CardSymbol.NINE);
        c2 = new SkipCard(CardColor.YELLOW);
        c3 = new NumberCard(CardColor.RED, CardSymbol.NINE);
        c4 = new ChangeColorCard();
    }

    @AfterEach
    void tearDown() {
        GameLogic.clearInstance();
    }

    @Test
    void testIsHandPlayableTrue() {
        // TODO Implement here
    	GameLogic now = GameLogic.getInstance(2);
    	now.setTopCard(c2);
    	ArrayList<BaseCard> firstHand = now.getPlayerHand(0);
    	ArrayList<BaseCard> secondHand = now.getPlayerHand(1);
    	firstHand.add(c1);
    	firstHand.add(c2);
    	firstHand.add(c3);
    	secondHand.add(c4);
    	assertTrue(now.isHandPlayable(0));
    	assertTrue(now.isHandPlayable(1));
    }

    @Test
    void testIsHandPlayableFalse() {
        // TODO Implement here
    	GameLogic now = GameLogic.getInstance(2);
    	now.setTopCard(new NumberCard(CardColor.BLUE,CardSymbol.FOUR));
    	ArrayList<BaseCard> firstHand = now.getPlayerHand(0);
    	ArrayList<BaseCard> secondHand = now.getPlayerHand(1);
    	firstHand.add(c1);
    	secondHand.add(c2);
    	secondHand.add(c3);
    	assertFalse(now.isHandPlayable(0));
    	assertFalse(now.isHandPlayable(1));

    }

    @Test
    void testDrawLessThanDeck() {
        // TODO Implement here
    	GameLogic now = GameLogic.getInstance(1);
        for (int i=0; i<10; i++)
            now.getDeck().add(new NumberCard(CardColor.randomColor(), CardSymbol.randomSymbol()));
    	assertEquals(5,now.draw(5).size());
    }

    @Test
    void testDrawMoreThanDeck() {
        // TODO Implement here
    	GameLogic now = GameLogic.getInstance(1);
        for (int i=0; i<10; i++)
            now.getDeck().add(new NumberCard(CardColor.randomColor(), CardSymbol.randomSymbol()));
    	assertEquals(10,now.draw(20).size());
    }
}
