import exeption.BillException;
import org.junit.Assert;
import org.junit.Before;
import  org.junit.Test;
import totalizator.Client;

import static org.junit.Assert.assertEquals;

public class ClientTest {

    public Client client;

    @Before
    public void inicialization() throws BillException {
        client = new Client("Korenchuk Anna", 10);
    }

    @Test()
    public void createClient() throws BillException {
        Client client = new Client("Korenchuk Anna", 0);
        assertEquals("Korenchuk Anna",client.getName());
        Assert.assertTrue(0 == client.getBill());
    }

    @Test(expected  =  BillException.class )
    public void checkSetBill(){
        client.setBill(-12.3);
    }

}
