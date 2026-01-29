package app.hw111;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.CRC32;

public class DuplicateDetector {
    Path filePath;
    File file;
    Path searchDirPath;
    String filename;
    long fileCRC;


    DuplicateDetector(Path filePath, Path searchPath) {
        this.filePath = filePath;
        this.file = new File(filePath.toString());
        this.searchDirPath = searchPath;
        this.filename = filePath.getFileName().toString();
        this.fileCRC = computeCRC32(filePath);
    }

    private static long computeCRC32(Path file) {
        CRC32 crc = new CRC32();
        try (InputStream in = Files.newInputStream(file)) {
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                crc.update(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("IOException" + e.getMessage());
        }
        return crc.getValue();
    }

    private boolean checkForName(String fname) {
        return fname.equals(filename);
    }

    private boolean checkForSize(Path filePath) {
        File fileToCompare = new File(filePath.toString());
        return fileToCompare.length() == file.length();
    }

    private boolean checkForCRC32(Path filePath) {
        return computeCRC32(filePath) == fileCRC;
    }

    public Set<Path> detectDuplicates() {
        Set<Path> duplicatePaths = new HashSet<>();
        try (Stream<Path> stream = Files.walk(searchDirPath)) {
            List<Path> filesPath = stream.filter(Files::isRegularFile).filter(f -> !f.equals(filePath)).toList();

            for (Path path : filesPath) {
                String filename = path.getFileName().toString();
                if (checkForName(filename) && checkForSize(path) && checkForCRC32(path)) {
                    // Then it's duplicate
                    duplicatePaths.add(path);
                }
            }
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }
        return duplicatePaths;

    }

    public void deleteDuplicates() {
        Set<Path> duplicates = detectDuplicates();
        System.out.println(duplicates.toString());
        try {
            for (Path duplicatePath : duplicates) {
                Files.delete(duplicatePath);
            }
        } catch (IOException e) {
            System.out.println("IOException while deleting duplicate file: " + e.getMessage());
        }
    }
}
