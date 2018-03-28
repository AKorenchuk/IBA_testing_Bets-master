import exeption.MarginException;
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
    public static  double[] means = { 21, 20.1 , 20.6 };

    @DataPoints("borderMean")
    public static  double[] border = { 1, 20 };

    @Before
    public void inicialization() throws MarginException {
        game = new Game(10);
    }

    @Test()
    @Theory
    public void checkSetMarginBorder(@FromDataPoints("borderMean") double mean) {
        game.setMargin(mean);
    }

    @Test(expected  =  MarginException.class )
    public void checkSetProbNegative(){
        game.setMargin(-10);
    }

    @Test(expected  =  MarginException.class )
    public void checkSetProbNull(){
        game.setMargin(0);
    }

    @Test(expected  =  MarginException.class )
    @Theory
    public void checkSetProbMoreThan(@FromDataPoints("meansMoreThanMax") double mean){
        game.setMargin(mean);
    }



}
