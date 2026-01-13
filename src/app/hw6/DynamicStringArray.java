package app.hw6;

import java.util.Arrays;

public class DynamicStringArray {
    private static final int INITIAL_CAPACITY = 10;
    private String[] data = {};
    private int size = data.length;


    public DynamicStringArray(String[] strings) {
        this.data = strings;
    }

    private void expandArray(boolean isPositive) {
        this.data = Arrays.copyOf(this.data, this.data.length + (isPositive ? 1 : -1));
    }

    private void checkIndex(int i) {
        if (i < 0 || i > this.data.length) throw new IllegalArgumentException("Invalid index argument");
    }

    public int size() {
        return this.data.length;
    }

    ;

    public boolean isEmpty() {
        return this.data.length == 0;
    }

    ;

    public void add(String value) {
//        System.out.println(value + (data.length - 1));
        add(data.length, value);
    }

    ;

    public void add(int index, String value) {
        expandArray(true);
        this.data[index] = value;
    }

    ;


    public String get(int index) {
        checkIndex(index);
        return data[index];
    }

    ;

    public String set(int index, String value) {
        checkIndex(index);
        String oldValue = data[index];
//        expandArray(true);
        data[index] = value;
        return oldValue;
    }

    ;

    public String remove(int index) {
        String oldValue = data[index];
        String[] newArr = new String[data.length - 1];
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (i != index) newArr[count++] = data[i];
        }
        data = newArr;
        return oldValue;
    }

    ;

    public boolean remove(String value) {
        int index = -1;
        System.out.println("--------");
        System.out.println(value);
        for (int i = 0; i <= data.length - 1; i++) {
            System.out.println(data[i]);
            if (data[i].equals(value)) index = i;
        }
        System.out.println(index);
        if (index == -1) return false;
        remove(index);
        return true;
    }

    ;

    public void clear() {
        data = Arrays.copyOf(data, 0);
    }

    ;

    public int indexOf(String value) {
        System.out.println("valll" + value);

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
            if (data[i].equals(value)) return i;
        }
        return -1;
    }

    ;

    public String[] getData() {
        return data;
    }
}
