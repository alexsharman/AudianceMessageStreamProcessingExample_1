package org.exercise.one.processing;

import java.util.List;
import java.util.stream.Stream;

public interface InReader {
    Stream<String> read();
    List<String> readFileAsListOfStrings(String fileName);
    void flushFile(String fileName);
}
