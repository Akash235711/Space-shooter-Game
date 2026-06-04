package com.akash.spaceshooter;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Bullet extends GameObject {

    private static final float RADIUS = 6f;

    public Bullet(float x, float y) {
        super(x, y);
        width = RADIUS * 2;
        height = RADIUS * 2;
    }

    @Override
    public void update(float delta) {
        y += 400 * delta;
    }

    @Override
    public void render(ShapeRenderer sr) {
        sr.setColor(Color.BLUE);
        sr.circle(x + width / 2f, y + height / 2f, RADIUS);
    }
}