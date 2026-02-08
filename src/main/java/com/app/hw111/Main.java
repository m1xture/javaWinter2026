package app.hw111;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path searchDir = Paths.get("files/");
        Path filePath = Paths.get("files/myfile.txt");

        new DuplicateDetector(filePath, searchDir).deleteDuplicates();

    }
}
