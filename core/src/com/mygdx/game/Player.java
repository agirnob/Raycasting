package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player {
    private final int fov = 60;
    private double x = 2, y = 2;
    private double angle = 90;
    double movement = 0.1;
    double rotation = 5;
    Utils utils = new Utils();
    int[][] map;

    public Player(int[][] map) {
        this.map = map;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public int getFov() {
        return fov;
    }

    public int getHalfFov() {
        return fov / 2;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getAngle() {
        return angle;
    }

    public void movement() {
        if ((Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.A)) || (Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.D)) || Gdx.input.isKeyPressed(Input.Keys.W)) {

            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                setAngle(getAngle() - rotation);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                setAngle(getAngle() + rotation);
            }
            double playerCos = Math.cos(utils.degreeToRadians(getAngle())) * movement;
            double playerSin = Math.sin(utils.degreeToRadians(getAngle())) * movement;

            double newX = getX() + playerCos;
            double newY = getY() + playerSin;
            if (map[(int) Math.floor(newY)][(int) Math.floor(newX)] == 0) {
                setX(newX);
                setY(newY);
            }
        } else if ((Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.A)) || (Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.D)) || Gdx.input.isKeyPressed(Input.Keys.S)) {
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                setAngle(getAngle() - rotation);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                setAngle(getAngle() + rotation);
            }

            double playerCos = Math.cos(utils.degreeToRadians(getAngle())) * movement;
            double playerSin = Math.sin(utils.degreeToRadians(getAngle())) * movement;

            double newX = getX() - playerCos;
            double newY = getY() - playerSin;
            if (map[(int) Math.floor(newY)][(int) Math.floor(newX)] == 0) {
                setX(newX);
                setY(newY);
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            setAngle(getAngle() - rotation);
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            setAngle(getAngle() + rotation);
        }
    }
}
