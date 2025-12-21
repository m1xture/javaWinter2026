package app;

import app.DistanceConverter;
import app.MassConverter;


public class Main {
    public static void main(String[] args) {
        System.out.println("App for measures converting.");
        System.out.println("Version 1.0");
        // Mass
        double kgs = 5;
        double pnds = 12;

        double pounds = MassConverter.convertKgsToPounds(kgs);
        double kilos = MassConverter.convertPoundsToKgs(pnds);

        System.out.printf("Result is %.2f pounds and %.2f kgs.", pounds, kilos);

        //? Distance

        double kms = 10;
        double miles = 500;

        double milesFromKms = DistanceConverter.convertKmsToMiles(kms);
        double kmsFromMiles = DistanceConverter.convertMilesToKms(miles);

        System.out.printf("\nResult is %.2f miles and %.2f kilometers.", milesFromKms, kmsFromMiles);

        //? Temperature

        double cDegrees = 20;
        double fDegrees = 50;

        double fahrenheitFromCelsius = TempConverter.convertCelsiusToFahrenheit(cDegrees);
        double celsiusFromFahrenheit = TempConverter.convertFahrenheitToCelsius(fDegrees);
        System.out.printf("\nResult is %.2f Fahrenheit and %.2f Celsius ", fahrenheitFromCelsius, celsiusFromFahrenheit);
    }
}
