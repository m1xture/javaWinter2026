package app;

public class Main {
    private static final double CONV_K = 2.20462;

    public static void main(String[] args) {
        System.out.println("Converter app");
        System.out.println("Version 1.0");
        double kgs = 5;
        double pnds = 12;

        double pounds = convertKgsToPounds(kgs);
        double kilos = convertPoundsToKgs(pnds);

        System.out.printf("Result is %.2f pounds and %.2f kgs.", pounds, kilos);
    }

    private static double convertKgsToPounds(double kgs) {
        return kgs * CONV_K;
    }

    private static double convertPoundsToKgs(double pnds) {
        return pnds / CONV_K;
    }
}
