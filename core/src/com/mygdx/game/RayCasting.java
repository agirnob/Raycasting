package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.List;

public class RayCasting {
    private final Player player;
    private final float incrementAngle;
    private final int[][] map;
    private ShapeRenderer shape;
    @SuppressWarnings("final")
    private List<Texture> textures = new ArrayList<>();

    public RayCasting(Player player, int[][] map, ShapeRenderer shapeRenderer, ArrayList<Texture> textures) {
        this.player = player;
        this.incrementAngle = (float) player.getFov() / Gdx.graphics.getWidth();
        this.map = map;
        this.shape = shapeRenderer;
        this.textures.addAll(textures);


    }

    public void raycasting() {
        double rayAngle = player.getAngle() - player.getHalfFov();
        Ray ray = new Ray(); // might cause problems didnt like it
        Utils utils = new Utils();
        shape.begin(ShapeRenderer.ShapeType.Line);
        int precision = 128;
        for (int rayCount = 0; rayCount < Gdx.graphics.getWidth(); rayCount++) {
            ray.x = player.getX();
            ray.y = player.getY();
            ray.rayCos = (Math.cos(utils.degreeToRadians(rayAngle)) / precision);
            ray.raySin = (Math.sin(utils.degreeToRadians(rayAngle)) / precision);
            int wall = 0;
            while (wall == 0) {
                ray.x += ray.rayCos;
                ray.y += ray.raySin;
                wall = map[(int) Math.floor(ray.y)][(int) Math.floor(ray.x)];
            }

            double distance = Math.sqrt(Math.pow((player.getX() - ray.x), 2) + Math.pow((player.getY() - ray.y), 2));
            distance = distance * Math.cos(utils.degreeToRadians(rayAngle - player.getAngle()));

            int wallHeight = (int) Math.floor(((double) Gdx.graphics.getHeight() / 2) / distance);

            double texturepositionX = Math.floor((textures.get(wall - 1).getWidth() * (ray.x + ray.y)) % textures.get(wall - 1).getWidth());


            shape.setColor(Color.DARK_GRAY);
            shape.line(rayCount, 0, rayCount, ((float) Gdx.graphics.getHeight() / 2));


            shape.setColor(Color.CYAN);
            shape.line(rayCount, (float) Gdx.graphics.getHeight() / 2, rayCount, Gdx.graphics.getHeight());

            drawTexture(rayCount, wallHeight, texturepositionX, textures.get(wall - 1));

            rayAngle += incrementAngle;
        }
        shape.end();
    }

    public void drawTexture(int x, int wallHeight, double texturepositionX, Texture texture) {
        double yIncrementer = (double) (wallHeight * 2) / (double)texture.getHeight();
        double y = ((double) Gdx.graphics.getHeight() / 2) - wallHeight;

        for (int i = texture.getHeight()-1; i >= 0; i--) {
            shape.setColor(texture.getColors().get(texture.getBitmap()[i][(int) texturepositionX]));
            shape.line((float) x, (float) y, (float) x, (float) (y + yIncrementer));
            y += yIncrementer;
        }

    }


    class Ray {
        double x;
        double y;
        double rayCos;
        double raySin;

        public Ray() {
            x = player.getX();
            y = player.getY();
        }
    }
}
