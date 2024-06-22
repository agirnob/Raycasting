package com.mygdx.game;

public class Player {
    private final int fov = 60;
    private float x = 2, y = 2;
    private int angle = 90;

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public int getFov() {
        return fov;
    }

    public int getHalfFov() {
        int halfFov = fov / 2;
        return halfFov;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getAngle() {
        return angle;
    }
}
