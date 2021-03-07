package org.exercise.one.processing;

import java.util.stream.Stream;

public interface InputMessageProcessing {
    void process(Stream<String> msgStream);
}
