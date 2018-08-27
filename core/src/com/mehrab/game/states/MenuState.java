package com.mehrab.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuState extends State{
    private Texture background;
    private Texture playButton;

    public MenuState(GameStateManager gsm) {
        super(gsm); // gsm is stored in the variable stateManager

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
        batch.begin(); // Open container

        // draw objects
        batch.draw(
                background,
                0,
                0,
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight()
        );

        batch.draw(
                playButton,
                (Gdx.graphics.getWidth() - playButton.getWidth()) / 2.2f,
                (Gdx.graphics.getHeight()- playButton.getHeight()) / 2.2f,
                playButton.getWidth() * 2.2f,
                playButton.getHeight() * 2.2f
        );

        batch.end(); // Close container

    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
    }
}
