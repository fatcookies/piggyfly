package com.adamp.birdgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by adam on 12/02/14.
 */
public class BirdGame extends Game {

    public static final int HEIGHT = 1600;
    public static final int WIDTH = 960;

    public SpriteBatch batch;
    public BitmapFont font;


    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.WHITE);

        setScreen(new MainMenuScreen(this));
    }

    @Override
    public void dispose() {
        super.dispose();
        Resources.pigeon.dispose();
        Resources.back.dispose();
        Resources.floor.dispose();
        Resources.pipe.dispose();
    }

    @Override
    public void pause() {
        super.pause();

    }

    @Override
    public void resume() {
        super.resume();
        setScreen(new MainMenuScreen(this));
    }
}
