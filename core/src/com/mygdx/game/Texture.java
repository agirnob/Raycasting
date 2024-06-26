package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Colors;

public class Texture {
    private final int width = 8;
    private final int height =8;
    private final int[][] bitmap = {
            {1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 0, 0, 0, 1, 0, 0}
    };
    private final Color[] colors = {Color.FIREBRICK, Color.LIGHT_GRAY};

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getBitmap() {
        return bitmap;
    }

    public Color[] getColors() {
        return colors;
    }
}
