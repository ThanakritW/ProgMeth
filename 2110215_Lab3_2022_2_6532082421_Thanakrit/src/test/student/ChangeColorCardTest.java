package test.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.card.BaseCard;
import logic.card.ChangeColorCard;
import logic.card.NumberCard;
import logic.card.SkipCard;
import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

public class ChangeColorCardTest {
    ChangeColorCard c1;
    NumberCard c2;
    ChangeColorCard c3;
    SkipCard c4;
    NumberCard c5;

    @BeforeEach
    void setup() {
        c1 = new ChangeColorCard();
        c2 = new NumberCard(CardColor.RED, CardSymbol.NINE);
        c3 = new ChangeColorCard();
        c4 = new SkipCard(CardColor.RED);
        c5 = new NumberCard(CardColor.BLUE, CardSymbol.FIVE);
    }

    @AfterEach
    void tearDown() {
        GameLogic.clearInstance();
    }

    @Test
    void testConstructor() {
        assertNull(c1.getColor());
        assertEquals(CardSymbol.CHANGE_COLOR, c1.getSymbol());
    }

    @Test
    void testToString() {
        assertEquals("CHANGE COLOR", c1.toString());
        c1.setColor(CardColor.YELLOW);
        assertEquals("CHANGE COLOR (YELLOW color selected)", c1.toString());
    }

    @Test
    void testCanPlay() {
        GameLogic gameInstance = GameLogic.getInstance(1);

        gameInstance.setTopCard(c2);
        assertTrue(c1.canPlay());

        gameInstance.setTopCard(c3);
        assertTrue(c1.canPlay());

        gameInstance.setTopCard(c4);
        assertTrue(c1.canPlay());

        gameInstance.setTopCard(c5);
        assertTrue(c1.canPlay());
    }

    @Test
    void testPerformEffectHasColor() {
        // TODO Implement here
    	GameLogic now = GameLogic.getInstance(1);
    	now.getCurrentPlayerHand().add(c2);
    	BaseCard firstCard = now.getCurrentPlayerHand().get(0);

    	c3.performEffect();
    	assertEquals(firstCard.getColor(), c3.getColor());

    }

    @Test
    void testPerformEffectNoColor() {
        // TODO Implement here
    	GameLogic now = GameLogic.getInstance(1);
    	now.getCurrentPlayerHand().add(c1);
    	c3.performEffect();
    	assertEquals(CardColor.RED, c3.getColor());

    }

    @Test
    void testPerformEffectNoCard() {
        // TODO Implement here
    	c3.performEffect();
    	assertEquals(CardColor.RED, c3.getColor());

    }

    @Test
    void testPlay() {
        GameLogic gameInstance = GameLogic.getInstance(2);
        gameInstance.getPlayerHand(0).add(c1);
        gameInstance.getPlayerHand(1).add(c3);
        gameInstance.getPlayerHand(1).add(c5);

        String message = c1.play();

        assertEquals(c1, gameInstance.getTopCard());
        assertEquals(0, gameInstance.getPlayerHand(0).size());
        assertEquals(CardColor.RED, c1.getColor());
        assertEquals("Set color to RED", message);

        gameInstance.goToNextPlayer();

        message = c3.play();

        assertEquals(c3, gameInstance.getTopCard());
        assertEquals(1, gameInstance.getPlayerHand(1).size());
        assertEquals(CardColor.BLUE, c3.getColor());
        assertEquals("Set color to BLUE", message);
    }

}
