package org.exercise.one;

import org.exercise.one.processing.InFileReader;
import org.exercise.one.processing.InReader;
import org.exercise.one.processing.InputMessageProcessing;
import org.exercise.one.processing.StreamProcessing;

public class Main {

    /*
    Created by Alexander Sharman 7 March 2021

    This did not take me 15-20 minutes ;-)
     */

    private static InputMessageProcessing streamProcessing = new StreamProcessing();
    private static InReader fileReader = new InFileReader();

    public static void main(String[] args) {
        streamProcessing.process(fileReader.read());
    }

}
