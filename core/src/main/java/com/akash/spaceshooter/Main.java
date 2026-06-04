package com.akash.spaceshooter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {

    GameManager game;
    ShapeRenderer shape;

    @Override
    public void create() {
        shape = new ShapeRenderer();
        game = new GameManager();
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();

        ScreenUtils.clear(1, 1, 1, 1);

        game.update(delta);

        shape.begin(ShapeRenderer.ShapeType.Filled);
        game.render(shape);
        shape.end();
    }

    @Override
    public void dispose() {
        shape.dispose();
    }
}