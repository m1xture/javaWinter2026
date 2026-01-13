package app;

import app.DistanceConverter;
import app.MassConverter;

import java.util.Arrays;


public class Main {
//    public static void main(String[] args) {
//
//        System.out.println("App for measures converting.");
//        System.out.println("Version 1.0");
//        // Mass
//        double kgs = 5;
//        double pnds = 12;
//
//        double pounds = MassConverter.convertKgsToPounds(kgs);
//        double kilos = MassConverter.convertPoundsToKgs(pnds);
//
//        System.out.printf("Result is %.2f pounds and %.2f kgs.", pounds, kilos);
//
//        //? Distance
//
//        double kms = 10;
//        double miles = 500;
//
//        double milesFromKms = DistanceConverter.convertKmsToMiles(kms);
//        double kmsFromMiles = DistanceConverter.convertMilesToKms(miles);
//
//        System.out.printf("\nResult is %.2f miles and %.2f kilometers.", milesFromKms, kmsFromMiles);
//    }

    public static void main(String[] args) {

    }

    public String decompress(String input) {
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i <= input.length(); i++) {
            String ch = Character.toString(input.charAt(i));
            if (Character.isDigit(ch.charAt(0)) && i != 0) {
                //! Wrong. not ch.repeat, but input.charAt(i-1).repeat
                ch = Character.toString(input.charAt(i - 1)).repeat(Integer.getInteger(ch));
            }
            newStr.append(ch);
        }
        return newStr.toString();
    }

//    public String smartTrim(String input, int target) {
//
//        if (input == null || input.isBlank()) throw new IllegalArgumentException("Invalid input argument");
//        if (input.length() <= target) return null;
//        String[] strArr = input.split(" ");
//        int sumLength = 0;
//        int lastIndex = 0;
//        for (int i = 0; i <= strArr.length - 1; i++) {
//            sumLength += strArr[i].length();
//            if (sumLength + strArr[i + 1].length() >= target) {
//
//                break;
//            }
//        }
//    }

    public String toCamelCase(String input) {
        String[] arr = input.trim().toLowerCase().split(" ");
        for (int i = 0; i < arr.length; i++) {
            String w = arr[i];
            if (!w.isEmpty()) {
                arr[i] = Character.toUpperCase(w.charAt(0)) + w.substring(1, w.length() - 1);
            }
        }
        return null;
    }

}
