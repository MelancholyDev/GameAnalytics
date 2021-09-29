package com.simpleGame.back;

public class StageRecord {
    private int stage_number;
    private String level_name;
    //Start or stop
    private String event_type;

    public void setLevel_name(String level_name) {
        this.level_name = level_name;
    }

    public void setStage_number(int stage_number) {
        this.stage_number = stage_number;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public int getStage_number() {
        return stage_number;
    }

    public String getEvent_type() {
        return event_type;
    }

    public String getLevel_name() {
        return level_name;
    }
}
