package com.simpleGame.back;

public class LevelRecord {
    private String level_name;
    private int level_number;
    //start or end level
    private String event_type;

    public int getLevel_Number() {
        return level_number;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getLevel_name() {
        return level_name;
    }


    public void setLevel_name(String level_name) {
        this.level_name = level_name;
    }

    public void setLevel_Number(int level_Number) {
        this.level_number = level_Number;
    }
}
