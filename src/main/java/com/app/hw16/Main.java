package com.app.hw16;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        MathOperation add = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };
        System.out.printf("Addition result: %d", add.operate(5, 6));


        String testString = "Hello World! Weather is good today.";
        StringManipulator toUppercase = String::toUpperCase;
        System.out.printf("%nResult of uppercase transform: %s", toUppercase.manipulate(testString));

        Function<String, Integer> countUppercaseFn = StringListProcessor::countUppercase;
        System.out.printf("%nString is '%s'. It contains %d uppercase letters", testString, countUppercaseFn.apply(testString));

        Supplier<Integer> generateNumber = () -> RandomNumberGenerator.generateRandomNumber(1, 100);
        System.out.printf("%nRandom number supplier: %d", generateNumber.get());


    }
}
