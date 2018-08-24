package com.mehrab.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mehrab.game.Flappy;

public class PlayState extends State {

    private Texture bird;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Texture("bird.png");

        cameraPreset.setToOrtho(
                false,
                Gdx.graphics.getWidth() / 4,
                Gdx.graphics.getHeight() / 4
        );
    }

    @Override
    protected void handleInput() {
    }

    @Override
    public void update(float time) {

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(cameraPreset.combined); // zoom in using the camera presets
        batch.begin();
        batch.draw(bird, 50, 50);
        batch.end();
    }

    @Override
    public void dispose() {
    }
}
