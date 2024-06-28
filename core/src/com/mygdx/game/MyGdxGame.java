package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    RayCasting ray;
    Player player;

    @Override
    public void create() {
        Utils utils = new Utils();
        batch = new SpriteBatch();
        ArrayList<com.mygdx.game.Texture> textureList = utils.loadTextures();
        int[][] map = utils.getTheMap();
        player = new Player(map);
        shapeRenderer = new ShapeRenderer();
        ray = new RayCasting(player, map, shapeRenderer, textureList);

    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 1, 1, 1);
        player.movement();
        ray.raycasting();
    }


    @Override
    public void dispose() {
        batch.dispose();
        shapeRenderer.dispose();
    }


}

