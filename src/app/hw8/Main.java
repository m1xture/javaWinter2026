package app.hw8;

import java.util.Scanner;

public class Main {
    static double balance;

    public static void main(String[] args) {
        balance = getBalance();
        validateAmount(balance, getAmount());
    }

    private static double getBalance() {
        return 1000.00;
    }

    private static double getAmount() {
        System.out.printf("Balance is USD %.2f.%n", balance);
        Scanner scanner = new Scanner(System.in);
        double purchaseAmount;
        do {
            System.out.println("Enter purchase amount, USD: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid purchase amount");
                scanner.next();
            }
            purchaseAmount = scanner.nextDouble();
        } while (purchaseAmount <= 0);
        return purchaseAmount;
    }

    private static void validateAmount(double balance, double withdrawal) {
        if (withdrawal > balance) {
            try {
                throw new FundsException("Insufficient funds!");
            } catch (FundsException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            balance = getBalance(balance, withdrawal);
            System.out.printf("Funds are OK. Purchase paid." +
                    "%nBalance is USD %.2f", balance);
        }
    }


    private static double getBalance(double balance, double withdrawal) {
        return balance - withdrawal;
    }
}
