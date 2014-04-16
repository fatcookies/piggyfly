package com.adamp.birdgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by adam on 12/02/14.
 */
public class Floor {

    Animation ani;
    TextureRegion[] tex;
    float stateTime;

    public Floor() {

        Resources.floor = new Texture(Gdx.files.internal("floorani.png"));
        TextureRegion[][] reg = TextureRegion.split(Resources.floor,96,10);

        tex = new TextureRegion[reg[0].length * reg.length];

        int index = 0;
        for (int i = 0; i < reg.length; i++) {
            for (int j = 0; j < reg[0].length; j++) {
                tex[index++] = reg[i][j];
            }
        }
        ani = new Animation(0.110f,tex);
        stateTime = 0f;
    }

    public void render(SpriteBatch batch) {
        stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion frame = ani.getKeyFrame(stateTime, true);
        batch.draw(frame,0,0,BirdGame.WIDTH,100);
    }
}
