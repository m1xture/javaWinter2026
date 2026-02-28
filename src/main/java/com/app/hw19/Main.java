package com.app.hw19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random rd = new Random();
        for (int i = 0; i < 11; i++) {
            list.add(rd.nextInt(101));
        }

        System.out.println(list);
        Integer[] arr = list.toArray(new Integer[0]);
        ArrayUtils.mergeSort(arr, 0, list.size() - 1);
        System.out.println("Sorted array - " + Arrays.toString(arr));
        Integer numberIndex = ArrayUtils.binarySearch(arr, arr[4]); // index = 1
        Integer numberIndex2 = ArrayUtils.binarySearch(arr, 289); // -1

        System.out.println(numberIndex);
        System.out.println(numberIndex2);

    }
}
