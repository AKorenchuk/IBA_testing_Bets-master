import exeption.BillException;
import exeption.SumException;
import org.junit.Assert;
import org.junit.Before;
import  org.junit.Test;
import totalizator.Bet;
import totalizator.Client;

import static org.junit.Assert.assertEquals;

public class BetTest {

    Client client;
    Bet bet;

    @Before
    public void inicialization() throws SumException, BillException {
        client = new Client("Korenchuk Anna", 100.6);
        bet = new Bet(client, 10, "DINAMO MINSK");
    }

    @Test
    public void createBetTest() throws SumException {
        Bet bet = new Bet(client,10,"DINAMO MINSK");
        assertEquals("Korenchuk Anna",bet.getClient().getName());
        Assert.assertTrue(100.6 == bet.getClient().getBill());
        Assert.assertTrue(10 == bet.getSum());
        assertEquals("DINAMO MINSK",bet.getTeamName());
    }

    @Test(expected = SumException.class )
    public void checkSumAndBill() throws SumException {
        client.setBill(5);
        bet = new Bet(client,10,"DINAMO MINSK");
    }

    @Test(expected = SumException.class )
    public void checkSumNegative() throws SumException {
        bet = new Bet(client,-13,"DINAMO MINSK");
    }

    @Test(expected = SumException .class )
    public void checkSumNull() throws SumException {
        bet = new Bet(client,0,"DINAMO MINSK");
    }

    @Test
    public void checkSetMaxKfs()  {
        bet.setKfc(100);
        Assert.assertTrue(100 == bet.getKf());
    }


    @Test
    public void checkSetMinKfs()  {
        double kfs = 100 / 120;
        bet.setKfc(kfs);
        Assert.assertTrue(kfs == bet.getKf());
    }

    @Test (expected = Exception .class )
    public void checkSetKfsMoreThanMax()  {
        bet.setKfc(1000);
        Assert.assertTrue(1000 == bet.getKf());
    }

    @Test(expected = Exception .class )
    public void checkSetKfsNull()  {
        bet.setKfc(0);
    }

    @Test(expected = Exception .class )
    public void checkSetKfsNegative() {
        bet.setKfc(-13);
    }

}
