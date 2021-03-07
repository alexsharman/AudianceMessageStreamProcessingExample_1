package org.exercise.one.processing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InFileReader implements InReader {

    private static final String PWD = System.getProperty("user.dir");
    private static final String FILE_PATH = "/src/main/resources/";
    private static BufferedReader reader;


    public InFileReader() {
        try {
            this.reader = Files.newBufferedReader(Paths.get(PWD + FILE_PATH + "in_messages.txt"), Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Stream<String> read() {
        return reader.lines();
    }

    public List<String> readFileAsListOfStrings(String fileName) {
        try {
            return Files.newBufferedReader(Paths.get(PWD + FILE_PATH + fileName), Charset.forName("UTF-8")).lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void flushFile(String fileName) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(PWD + FILE_PATH + fileName) ,Charset.forName("UTF-8"));
            writer.write("");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
