package main;

import org.junit.jupiter.api.Test;

/**
 * Created by vipuljain on 03/11/17.
 */
public class Game {

    private int[] rolls = new int[21];
    private  int currentRoll = 0;

    //here roll is calculating score but its name does not imply that
    public void roll(int pins)
    {
        //score += pins;
        rolls[currentRoll++] = pins;
    }


    //score does not calculate store but its name implies that
    public int score()
    {

        int score = 0;
        int frameIndex = 0;
        for(int frames = 0; frames < 10; frames++)
        {
            if(isSpare(frameIndex) )        //spare
            {
                score += 10 + spareBonus(frameIndex);
                frameIndex+= 2;
            }
            else if(isStrike(frameIndex)){         //strike

                score += 10 +  strikeBonus(frameIndex);
                frameIndex++;

            }
            else
            {
                score += rolls[frameIndex] + rolls[frameIndex+1];
                frameIndex+=2;
            }

        }
        return score;
    }

    public boolean isSpare(int frameIndex){

        if((rolls[frameIndex] + rolls[frameIndex+1]) == 10)
        {
            return true;
        }

        return false;
    }

    private int spareBonus(int frameIndex)
    {
        return rolls[frameIndex+2];
    }

    private int strikeBonus(int frameIndex)
    {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private boolean isStrike(int frameIndex)
    {
        if(rolls[frameIndex] == 10)
        {
            return true;
        }
        return false;
    }


}
