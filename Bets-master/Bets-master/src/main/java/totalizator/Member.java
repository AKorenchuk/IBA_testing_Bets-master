package totalizator;

public class Member {

    private String name;
    private double prob;

    public Member(String name, double prob) {
        this.name = name;
        this.prob = prob;


    }

    public void setProb(double prob) {
        this.prob = prob;
    }

    public double getProb() {
        return prob;
    }

    public String getName() {
        return name;
    }
}
