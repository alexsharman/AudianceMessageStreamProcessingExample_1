package org.exercise.one.processing;

import org.exercise.one.models.OutModel;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class OutFileWriter implements OutWriter {

    private static final String PWD = System.getProperty("user.dir");
    private static final String FILE_PATH = "/src/main/resources/output_messages.txt";
    private static Path PATH = Paths.get(PWD + FILE_PATH);
    private static BufferedWriter writer;

    public OutFileWriter() {
        try {
            this.writer = Files.newBufferedWriter(PATH, Charset.forName("UTF-8"), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(Stream<String> outStrings) {

        outStrings.forEach(line -> {
            try {
                writer.append(line);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void writeList(List<OutModel> outModels) {
        for (OutModel out : outModels) {
            try {
                writer.write(out.toString());
                writer.newLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
