package com.adamp.birdgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;

/**
 * Created by adam on 12/02/14.
 */
public class GameScreen implements Screen {


    private BirdGame game;
    private OrthographicCamera camera;
    private PipePair pipePair;
    private Pigeon pigeon;
    private Floor floor;

    private SpriteBatch batch;
    private BitmapFont font;

    boolean dying;
    boolean playing;


    public GameScreen(BirdGame g) {
        this.game = g;
        this.batch = game.batch;
        this.font = game.font;

        Resources.back = new Texture(Gdx.files.internal("back.png"));
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, BirdGame.WIDTH, BirdGame.HEIGHT);
        pipePair = new PipePair(100f, 500f);
        pigeon = new Pigeon(100f, 800f);
        playing = true;
        dying = false;
        floor = new Floor();

        Gdx.input.setInputProcessor(new GestureDetector(new GameGestureListener(pigeon)));
    }


    @Override
    public void render(float v) {
        if (playing && !dying) {
            camera.update();
            batch.setProjectionMatrix(camera.combined);

            batch.begin();

            batch.disableBlending();
            batch.draw(Resources.back, 0, 0, BirdGame.WIDTH, BirdGame.HEIGHT);
            batch.enableBlending();

            pipePair.render(batch);
            floor.render(batch);
            font.setScale(9);
            font.draw(batch, Integer.toString(pipePair.getScore()), 480, 1200);

            if (!pigeon.render(batch)) {
                playing = false;
            }

            batch.end();


            if (Gdx.input.isTouched()) {
                pigeon.rise();
            }

            for (Polygon p : pipePair.getBounds()) {
                if (Intersector.overlapConvexPolygons(p,pigeon.getBounds())) {
                    dying = true;
                    Gdx.input.setInputProcessor(null);
                }
            }

            if (!playing) {
                dispose();
            }
        }

        if(dying && playing) {
            dispose();
        }
    }

    @Override
    public void resize(int i, int i2) {

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
        game.setScreen(new LoseGameScreen(game,pigeon,pipePair));
    }

}
