package com.java.feature.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileRead {

    public static void main(final String[] args) throws IOException {
        Path pathLoc = Paths.get("myfile.txt");
        List<String> readAllLinesLoc = Files.readAllLines(pathLoc);
        System.out.println(readAllLinesLoc);

    }
}
