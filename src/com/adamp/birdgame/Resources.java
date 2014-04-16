package com.adamp.birdgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by adam on 14/02/14.
 */
public class Resources {

    public static Texture name = new Texture(Gdx.files.internal("name.png"));
    public static Texture spikes = new Texture(Gdx.files.internal("spikes.png"));
    public static Texture floor = new Texture(Gdx.files.internal("floorani.png"));
    public static Texture pipe = new Texture(Gdx.files.internal("penis.png"));
    public static Texture back = new Texture(Gdx.files.internal("back.png"));
    public static Texture pigeon = new Texture(Gdx.files.internal("pig.png"));
    public static TextureRegion pigeonRegion = new TextureRegion(pigeon);

    public static final String[] DEATH_QUOTES = {"This Sty ain't big enough for the two of us",
            "Looks like you're bacon",
            "Push Button, Recieve Bacon",
            "Pork chops for supper",
            "You stole my pig you hamburglar",
            "Not such an Ein-swine after all",
            "Call the Hambulance for this piggy",
            "The dinosaurs are visiting Jurassic Pork",
            "An easy piece of hamwork there",
            "Your martial art skills do not include Pork-chops",
            "You can't pig me around",
            "Pigs rotate when their dead?",
            "Spare me a rib",
            "Little Miss Piggy does not approve",
            "Cow is Pigs best friend",
            "gip is an anagram of pig",
            "Three is the magic pig number"};
}
