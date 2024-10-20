package exercise2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the game tester's name: ");
        String name = scanner.nextLine();

        System.out.print("Is the tester full-time? (yes/no): ");
        String type = scanner.nextLine().toLowerCase();

        GameTester tester;
        if (type.equals("yes")) {
            tester = new FullTimeGameTester(name);
        } else {
            System.out.print("Enter number of hours worked: ");
            int hours = scanner.nextInt();
            tester = new PartTimeGameTester(name, hours);
        }

        System.out.println("Tester Name: " + name);
        System.out.println("Salary: $" + tester.determineSalary());

        scanner.close();
    }
}