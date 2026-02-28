package com.app.yaml;

import com.app.yaml.impl.FileProcessorImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("File converter");
        FileProcessor fp = new FileProcessorImpl();
        fp.folderFileChecker("filescheck", "checkoutput");


    }


}
