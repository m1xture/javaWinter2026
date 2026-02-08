package app.hw14;

import java.util.List;

public class DataRepository {
    public List<String> getData() {
        String[] names = {"Alice",
                "Bob",
                "Lucy",
                "Denis",
                "Tom"};
        return List.of(names);
    }
}
