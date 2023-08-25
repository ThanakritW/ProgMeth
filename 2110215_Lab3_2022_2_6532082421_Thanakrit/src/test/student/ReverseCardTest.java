package test.student;

import logic.card.NumberCard;
import logic.card.ReverseCard;
import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;
import logic.game.PlayDirection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseCardTest {
    ReverseCard c1;
    NumberCard c2;
    ReverseCard c3;
    ReverseCard c4;
    NumberCard c5;

    @BeforeEach
    void setup() {
        c1 = new ReverseCard(CardColor.RED);
        c2 = new NumberCard(CardColor.RED, CardSymbol.NINE);
        c3 = new ReverseCard(CardColor.GREEN);
        c4 = new ReverseCard(CardColor.RED);
        c5 = new NumberCard(CardColor.BLUE, CardSymbol.FIVE);
    }

    @AfterEach
    void tearDown() {
        GameLogic.clearInstance();
    }


    @Test
    void testConstructor() {
        // TODO Implement here
    	assertEquals(CardColor.RED, c1.getColor());
        assertEquals(CardSymbol.REVERSE, c1.getSymbol());
        
        assertEquals(CardColor.GREEN, c3.getColor());
        assertEquals(CardSymbol.REVERSE, c3.getSymbol());

        assertEquals(CardColor.RED, c4.getColor());
        assertEquals(CardSymbol.REVERSE, c4.getSymbol());
    }

    @Test
    void testToString() {
        assertEquals("RED REVERSE", c1.toString());
        assertEquals("GREEN REVERSE", c3.toString());
        assertEquals("RED REVERSE", c4.toString());
    }

    @Test
    void testCanPlay() {
        // TODO Implement here
    	GameLogic gameInstance = GameLogic.getInstance(1);
        
        gameInstance.setTopCard(c2);
        assertTrue(c1.canPlay());

        gameInstance.setTopCard(c3);
        assertTrue(c1.canPlay());

        gameInstance.setTopCard(c4);
        assertTrue(c1.canPlay());
        
        gameInstance.setTopCard(c5);
        assertFalse(c1.canPlay());

    }

    @Test
    void testPerformEffect() {
        GameLogic gameInstance = GameLogic.getInstance(3);

        String message = c1.performEffect();

        assertEquals(PlayDirection.BACKWARD, gameInstance.getPlayDirection());
        assertEquals("Set direction to BACKWARD", message);

        message = c3.performEffect();

        assertEquals(PlayDirection.FORWARD, gameInstance.getPlayDirection());
        assertEquals("Set direction to FORWARD", message);
    }

    @Test
    void testPlay() {
        GameLogic gameInstance = GameLogic.getInstance(3);
        gameInstance.getPlayerHand(0).add(c1);
        gameInstance.getPlayerHand(1).add(c2);
        gameInstance.getPlayerHand(2).add(c3);

        String message = c1.play();

        assertEquals(c1, gameInstance.getTopCard());
        assertEquals(0, gameInstance.getPlayerHand(0).size());
        assertEquals(PlayDirection.BACKWARD, gameInstance.getPlayDirection());
        assertEquals("Set direction to BACKWARD", message);
    }
    
}
