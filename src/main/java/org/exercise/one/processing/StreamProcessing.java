package org.exercise.one.processing;

import org.exercise.one.models.InModel;
import org.exercise.one.models.OutModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StreamProcessing implements InputMessageProcessing {

    private HashMap<String, InModel> inMsg = new HashMap<>();
    private OutWriter outWriter = new OutFileWriter();

    public OutModel processSingleMessage(String msg) {
        String[] parts = msg.split("\\|");
        InModel inModel = new InModel(parts[0], parts[1], parts[2], parts[3]);
        return keepMapOrProcess(inModel);
    }

    private void endOfDay() {
        List<OutModel> leftOverModelsAtEndOfDay = new ArrayList<>();
        for (Map.Entry<String, InModel> entry : inMsg.entrySet()) {
            leftOverModelsAtEndOfDay.add(new OutModel(entry.getValue()));
        }
        processWriteOutput(leftOverModelsAtEndOfDay.stream().map(out -> out.toString()));
    }

    private OutModel keepMapOrProcess(InModel inModel) {
        if (isInList(inModel)) {
            return processExisting(inModel);
        } else {
            inMsg.put(inModel.getHomeNo(), inModel);
            return null;
        }
    }

    private OutModel processExisting(InModel inModel) {
        OutModel outModel = new OutModel(inMsg.get(inModel.getHomeNo()), inModel);
        inMsg.put(inModel.getHomeNo(), inModel);
        return outModel;
    }

    private boolean isInList(InModel inModel) {
        return inMsg.containsKey(inModel.getHomeNo());
    }


    private void processWriteOutput(Stream<String> oms) {
        outWriter.write(oms);
    }

    @Override
    public void process(Stream<String> messageStream) {
        Stream<OutModel> outStream = messageStream
                .map(m -> processSingleMessage(m));

        Stream<String> outStringStream = outStream
                .filter(f -> f != null)
                .map(s -> s.toString());

        processWriteOutput(outStringStream);
        endOfDay();
        outWriter.close();
    }
}
