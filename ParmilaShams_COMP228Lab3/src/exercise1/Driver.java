package exercise1;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Insurance[] insurances = new Insurance[2];

        for (int i = 0; i < insurances.length; i++) {
            System.out.print("Enter insurance type: ");
            String type = scanner.nextLine();

            System.out.print("Enter monthly cost: ");
            double cost = scanner.nextDouble();
            scanner.nextLine();

            if (type.equals("life")) {
                insurances[i] = new Life();
            } else if (type.equals("health")) {
                insurances[i] = new Health();
            }

            insurances[i].setInsuranceCost(cost);
        }

        // Polymorphic behavior
        System.out.println("\nInsurance Information:");
        for (Insurance insurance : insurances) {
            insurance.displayInfo();
            System.out.println();
        }

        scanner.close();
    }
}
