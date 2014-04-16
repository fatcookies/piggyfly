package com.adamp.birdgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by adam on 12/02/14.
 */
public class Pigeon {


    private int height;
    private int width;
    public static final float DY = -10f;
    private float x;
    private float y;
    private float dy;
    private float risingDy;
    private float rot;
    private float drot;
    Polygon rect;
    int riseCounter = 0;


    public Pigeon(float x, float y) {
        Resources.pigeon = new Texture(Gdx.files.internal("pig.png"));
        Resources.pigeonRegion = new TextureRegion(Resources.pigeon);
        this.height = Resources.pigeon.getHeight();
        this.width = Resources.pigeon.getWidth();
        this.x = x;
        this.y = y;
        this.dy = DY;
        rot =0;
        drot = 0;
        this.rect = new Polygon(new float[] {0, 0, width, 0, 0, height-40, width, height-40});
        rect.setPosition(x,y);
    }

    public boolean render(SpriteBatch batch) {
        boolean phys = calculatePhysics();
        batch.draw(Resources.pigeonRegion, x, y, width,height,width,height,1,1,rot);
        return phys;
    }

    public void rise() {
        riseCounter = 10;
        risingDy = 10;
        dy = 0;
    }

    private boolean calculatePhysics() {
        if (riseCounter > 0) {
            risingDy++;
            y += risingDy;
            drot = 2;
            rot += drot;

            riseCounter--;
        } else {
            dy-= 0.75;
            y += dy;

            drot = -2;
            rot += drot;
        }

        rot = dy + risingDy;
        rect.setRotation(rot);
        rect.setPosition(x,y);
        return checkCollision();
    }

    public Polygon getBounds() {
        return rect;
    }

    private boolean checkCollision() {
        if (y <= 100) {
            y = 100;
            rect.setPosition(x,y);
            return false;
        }
        if (y >= BirdGame.HEIGHT - height) {
            y = BirdGame.HEIGHT - height;
            rect.setPosition(x,y);
        }
        return true;
    }


}
