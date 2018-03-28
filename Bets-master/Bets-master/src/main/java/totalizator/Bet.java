package totalizator;

import exeption.SumException;

public class Bet {
    private Client cl;
    private double sum;
    private String teamName;
    private double kf;

    public Bet(Client client, double sum, String teamName) throws SumException {

            if (sum > client.getBill()) {
                throw new SumException();
            }            
            this.cl = client;
            this.sum = sum;
            this.teamName = teamName;
    }

    public void setKfc(double kfc) {
        this.kf = kfc;
    }

    public Client getClient() {
        return cl;
    }

    public double getKf() {
        return kf;
    }

    public String getTeamName() {
        return teamName;
    }

    public double getSum() {
        return sum;
    }
    public double getAward(){
        return this.sum * this.getKf();
    }
}
