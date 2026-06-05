package com.akash.spaceshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

import java.util.ArrayList;

public class GameManager {

    private enum GameState {
        START,
        RUNNING,
        GAME_OVER
    }

    Player player;
    ArrayList<GameObject> objects = new ArrayList<>();

    float enemyTimer = 0;
    int score = 0;
    int highScore = 0;
    boolean showHighScorePopup = false;
    float highScorePopupTimer = 0;
    boolean highScorePopupShownThisGame = false;

    GameState state = GameState.START;

    BitmapFont font = new BitmapFont();
    SpriteBatch batch = new SpriteBatch();
    GlyphLayout layout = new GlyphLayout();

    public GameManager() {
        resetGame();
        state = GameState.START;
    }

    private void resetGame() {
        objects.clear();
        player = new Player(300, 200);
        objects.add(player);
        enemyTimer = 0;
        score = 0;
        showHighScorePopup = false;
        highScorePopupTimer = 0;
        highScorePopupShownThisGame = false;
    }

    public void spawnEnemy() {
        objects.add(new Enemy(MathUtils.random(0, 750), 600));
    }

    public void update(float delta) {
        if (state == GameState.START) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) ||
                Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                state = GameState.RUNNING;
            }
            return;
        }

        if (state == GameState.GAME_OVER) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) ||
                Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                resetGame();
                state = GameState.RUNNING;
            }
            return;
        }

        enemyTimer += delta;
        if (enemyTimer > 1f) {
            spawnEnemy();
            enemyTimer = 0;
        }

        for (GameObject obj : objects) {
            obj.update(delta);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            objects.add(player.shoot());
        }

        checkCollisions();

        if (showHighScorePopup) {
            highScorePopupTimer -= delta;
            if (highScorePopupTimer <= 0) {
                showHighScorePopup = false;
            }
        }

        objects.removeIf(obj -> obj.isDestroyed);
    }

    private void checkCollisions() {

        for (int i = 0; i < objects.size(); i++) {
            GameObject a = objects.get(i);

            for (int j = i + 1; j < objects.size(); j++) {
                GameObject b = objects.get(j);
                if (a.isDestroyed || b.isDestroyed) {
                    continue;
                }

                if ((a instanceof Bullet && b instanceof Enemy) ||
                    (a instanceof Enemy && b instanceof Bullet)) {

                    if (a.getBounds().overlaps(b.getBounds())) {
                        a.isDestroyed = true;
                        b.isDestroyed = true;
                        score++;
                        if (score > highScore) {
                            highScore = score;
                            if (!highScorePopupShownThisGame) {
                                showHighScorePopup = true;
                                highScorePopupTimer = 2f;
                                highScorePopupShownThisGame = true;
                            }
                        }
                    }
                }
                if ((a instanceof Enemy && b instanceof Player) ||
                    (a instanceof Player && b instanceof Enemy)) {

                    if (a.getBounds().overlaps(b.getBounds())) {
                        state = GameState.GAME_OVER;
                        return;
                    }
                }
            }
        }
    }

    private void drawCenteredText(String text, float y, float scale, Color color) {
        font.getData().setScale(scale);
        font.setColor(color);
        layout.setText(font, text);
        float x = (Gdx.graphics.getWidth() - layout.width) / 2f;
        font.draw(batch, text, x, y);
        font.getData().setScale(1f);
        font.setColor(Color.WHITE);
    }

    public void render(ShapeRenderer sr) {

        for (GameObject obj : objects) {
            obj.render(sr);
        }

        batch.begin();

        font.draw(batch, "Score: " + score, 20, 40);
        font.draw(batch, "High Score: " + highScore, 20, 70);

        if (showHighScorePopup) {
            font.getData().setScale(2f);
            font.draw(batch, "NEW HIGH SCORE!", 180, 380);
            font.getData().setScale(1f);
        }

        if (state == GameState.START) {
            drawCenteredText("PRESS ENTER TO START", 320, 2f, Color.WHITE);
        } else if (state == GameState.GAME_OVER) {
            drawCenteredText("GAME OVER", 330, 3f, Color.RED);
            drawCenteredText("Score: " + score, 295, 1.5f, Color.RED);
            drawCenteredText("PRESS ENTER TO RESTART", 255, 1.5f, Color.RED);
        }

        batch.end();
    }
}