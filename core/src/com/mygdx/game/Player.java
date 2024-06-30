package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import lombok.Getter;
import lombok.Setter;

public class Player {
    @Getter
    private final int fov = 60;
    double movement = 0.1;
    double rotation = 5;
    Utils utils = new Utils();
    int[][] map;

    @Getter
    @Setter
    private double x = 2, y = 2;

    @Getter
    @Setter
    private double angle = 90;
    private double radious = 10;

    public Player(int[][] map) {
        this.map = map;

    }

    public int getHalfFov() {
        return fov / 2;
    }

    public void movement() {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            double playerCos = Math.cos(utils.degreeToRadians(getAngle())) * movement;
            double playerSin = Math.sin(utils.degreeToRadians(getAngle())) * movement;
            double newX = getX() + playerCos;
            double newY = getY() + playerSin;

            double checkX = Math.floor(newX + playerCos * radious);
            double checkY = Math.floor(newY + playerSin * radious);

            if (map[(int) checkY][(int) Math.floor((getX()))] == 0) {
                setY(newY);
            }
            if (map[(int) Math.floor(getY())][(int) checkX] == 0) {
                setX(newX);
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            double playerCos = Math.cos(utils.degreeToRadians(getAngle())) * movement;
            double playerSin = Math.sin(utils.degreeToRadians(getAngle())) * movement;
            double newX = getX() - playerCos;
            double newY = getY() - playerSin;

            double checkX = Math.floor(newX - playerCos * radious);
            double checkY = Math.floor(newY - playerSin * radious);

            if (map[(int) checkY][(int) Math.floor((getX()))] == 0) {
                setY(newY);
            }
            if (map[(int) Math.floor(getY())][(int) checkX] == 0) {
                setX(newX);
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            setAngle(getAngle() - rotation);
            angle = angle % 360;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            setAngle(getAngle() + rotation);
            angle = angle % 360;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.Q)){
            Gdx.app.exit();
            System.exit(-1);
        }
    }
}
