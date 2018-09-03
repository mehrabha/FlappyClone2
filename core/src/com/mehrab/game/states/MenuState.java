package com.mehrab.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuState extends State{
    private Texture background;
    private Texture playButton;

    public MenuState(GameStateManager gsm) {
        super(gsm); // gsm is stored in the variable stateManager

        cameraPreset.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
        background = new Texture("bg.png");
        playButton = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            // push a new play state into the stack when screen is touched
            stateManager.pushState(new PlayState(stateManager));

            // dump loaded menu textures
            dispose();
        }
    }

    @Override
    public void update() {
        handleInput();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(cameraPreset.combined); // Zoom in
        batch.begin();

        // Draw objects
        batch.draw(
                background,
                0,
                0,
                SCREEN_WIDTH,
                SCREEN_HEIGHT
        );

        batch.draw(
                playButton,
                (SCREEN_WIDTH - playButton.getWidth()) / 2,
                (SCREEN_HEIGHT - playButton.getHeight()) / 2
        );

        batch.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
    }
}
