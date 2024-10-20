package exercise3;

class PersonalMortgage extends Mortgage {

    public PersonalMortgage(String mortgageNumber, String customerName, double amount, double primeRate, int term) {
        super(mortgageNumber, customerName, amount, primeRate + 2, term);
    }

    @Override
    public void getMortgageInfo() {
        System.out.println("Personal Mortgage for " + customerName + ": $" + amount + " at " + interestRate + "% interest for " + term + " years.");
    }
}
