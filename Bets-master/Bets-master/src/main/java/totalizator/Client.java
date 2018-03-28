package totalizator;

import exeption.BillException;

public class Client {
    private String clientName;
    private double bill;

    public Client(String clientName, double bill) {
        
        try {
            if (bill < 0) {
                throw new BillException();
            }            
            this.clientName = clientName;
            this.bill = bill;            
           
        } catch (BillException e) {
            System.out.println(e.toString());
        }
    }

    public void setName(String name) {
        this.clientName = clientName;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public String getName() {
        return this.clientName;
    }

    public double getBill() {
        return this.bill;
    }
}

