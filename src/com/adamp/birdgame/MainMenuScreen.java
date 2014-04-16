package com.adamp.birdgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;

/**
 * Created by adam on 14/02/14.
 */
public class MainMenuScreen implements Screen {

    private BirdGame g;
    private SpriteBatch batch;
    private BitmapFont font;
    private OrthographicCamera camera;

    public MainMenuScreen(BirdGame g) {
        this.g = g;
        this.batch = g.batch;
        this.font = g.font;

        Resources.name = new Texture(Gdx.files.internal("name.png"));
        Resources.back = new Texture(Gdx.files.internal("back.png"));
        camera = new OrthographicCamera();
        camera.setToOrtho(false, BirdGame.WIDTH, BirdGame.HEIGHT);

        Gdx.input.setInputProcessor(new GestureDetector(gestureAdapter));
    }

    @Override
    public void render(float v) {
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        font.setScale(5);
        batch.begin();
        batch.disableBlending();
        batch.draw(Resources.back, 0, 0, BirdGame.WIDTH, BirdGame.HEIGHT);
        batch.enableBlending();

        batch.draw(Resources.name, 0,BirdGame.HEIGHT/2);

        font.draw(batch, "TOUCH TO BEGIN", 200, 400);

        batch.end();
    }

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

    GestureDetector.GestureAdapter gestureAdapter = new GestureDetector.GestureAdapter() {
        public boolean tap(float v, float v2, int i, int i2) {
            g.setScreen(new GameScreen(g));
            return true;
        }
    };
}
