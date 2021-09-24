package com.simpleGame.back;

public class DeathRecord {
    private String level;
    private float x;
    private float y;
    private float z;

    public float getX() {
        return x;
    }

    public float getZ() {
        return z;
    }

    public float getY() {
        return y;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y){
        this.y=y;
    }

    public void setZ(float z){
        this.z=z;
    }
}
