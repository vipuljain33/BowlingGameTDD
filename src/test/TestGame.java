package test;

import main.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by vipuljain on 03/11/17.
 */
public class TestGame {

    Game g = new Game();

    @Test
    public void tesGutter()
    {
        rollMany(0,20);
        Assertions.assertEquals(0, g.score());
    }


    @Test
    public void testAllOnes()
    {
        rollMany(1,20);
        Assertions.assertEquals(20, g.score());
    }

    @Test
    public void testOneSpare()
    {

        //g.roll(5);
        //g.roll(5);       //spare
        rollSpare();
        g.roll(3);
        rollMany(0,17);
        Assertions.assertEquals(16, g.score());

    }


    @Test
    public void testOneStrike()
    {
        //g.roll(10);       //strike
        rollStrike();
        g.roll(3);
        g.roll(4);
        rollMany(0, 16);
        Assertions.assertEquals(24, g.score());
    }

    @Test
    public void perfectGame()
    {
        rollMany(10,12);
        Assertions.assertEquals(300, g.score());
    }


    private void rollStrike()
    {
        g.roll(10);
    }


    private void rollMany(int pins, int n)
    {
        for(int i = 0; i < n; i++)
        {
            g.roll(pins);
        }
    }


    private void rollSpare()
    {
        g.roll(5);
        g.roll(5);
    }





}
