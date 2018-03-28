package totalizator;


import exeption.MarginException;
import exeption.NameException;
import exeption.ProbException;

import java.util.LinkedList;

public class Game {

    private double margin;
    private LinkedList<Bet> bets = new LinkedList<Bet>();
    private LinkedList<Member> members = new LinkedList<Member>();
    private String winner;

    public Game(double margin) {
        
        try {
            if (margin < 1 & margin > 20) {
                throw new MarginException();
            }
            this.margin = margin;

        } catch (MarginException e) {
            System.out.println(e.toString());
        }
    }

    public void addMember(Member participant) {
        try {
            if (this.members.isEmpty()) {
                this.members.add(participant);
            } else {
                for (Member m : this.members) {
                    if (m.getName().equals(participant.getName())) {
                        throw new NameException();
                    }
                }
                this.members.add(participant);
            }
        } catch (NameException e) {
            System.out.println(e.toString());
        }
    }

    public void addBet(Bet bet) {
        double totalProb = 0;
        for (Member m : this.members) {
            if (bet.getTeamName().equals(m.getName())) {
                bet.setKfc(100 / (m.getProb() + this.margin));
            }
        }

        try {
            for (Member m : this.members) {
                totalProb = totalProb + m.getProb();
            }
            if (totalProb != 100) {
                throw new ProbException();
            }
        bet.getClient().setBill(bet.getClient().getBill() - bet.getSum());
        this.bets.add(bet);
        } catch (ProbException e) {
            System.out.println(e.toString());
        }
    }

    public void setMargin(double margin) {
        this.margin = margin;
    }

    public void setWinner() {
        this.winner = "Olivia";
    }

    public void showResult() {
        for (Bet b: this.bets){
            if(b.getTeamName().equals(this.winner)){
                System.out.println(b.getClient().getName() + " wins " + b.getAward());
                 b.getClient().setBill(b.getSum() + b.getAward());
            }
        }
    }
}