package com.app.hw22;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayUtilsProcessor {
    public static void processArrayUtilsWithAnots(Object obj) {
        Class<?> clazz = obj.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MethodInfo.class)) {
                MethodInfo info = method.getAnnotation(MethodInfo.class);

                System.out.printf("method called %s returns %s%n", method.getName(), method.getReturnType().getSimpleName());
                System.out.println(info.description());
                try {
                    if (method.getModifiers() == Modifier.PRIVATE) continue;
                    List<Integer> list = new ArrayList<>();
                    Random rd = new Random();
                    for (int i = 0; i < 11; i++) {
                        list.add(rd.nextInt(101));
                    }

                    Integer[] arr = list.toArray(new Integer[0]);

                    if (method.getName().equals("mergeSort")) {
                        method.invoke(obj, arr, 0, arr.length - 1);

                    } else {
                        Integer[] numbers = {1, 2, 3, 4, 9, 56};
                        method.invoke(obj, numbers, numbers[5]);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
