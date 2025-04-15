package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double baseRate = 29.99;
        final double tollTagRate = 3.95;
        final double gpsRate = 2.95;
        final double roadsideRate = 3.95;
        final double underageRate = 0.30;

        System.out.print("Enter the pick up date (e.g., 2025-04-14): ");
        String pickupDate = scanner.nextLine();

        System.out.print("Number of rental days: ");
        int numRentalDays = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Electronic toll tag at $3.95/day (yes/no): ");
        String tollTagChoice = scanner.nextLine();

        System.out.print("GPS at $2.95/day (yes/no): ");
        String gpsChoice = scanner.nextLine();

        System.out.print("Roadside assistance at $3.95/day (yes/no): ");
        String roadAssistChoice = scanner.nextLine();

        System.out.print("What is your current age: ");
        int currentAge = scanner.nextInt();

        // Calculate the base rental cost
        double basicRentalCost = baseRate * numRentalDays;

        // Calculate the options cost depending on numRentalDays
        double optionsCost = 0.0;
        if (tollTagChoice.equalsIgnoreCase("yes")){
            optionsCost = optionsCost + (tollTagRate * numRentalDays);
        }
        if (gpsChoice.equalsIgnoreCase("yes")) {
            optionsCost = optionsCost + (gpsRate * numRentalDays);
        }
        if (roadAssistChoice.equalsIgnoreCase("yes")){
            optionsCost += roadsideRate * numRentalDays;
        }

        // Calculate underage surcharge
        double surcharge = 0.0;
        if (currentAge < 25) {
            surcharge = baseRate * underageRate;
        }

        // Calculate total
        double totalCost = basicRentalCost + optionsCost + surcharge;


        // Display breakdown
        System.out.println("\n----- Rental Summary -----");
        System.out.println("Pickup Date: " + pickupDate);
        System.out.printf("Basic Rental (%d days): $%.2f%n", numRentalDays, basicRentalCost);
        System.out.printf("Options Cost: $%.2f%n", optionsCost);
        System.out.printf("Underage Surcharge: $%.2f%n", surcharge);
        System.out.printf("Total Cost: $%.2f%n", totalCost);
    }
}
