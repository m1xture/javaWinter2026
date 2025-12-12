package app;

public class Main {
    private static final double CONV_K = 2.20462;

    public static void main(String[] args) {
        System.out.println("Converter app");
        System.out.println("App for measures converting.");
        double kgs = 5;
        double pounds = convertKgsToPounds(kgs);
        System.out.printf("Result is %.2f pounds", pounds);
    }

    private static double convertKgsToPounds(double kgs) {
        return kgs * CONV_K;
    }
}
