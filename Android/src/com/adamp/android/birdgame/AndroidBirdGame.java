package com.adamp.android.birdgame;

import android.os.Bundle;
import com.adamp.birdgame.BirdGame;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

/**
 * Created by adam on 12/02/14.
 */
public class AndroidBirdGame extends AndroidApplication
{


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        cfg.useAccelerometer = false;
        cfg.useCompass = false;
        cfg.useWakelock = true;
        cfg.useGL20 = true;
        initialize(new BirdGame(), cfg);
    }
}
