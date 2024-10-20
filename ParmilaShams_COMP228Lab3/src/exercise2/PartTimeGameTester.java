package exercise2;
class PartTimeGameTester extends GameTester {
    private int hoursWorked;

    public PartTimeGameTester(String name, int hoursWorked) {
        super(name, false);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double determineSalary() {
        return hoursWorked * 20;  // $20 per hour
    }
}
