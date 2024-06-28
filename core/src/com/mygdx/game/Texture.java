package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Texture {
    private int width = 8;
    private int height = 8;
    private com.badlogic.gdx.graphics.Texture texture;
    Pixmap pixmap;
    private int[][] bitmap;

    private List<Color> colors;

    public Texture(com.badlogic.gdx.graphics.Texture texture) {
        this.texture = texture;
        this.colors = new ArrayList<>();
        width = texture.getWidth();
        height = texture.getWidth();
        if (texture.getTextureData().isManaged()) {
            texture.getTextureData().prepare();
        }
        pixmap = texture.getTextureData().consumePixmap();
        for (int uniquePixmapValue : getUniquePixmapValues()) {
            colors.add(new Color(uniquePixmapValue));
        }
        bitmap = textureToBitmap();
    }

    public Texture() {

        bitmap = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 1, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 1, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 0, 0, 1, 0, 0}};
        colors = new ArrayList<>();
        colors.add(Color.FIREBRICK);
        colors.add(Color.LIGHT_GRAY);
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

    public List<Color> getColors() {
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

    public int[][] textureToBitmap() {
        int width = pixmap.getWidth();
        int height = pixmap.getHeight();
        int[][] mybadBitMap = new int[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int color = pixmap.getPixel(x, y);
                if (color == getUniquePixmapValues()[0]) {
                    mybadBitMap[y][x] = 0;
                }
                if (color== getUniquePixmapValues()[1]) {
                    mybadBitMap[y][x] = 1;
                }
                if (color == getUniquePixmapValues()[2]) {
                    mybadBitMap[y][x] = 2;
                }
            }
        }
        return mybadBitMap;
    }
}
