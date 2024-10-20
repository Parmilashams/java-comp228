package exercise3;

abstract class Mortgage implements MortgageConstants {
    protected String mortgageNumber;
    protected String customerName;
    protected double amount;
    protected double interestRate;
    protected int term;

    public Mortgage(String mortgageNumber, String customerName, double amount, double interestRate, int term) {
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        this.amount = (amount > MAX_AMOUNT) ? MAX_AMOUNT : amount;
        this.interestRate = interestRate;
        this.term = (term != SHORT_TERM && term != MEDIUM_TERM && term != LONG_TERM) ? SHORT_TERM : term;
    }

    public abstract void getMortgageInfo();
}

