package com.adamp.birdgame;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by adam on 12/02/14.
 */
public class GameGestureListener implements GestureDetector.GestureListener {

    private Pigeon p;

    public GameGestureListener(Pigeon p) {
        this.p = p;
    }

    @Override
    public boolean touchDown(float v, float v2, int i, int i2) {

        return true;
    }

    @Override
    public boolean tap(float v, float v2, int i, int i2) {
        p.rise();
        return true;
    }

    @Override
    public boolean longPress(float v, float v2) {

        return false;
    }

    @Override
    public boolean fling(float v, float v2, int i) {
        return false;
    }

    @Override
    public boolean pan(float v, float v2, float v3, float v4) {
        return false;
    }

    @Override
    public boolean panStop(float v, float v2, int i, int i2) {
        return false;
    }

    @Override
    public boolean zoom(float v, float v2) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 vector2, Vector2 vector22, Vector2 vector23, Vector2 vector24) {
        return false;
    }
}
