package com.akash.spaceshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Player extends GameObject {

    public Player(float x, float y) {
        super(x, y);
        width = 30;
        height = 30;
    }

    public Bullet shoot() {
        return new Bullet(x, y + 20);
    }

    @Override
    public void update(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) x -= 300 * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) x += 300 * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) y += 300 * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) y -= 300 * delta;
    }

    @Override
    public void render(ShapeRenderer sr) {
        sr.setColor(Color.GREEN);
        sr.triangle(
            x, y + 20,
            x - 15, y - 15,
            x + 15, y - 15
        );
    }
}