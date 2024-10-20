package exercise2;

class FullTimeGameTester extends GameTester {

    public FullTimeGameTester(String name) {
        super(name, true);
    }

    @Override
    public double determineSalary() {
        return 3000.00;  // Base salary for full-time
    }
}