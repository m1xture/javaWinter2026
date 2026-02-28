package com.app.yaml;

import java.io.IOException;
import java.nio.file.Path;

public interface FileProcessor {
    String readFromFile(String filePath) throws IOException;

    void writeToFile(String dir, String fileName, String newExtension, String content) throws IOException;

    boolean isProcessedFile(Path filePath);

    void deleteFile(String filePath) throws IOException;

    void folderFileChecker(String folderInputPath, String folderOutputPath) throws IOException, InterruptedException;
}
