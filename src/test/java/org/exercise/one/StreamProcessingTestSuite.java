package org.exercise.one;

import org.exercise.one.models.OutModel;
import org.exercise.one.processing.InFileReader;
import org.exercise.one.processing.InReader;
import org.exercise.one.processing.StreamProcessing;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;


public class StreamProcessingTestSuite {

    private StreamProcessing streamProcessing;
    private InReader inReader;
    private static final String OUTPUT_FILE_NAME = "output_messages.txt";

    @Before
    public void setUp() {
        streamProcessing = new StreamProcessing();
        inReader = new InFileReader();
    }

    @Test
    public void givenInputStreamCheckNotEmpty() {
        Assert.assertTrue(inReader.read().findFirst().get() != null);
    }

    @Test
    public void givenInputCheckIfAllLinesExistInOutputFile() {
        //Given
        streamProcessing.process(inReader.read());
        //When
        int outputLines = inReader.readFileAsListOfStrings(OUTPUT_FILE_NAME).size();
        inReader.flushFile(OUTPUT_FILE_NAME);
        //Then
        Assert.assertTrue(outputLines == 4);
    }

    @Test
    public void givenProcessFileCheckHasCalculatedFields() {
        //Given
        streamProcessing.process(inReader.read());
        //When
        List<OutModel> outModels = inReader.readFileAsListOfStrings(OUTPUT_FILE_NAME).stream()
                .map(message -> streamProcessing.processSingleMessage(message))
                .collect(Collectors.toList());
        inReader.flushFile(OUTPUT_FILE_NAME);
        //Then
        boolean result = !outModels.stream().map(o -> o.hasCalculatedFields()).collect(Collectors.toList()).contains(false);
        Assert.assertTrue(result);
    }

}
