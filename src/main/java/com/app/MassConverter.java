package com.app;

public class MassConverter {
    private static final double CONV_K = 2.20462;

    public static double convertKgsToPounds(double kgs) {
        return kgs * CONV_K;
    }

    public static double convertPoundsToKgs(double pnds) {
        return pnds / CONV_K;
    }
}
