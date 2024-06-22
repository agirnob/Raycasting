package com.mygdx.game;

import com.badlogic.gdx.Gdx;

public class RayCasting {
    private Player player;
    private float incrementAngle;
    private final int precision = 64;
    private final int[][] map;

    public RayCasting(Player player, int[][] map) {
        this.player = player;
        this.incrementAngle = (float) player.getFov() / Gdx.graphics.getWidth();
        this.map = map;
    }

    public void raycasting() {
        double rayAngle = player.getAngle() - player.getHalfFov();
        Ray ray = new Ray(); // might cause problems didnt like it
        Utils utils = new Utils();
        for (int rayCount = 0; rayCount < Gdx.graphics.getWidth(); rayCount++) {
            ray.x = player.getX();
            ray.y = player.getY();
            ray.rayCos = (Math.cos(utils.degreeToRadians(rayAngle)) / precision);
            ray.raySin = (Math.sin(utils.degreeToRadians(rayAngle)) / precision);
            int wall = 0;
            while (wall == 0){
                ray.x += ray.rayCos;
                ray.y += ray.raySin;
                wall = map[(int)Math.floor(ray.y)][(int)Math.floor(ray.x)];
            }
            rayAngle += incrementAngle;
        }
    }

    public void setIncrementAngle(float incrementAngle) {
        this.incrementAngle = incrementAngle;
    }

    public float getIncrementAngle() {
        return incrementAngle;
    }


    class Ray {
        float x;
        float y;
        double rayCos;
        double raySin;

        public Ray() {
            x = player.getX();
            y = player.getY();
        }
    }
}
