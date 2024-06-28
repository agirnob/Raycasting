package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private int[][] map;
    private ShapeRenderer shapeRenderer;
    private Utils utils;
    private Texture wallTexture;
    private List<com.mygdx.game.Texture> textureList = new ArrayList<>();
    RayCasting ray;
    Player player;

    @Override
    public void create() {
        utils = new Utils();
        batch = new SpriteBatch();
        textureList = (List<com.mygdx.game.Texture>) utils.loadTextures().clone();
        map =utils.getTheMap();
        player = new Player(map);
        shapeRenderer = new ShapeRenderer();
        ray = new RayCasting(player, map, shapeRenderer, (ArrayList<com.mygdx.game.Texture>) textureList);

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
        // img.dispose();
        wallTexture.dispose();
        shapeRenderer.dispose();
    }


}

