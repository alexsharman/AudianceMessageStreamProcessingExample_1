package org.exercise.one.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class OutModel {

    private String homeNo;
    private String channel;
    private String startTime;
    private String activity;
    private String endTime;
    private String duration;

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public OutModel(InModel current, InModel nextModel) {
        this.homeNo = current.getHomeNo();
        this.channel = current.getChannel();
        this.startTime = current.getStartTime();
        this.activity = current.getActivity();
        processPrevious(nextModel);
    }

    public OutModel(InModel current) {
        this.homeNo = current.getHomeNo();
        this.channel = current.getChannel();
        this.startTime = current.getStartTime();
        this.activity = current.getActivity();
        processLastOfDay();
    }

    private void processLastOfDay() {
        LocalDateTime st = LocalDateTime.parse(startTime, formatter);
        endTime = LocalDateTime.of(st.getYear(), st.getMonth(), st.getDayOfMonth(), 23, 59, 59).format(formatter);
        duration = String.valueOf(ChronoUnit.SECONDS.between(LocalDateTime.parse(startTime, formatter), LocalDateTime.parse(endTime, formatter)) + 1);
    }

    private void processPrevious(InModel previous) {
        endTime = LocalDateTime.parse(previous.getStartTime(), formatter).minusSeconds(1).format(formatter);
        duration = String.valueOf(ChronoUnit.SECONDS.between(LocalDateTime.parse(startTime, formatter), LocalDateTime.parse(endTime, formatter)) + 1);
    }

    public boolean hasCalculatedFields() {
        return endTime != null && duration != null;
    }

    public String getHomeNo() {
        return homeNo;
    }

    public void setHomeNo(String homeNo) {
        this.homeNo = homeNo;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return homeNo + '|' +
                channel + '|' +
                startTime + '|' +
                activity + '|' +
                endTime + '|' +
                duration;
    }
}
