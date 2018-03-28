
import org.junit.Assert;
import org.junit.Before;
import  org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import totalizator.Member;

import static org.junit.Assert.assertEquals;

@RunWith(Theories.class)
public class MemberTest {

    public Member participant;

    @DataPoints("meansMoreThanMax")
    public static  double[] means = { 103, 100.1 , 100.6 };

    @DataPoints("border")
    public static  double[] border = { 100, 0 };

    @Before
    public void inicialization() {
        participant = new Member("DINAMO MINSK",10);
    }

    @Test()
    public void createMember() {
        Member member = participant = new Member("DINAMO",40);
        assertEquals("DINAMO",member.getName());
        Assert.assertTrue(40 == member.getProb());
    }

    @Test(expected  =  Exception.class )
    public void checkSetProbNegative(){
        participant.setProb(-10);
    }

    @Test(expected  =  Exception.class )
    @Theory
    public void checkSetProbMoreThan(@FromDataPoints("meansMoreThanMax") double mean){
        participant.setProb(mean);
    }


    @Theory
    public void checkSetProbBorder(@FromDataPoints("border") double mean){
        participant.setProb(mean);
        Assert.assertTrue(mean == participant.getProb());
    }

}