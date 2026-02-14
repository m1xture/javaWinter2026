package com.app.hw16;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator {
    public static Integer generateRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
