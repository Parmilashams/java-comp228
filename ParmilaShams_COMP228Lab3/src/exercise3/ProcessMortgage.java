package exercise3;

import java.util.Scanner;

public class ProcessMortgage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mortgage[] mortgages = new Mortgage[3];

        System.out.print("Enter the current prime interest rate: ");
        double primeRate = scanner.nextDouble();

        for (int i = 0; i < mortgages.length; i++) {
            System.out.print("Enter mortgage type : ");
            String type = scanner.next().toLowerCase();

            System.out.print("Enter mortgage number: ");
            String number = scanner.next();

            System.out.print("Enter customer name: ");
            String name = scanner.next();

            System.out.print("Enter mortgage amount: ");
            double amount = scanner.nextDouble();

            System.out.print("Enter term (1, 3, 5 years): ");
            int term = scanner.nextInt();

            if (type.equals("business")) {
                mortgages[i] = new BusinessMortgage(number, name, amount, primeRate, term);
            } else if (type.equals("personal")) {
                mortgages[i] = new PersonalMortgage(number, name, amount, primeRate, term);
            }
        }

        System.out.println("\nMortgage Details:");
        for (Mortgage mortgage : mortgages) {
            mortgage.getMortgageInfo();
            System.out.println();
        }

        scanner.close();
    }
}
