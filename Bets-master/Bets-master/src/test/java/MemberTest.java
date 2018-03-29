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
    public void checkConstructorWhenProbNegative(){
        Member member = new Member("DINAMO",-40);
    }

    @Test(expected  =  Exception.class )
    @Theory
    public void checkSetProbMoreThanMax(@FromDataPoints("meansMoreThanMax") double mean){
        participant.setProb(mean);
    }

    @Test(expected  =  Exception.class )
    @Theory
    public void checkConstructorWhenProbMoreThanMax(@FromDataPoints("meansMoreThanMax") double mean){
        Member member = participant = new Member("DINAMO",mean);
    }


    @Test
    @Theory
    public void checkSetProbBorder(@FromDataPoints("border") double mean){
        participant.setProb(mean);
        Assert.assertTrue(mean == participant.getProb());
    }

    @Test
    @Theory
    public void checkConstructorWhenProbBorder(@FromDataPoints("border") double mean){
        Member member =  new Member("DINAMO",mean);
        Assert.assertTrue(mean == member.getProb());
    }

}