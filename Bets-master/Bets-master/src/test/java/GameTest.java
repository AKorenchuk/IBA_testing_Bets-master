import exeption.MarginException;
import org.junit.Assert;
import org.junit.Before;
import  org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import totalizator.Game;

@RunWith(Theories.class)
public class GameTest {

    public Game game;

    @DataPoints("meansMoreThanMax")
    public static  double[] means = { 23, 20.1 , 20.6 };

    @DataPoints("borderMean")
    public static  double[] border = { 1, 20 };

    @Before
    public void inicialization() throws MarginException {
        game = new Game(10);
    }

    @Before
    public void createEpmtyGame() throws MarginException {
        game = new Game(10);
    }

    @Test
    @Theory
    public void checkSetMarginBorder(@FromDataPoints("borderMean") double mean) {
        game.setMargin(mean);
    }

    @Test(expected  =  MarginException.class )
    public void checkSetMarginNegative(){
        game.setMargin(-10);
    }

    @Test(expected  =  MarginException.class )
    public void checkSetMarginNull(){
        game.setMargin(0);
    }

    @Test(expected  =  MarginException.class )
    @Theory
    public void checkSetMarginMoreThan(@FromDataPoints("meansMoreThanMax") double mean){
        game.setMargin(mean);
    }




    @Test
    @Theory
    public void checkConstructorWhenMarginBorder(@FromDataPoints("borderMean") double mean) throws MarginException {
        Game play = new Game(mean);
    }

    @Test(expected  =  MarginException.class )
    public void checkConstructorWhenMarginNegative() throws MarginException {
        Game play = new Game(-10);
    }

    @Test(expected  =  MarginException.class )
    public void checkConstructorWhenMarginNull() throws MarginException {
        Game play = new Game(0);
    }

    @Test(expected  =  MarginException.class )
    @Theory
    public void checkConstructorWhenMarginMoreThan(@FromDataPoints("meansMoreThanMax") double mean) throws MarginException {
        Game play = new Game(mean);
    }



}
