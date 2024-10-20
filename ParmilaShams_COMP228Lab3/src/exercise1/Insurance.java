package exercise1;

public abstract class Insurance {
    protected String insuranceType;
    protected double monthlyCost;

    // Constructor
    public Insurance(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    // Getter methods
    public String getInsuranceType() {
        return insuranceType;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    // Abstract methods
    public abstract void setInsuranceCost(double cost);

    public abstract void displayInfo();
}

