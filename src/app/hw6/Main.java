package app.hw6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] data = {"la-la-la", "bla-bla-bla"};

        DynamicStringArray stringArr = new DynamicStringArray(data);
        System.out.println(Arrays.toString(stringArr.getData()));
        System.out.println(stringArr.isEmpty());
        stringArr.add("ha-ha-ha");
        System.out.println(Arrays.toString(stringArr.getData()));

        String oldValue = stringArr.remove(1);
        System.out.println("old value - " + oldValue);
        System.out.println(Arrays.toString(stringArr.getData()));
        stringArr.remove("ha-ha-ha");
        System.out.println(Arrays.toString(stringArr.getData()));

        System.out.println("GET method");
        System.out.println(stringArr.get(0));

        System.out.println("SET");
        stringArr.set(0, "ho-ho-ho");
        System.out.println(Arrays.toString(stringArr.getData()));

        String newValue = "wa-wa-wa";
        stringArr.add(newValue);
        System.out.println(Arrays.toString(stringArr.getData()));

        System.out.println("index of wawawa - " + stringArr.indexOf(newValue));

        stringArr.clear();
        System.out.println(stringArr.isEmpty());

    }
}
