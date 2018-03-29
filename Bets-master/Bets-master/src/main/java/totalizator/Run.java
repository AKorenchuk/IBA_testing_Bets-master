package totalizator;

import exeption.*;

public class Run {
    
        
    public static void main(String args[]) throws SumException, BillException, MarginException, NameException, ProbException {

        Client client1 = new Client("Ann", 20);
        Client client2 = new Client("Tom", 40);
        Client client3 = new Client("Kate", 30);

        Member member1 = new Member("Madison", 0);
        Member member2 = new Member("Michael", 20);
        Member member3 = new Member("Olivia", 80);

        Game game = new Game(20);

        Bet bet1 = new Bet(client1, 5, "Madison");
        Bet bet2 = new Bet(client2, 5, "Michael");
        Bet bet3 = new Bet(client3, 5, "Olivia");

        game.addMember(member1);
        game.addMember(member2);
        game.addMember(member3);

        game.addBet(bet1);
        game.addBet(bet2);
        game.addBet(bet3);
        
        System.out.println("Current client bill: " + client3.getBill());
        game.setWinner("Olivia");
        game.showResult();


    }


}
