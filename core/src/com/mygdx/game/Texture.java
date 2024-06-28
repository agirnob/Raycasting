package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;

import java.util.HashSet;
import java.util.Set;

public class Texture {
    private int width = 8;
    private int height = 8;
    private com.badlogic.gdx.graphics.Texture texture;

    private int[][] bitmap = {
            {1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 0, 0, 0, 1, 0, 0}
    };

    private Color[] colors = {Color.FIREBRICK, Color.LIGHT_GRAY};

    public Texture(com.badlogic.gdx.graphics.Texture texture) {
        this.texture = texture;
        width = texture.getWidth();
        height = texture.getWidth();
    }

    public Texture() {
    }

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

    public int[] getUniquePixmapValues() {
        if (texture.getTextureData().isManaged()) {
            texture.getTextureData().prepare();
        }
        Pixmap pixmap = texture.getTextureData().consumePixmap();
        Set<Integer> uniqueValues = new HashSet<>();

        int width = pixmap.getWidth();
        int height = pixmap.getHeight();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int color = pixmap.getPixel(x, y);
                uniqueValues.add(color);
            }
        }

        int[] uniqueValuesArray = new int[uniqueValues.size()];
        int i = 0;
        for (Integer value : uniqueValues) {
            uniqueValuesArray[i++] = value;
        }

        pixmap.dispose();
        return uniqueValuesArray;
    }
}
