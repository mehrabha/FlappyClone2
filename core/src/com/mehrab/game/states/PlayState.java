package com.mehrab.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mehrab.game.Flappy;
import com.mehrab.game.sprites.Bird;

public class PlayState extends State {
    private Bird birdObj;

    public PlayState(GameStateManager gsm) {
        super(gsm); // Declare cameraPreset object in the super class

        // Set initial bird position
        birdObj = new Bird(
                Gdx.graphics.getWidth() / 8,
                Gdx.graphics.getHeight() /8
        );

        cameraPreset.setToOrtho(
                false,
                Gdx.graphics.getWidth() / 4,
                Gdx.graphics.getHeight() / 4
        );
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            birdObj.flap();
        }
    }

    @Override
    public void update() {
        handleInput();
        birdObj.update(); // Update bird velocity and position
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(cameraPreset.combined); // zoom in using the camera presets
        batch.begin();
        // Draw bird based on it's position
        batch.draw(
                birdObj.getTexture(),
                birdObj.getPosition().x,
                birdObj.getPosition().y
        ); //
        batch.end();
    }

    @Override
    public void dispose() {
    }
}
