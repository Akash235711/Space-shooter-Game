package com.akash.spaceshooter;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Enemy extends GameObject {

    public Enemy(float x, float y) {
        super(x, y);
        width = 30;
        height = 30;
    }

    @Override
    public void update(float delta) {
        y -= 150 * delta;
    }

    @Override
    public void render(ShapeRenderer sr) {
        sr.setColor(Color.RED);
        sr.rect(x, y, width, height);
    }
}