package com.akash.spaceshooter;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
public abstract class GameObject {
    protected float x, y;
    public float width, height;
    public boolean isDestroyed = false;
    public GameObject(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public abstract void update(float delta);
    public abstract void render(ShapeRenderer sr);
}