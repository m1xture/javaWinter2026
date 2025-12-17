package app;

public class DistanceConverter {

    private static final double CONV_K = 1.60934;

    public static double convertKmsToMiles(double value) {
        return value / CONV_K;
    }

    public static double convertMilesToKms(double value) {
        return value * CONV_K;
    }
}
