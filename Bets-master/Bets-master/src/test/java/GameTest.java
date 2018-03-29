import exeption.*;
import org.junit.Before;
import  org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import totalizator.Bet;
import totalizator.Client;
import totalizator.Game;
import totalizator.Member;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

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

    @Test
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

    private LinkedList<Bet> bets = new LinkedList<Bet>();
    LinkedList<Member> members = new LinkedList<Member>();


    @Test
    public void checkAddMembersPositive() throws NameException {
        Member member1 = new Member("DINAMO MINSK",10);
        Member member2 = new Member("DINAMO BREST",25);
        game.addMember(member1);
        game.addMember(member2);
    }


    @Test (expected  =  NameException.class )
    public void checkAddMembersNegative() throws NameException {
        Member member1 = new Member("DINAMO MINSK",10);
        game.addMember(member1);
        game.addMember(member1);
    }

    @Test
    public void checkAddBetsPositive() throws NameException, BillException, SumException, ProbException {
        Member member1 = new Member("DINAMO MINSK",60);
        Member member2 = new Member("DINAMO BREST",40);
        game.addMember(member1);
        game.addMember(member2);
        Client client1 = new Client("Korenchuk Anna", 100.6);
        Client client2 = new Client("Tochilo Anna", 106);
        Bet bet1 = new Bet(client1, 10, "DINAMO MINSK");
        Bet bet2 = new Bet(client2, 20, "DINAMO BREST");
        game.addBet(bet1);
        game.addBet(bet2);
    }


    @Test (expected  =  ProbException.class )
    public void checkAddBetsNegative() throws NameException, BillException, SumException, ProbException {
        Member member1 = new Member("DINAMO MINSK",30);
        Member member2 = new Member("DINAMO BREST",10);
        game.addMember(member1);
        game.addMember(member2);
        Client client1 = new Client("Korenchuk Anna", 100.6);
        Bet bet1 = new Bet(client1, 10, "DINAMO MINSK");
        game.addBet(bet1);
    }

    @Test (expected  =  Exception.class )
    public void checkUniqueBetsOnOneTeam() throws NameException, BillException, SumException, ProbException {
        Member member1 = new Member("DINAMO MINSK",60);
        Member member2 = new Member("DINAMO BREST",40);
        game.addMember(member1);
        game.addMember(member2);
        Client client1 = new Client("Korenchuk Anna", 100.6);
        Bet bet1 = new Bet(client1, 10, "DINAMO MINSK");
        game.addBet(bet1);
        game.addBet(bet1);
    }

    @Test (expected  =  Exception.class )
    public void checkUniqueBetsOnDifferentTeam() throws NameException, BillException, SumException, ProbException {
        Member member1 = new Member("DINAMO MINSK",60);
        Member member2 = new Member("DINAMO BREST",40);
        game.addMember(member1);
        game.addMember(member2);
        Client client1 = new Client("Korenchuk Anna", 100.6);
        Bet bet1 = new Bet(client1, 10, "DINAMO MINSK");
        Bet bet2 = new Bet(client1, 20, "DINAMO BREST");
        game.addBet(bet1);
        game.addBet(bet2);
    }

    @Test (expected  =  Exception.class )
    public void checkOnlyOneMember() throws NameException, BillException, SumException, ProbException {
        Member member1 = new Member("DINAMO MINSK",100);
        game.addMember(member1);
        Client client1 = new Client("Korenchuk Anna", 100.6);
        Bet bet1 = new Bet(client1, 10, "DINAMO MINSK");
        game.addBet(bet1);
    }


    @Test (expected  =  Exception.class )
    public void checkAnotherMember() throws NameException, BillException, SumException, ProbException {
        Member member1 = new Member("DINAMO MINSK",60);
        Member member2 = new Member("DINAMO BREST",40);
        game.addMember(member1);
        game.addMember(member2);
        Client client1 = new Client("Korenchuk Anna", 100.6);
        Bet bet1 = new Bet(client1, 10, "DINAMO GRODNO");
        game.addBet(bet1);
    }


    @Test
    public void checkGameResultPositive() throws NameException, BillException, SumException, ProbException {
        Member member1 = new Member("DINAMO MINSK",60);
        Member member2 = new Member("DINAMO BREST",40);
        game.addMember(member1);
        game.addMember(member2);
        Client client1 = new Client("Korenchuk Anna", 100.6);
        Client client2 = new Client("Tochilo Anna", 106);
        Client client3 = new Client("Koshkina Sveta", 34);
        Bet bet1 = new Bet(client1, 10, "DINAMO MINSK");
        Bet bet2 = new Bet(client2, 20, "DINAMO MINSK");
        Bet bet3 = new Bet(client3, 20, "DINAMO BREST");
        game.addBet(bet1);
        game.addBet(bet2);
        game.addBet(bet3);
        game.setWinner("DINAMO BREST");
        assertEquals("Koshkina Sveta wins 40.0",game.showResult());
    }

    @Test (expected  =  Exception.class )
    public void checkGameResultNegative() throws NameException, BillException, SumException, ProbException {
        Member member1 = new Member("DINAMO MINSK",60);
        Member member2 = new Member("DINAMO BREST",40);
        game.addMember(member1);
        game.addMember(member2);
        Client client1 = new Client("Korenchuk Anna", 100.6);
        Client client2 = new Client("Tochilo Anna", 106);
        Bet bet1 = new Bet(client1, 10, "DINAMO MINSK");
        Bet bet2 = new Bet(client2, 20, "DINAMO BREST");
        game.addBet(bet1);
        game.addBet(bet2);
        game.setWinner("DINAMO GRODNO");
    }

}
