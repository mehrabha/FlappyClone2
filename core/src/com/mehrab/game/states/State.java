package com.mehrab.game.states;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

// Used by a game state (eg. Menu)
public abstract class State {
    protected final int SCREEN_WIDTH = 360;
    protected final int SCREEN_HEIGHT = 600;
    protected OrthographicCamera cameraPreset;
    protected GameStateManager stateManager;

    protected State(GameStateManager gsm) {
        stateManager = gsm;
        cameraPreset = new OrthographicCamera();
    }

    protected abstract void handleInput();
    public abstract void update();
    public abstract void render(SpriteBatch batch);
    public abstract void dispose();
}
