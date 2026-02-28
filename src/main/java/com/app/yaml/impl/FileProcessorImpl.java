package com.app.yaml.impl;

import com.app.yaml.FileMapper;
import com.app.yaml.FileProcessor;
import com.app.yaml.constants.Extension;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;

public class FileProcessorImpl implements FileProcessor {
    @Override
    public String readFromFile(String filePath) throws IOException {
        return Files.readString(Path.of(filePath));
    }

    @Override
    public void writeToFile(String dir, String fileName, String newExtension, String content) throws IOException {
        if (!Paths.get(dir).toFile().exists()) Paths.get(dir).toFile().mkdir();


        String fileOutput = dir.concat(File.separator).concat(changeExtension(fileName, newExtension));
        Files.writeString(Path.of(fileOutput), content);
    }

    private String changeExtension(String fileName, String extension) {
        int dotIndex = fileName.lastIndexOf(".");
        String baseName = dotIndex == 1 ? fileName : fileName.substring(0, dotIndex);
        return baseName + "." + extension;
    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    @Override
    public boolean isProcessedFile(Path filePath) {
        if (Files.exists(filePath) && Files.isRegularFile(filePath)) {
            String fileName = filePath.getFileName().toString();
            int extensionIndex = fileName.lastIndexOf(".");
            String extension = fileName.substring(extensionIndex + 1);
            return Arrays.stream(Extension.values()).toList().contains(Extension.valueOf(extension.toUpperCase()));
        }
        return false;
    }

    @Override
    public void deleteFile(String filePath) throws IOException {
        Files.delete(Path.of(filePath));
    }

    @Override
    public void folderFileChecker(String folderInputPath, String folderOutputPath) throws IOException, InterruptedException {
        WatchService ws = FileSystems.getDefault().newWatchService();
        Path inputFolder = Path.of(folderInputPath);
        inputFolder.register(ws, StandardWatchEventKinds.ENTRY_CREATE);
        WatchKey key;

        while ((key = ws.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                Path p = (Path) event.context();
                String filePath = folderInputPath.concat(File.separator).concat(p.toString());
                System.out.println(Path.of(filePath));

                if (isProcessedFile(Path.of(filePath))) {
                    System.out.println("File path: " + filePath);

                    if ("yaml".equalsIgnoreCase(getExtension(filePath)) || "yml".equalsIgnoreCase(getExtension(filePath))) {
                        writeToFile(folderOutputPath, p.toString(), "json", new FileMapperJson().convertFileContent(readFromFile(filePath)));
                        return;
                    }
                    String contentIn = readFromFile(filePath);
                    FileMapper fm = new FileMapperYaml();

                    writeToFile(folderOutputPath, p.toString(), "yaml", fm.convertFileContent(contentIn));


                }
            }
        }
    }
}