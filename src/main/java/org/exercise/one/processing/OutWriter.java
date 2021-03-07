package org.exercise.one.processing;

import org.exercise.one.models.OutModel;

import java.util.List;
import java.util.stream.Stream;

public interface OutWriter {

    void write(Stream<String> outModels);

    void writeList(List<OutModel> out);

    void close();
}
