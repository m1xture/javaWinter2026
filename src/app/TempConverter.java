package app;

public class TempConverter {
    private static final double CONV_K = 1.8d;
    private static final double CONV_T = 32.0d;

    public static double convertCelsiusToFahrenheit(double cDegrees) {
        return cDegrees * CONV_K + CONV_T;
    }

    public static double convertFahrenheitToCelsius(double dDegrees) {
        return (dDegrees - CONV_T) / CONV_K;
    }
}
