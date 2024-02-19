package ru.community.communityplugin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class DATA {

    public void createDirectory(String path) throws IOException {
        Files.createDirectory(Path.of(path));
    }

    public void createFile(String path, String fileName) throws IOException {
        String result = path + "\\" + fileName;
        Files.createFile(Path.of(result));
    }

    public void readFile(String path, String fileName) throws IOException {
        String result = path + "\\" + fileName;
        Path method = Path.of("c:\\readme.txt");
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(method);
    }

}
