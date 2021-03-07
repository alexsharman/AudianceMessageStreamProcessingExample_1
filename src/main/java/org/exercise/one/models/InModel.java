package org.exercise.one.models;

public class InModel {

    private String homeNo;
    private String channel;
    private String startTime;
    private String activity;

    public InModel(String homeNo, String channel, String startTime, String activity) {
        this.homeNo = homeNo;
        this.channel = channel;
        this.startTime = startTime;
        this.activity = activity;
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
}
