package com.app.hw15;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataRepository {
    Object[][] users = {{387, "Lucy"}, {231, "Alice"}, {394, "Bob"}, {172, "Tom"}};

    public Map<Integer, String> getData() {
        return Stream.of(users).collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1]));
    }
}
