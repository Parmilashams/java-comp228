package exercise3;

class BusinessMortgage extends Mortgage {

    public BusinessMortgage(String mortgageNumber, String customerName, double amount, double primeRate, int term) {
        super(mortgageNumber, customerName, amount, primeRate + 1, term);
    }

    @Override
    public void getMortgageInfo() {
        System.out.println("Business Mortgage for " + customerName + ": $" + amount + " at " + interestRate + "% interest for " + term + " years.");
    }
}
