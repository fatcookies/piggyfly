package com.adamp.birdgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adam on 12/02/14.
 */
public class PipePair {


    public static final float PIPE_WIDTH = 256f;
    public static final float dx = -10f;

    private class Pipe {
        private float x = BirdGame.WIDTH + PIPE_WIDTH;
        private float height;
        private float y;
        private Polygon bounds;
        private boolean top;

        public Pipe(float height, boolean top) {
            this.height = height;
            this.top = top;
            if (top) {
                y = BirdGame.HEIGHT - height;
            } else {
                y = start;
            }
            bounds = new Polygon(new float[]{0, 0, PIPE_WIDTH, 0, 0, height,
                    PIPE_WIDTH, height});
            bounds.setPosition(x, y);
        }

        public boolean render(SpriteBatch batch) {
            x += dx;
            bounds.setPosition(x, y);

            batch.draw(Resources.pipe, x, y, PIPE_WIDTH, height);
            batch.draw(Resources.spikes, x, top ? y - Resources.spikes.getHeight() * 4: y + height, PIPE_WIDTH, Resources.spikes.getHeight() * 4);

            if (x < -PIPE_WIDTH) {
                return false;
            }

            return true;
        }

        public Polygon getBounds() {
            return bounds;
        }


    }

    private float space;
    private float start;
    private Pipe top;
    private Pipe bottom;

    private int score;

    public PipePair(float start, float space) {
        Resources.pipe = new Texture(Gdx.files.internal("penis.png"));
        Resources.spikes = new Texture(Gdx.files.internal("spikes.png"));
        this.space = space;
        this.start = start;
        changePipes();
        score = 0;
    }

    public void render(SpriteBatch batch) {
        if (!top.render(batch) || !bottom.render(batch)) {
            changePipes();
        }
    }

    public List<Polygon> getBounds() {
        return new ArrayList<Polygon>() {
            {
                add(top.getBounds());
                add(bottom.getBounds());
            }
        };
    }

    private void changePipes() {
        float topHeight = (float) Math.random() * (BirdGame.HEIGHT - PIPE_WIDTH - start - 100);
        float bottomHeight = BirdGame.HEIGHT - topHeight - space;
        top = new Pipe(topHeight, true);
        bottom = new Pipe(bottomHeight, false);
        score++;
    }

    public int getScore() {
        return score;
    }

}
