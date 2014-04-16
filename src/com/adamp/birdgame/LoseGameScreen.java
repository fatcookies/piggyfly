package com.adamp.birdgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;

/**
 * Created by adam on 15/02/14.
 */
public class LoseGameScreen implements Screen {
    private BirdGame game;

    private Pigeon pigeon;
    private PipePair pair;
    private boolean playing;
    private String quote;

    private SpriteBatch batch;
    private BitmapFont font;

    private OrthographicCamera camera;

    public LoseGameScreen(BirdGame g, Pigeon p, PipePair pair) {

        this.game = g;
        this.batch = game.batch;
        this.font = game.font;
        this.pigeon = p;
        this.pair = pair;
        playing = true;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, BirdGame.WIDTH, BirdGame.HEIGHT);
        quote = Resources.DEATH_QUOTES[(int) (Math.random() * Resources.DEATH_QUOTES.length)];
        Gdx.input.setInputProcessor(new GestureDetector(gestureAdapter));
        Gdx.gl.glClearColor(0f,0f,0f,0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    }

    @Override
    public void render(float v) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        boolean dead = pigeon.render(batch);

        if (playing) {
            if (!dead) {
                playing = false;
            }
        } else {

            font.setScale(3);
            font.draw(batch, quote, 20, 400);
            font.draw(batch, "Score: " + pair.getScore(), 400, 300);
            font.draw(batch, "Touch to try again", 400, 200);
        }

        batch.end();
    }


    GestureDetector.GestureAdapter gestureAdapter = new GestureDetector.GestureAdapter() {
        public boolean tap(float v, float v2, int i, int i2) {
            game.setScreen(new GameScreen(game));
            return true;
        }
    };

    @Override
    public void resize(int i, int i2) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
