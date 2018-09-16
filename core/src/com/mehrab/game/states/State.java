package com.mehrab.game.states;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

// Used by a game state (eg. Menu)
public abstract class State {
    protected final int SCREEN_WIDTH = 360;
    protected final int SCREEN_HEIGHT = 600;
    protected GameStateManager stateManager;
    protected SpriteBatch batch;
    protected OrthographicCamera cameraPreset;


    protected State(GameStateManager gsm, SpriteBatch sb) {
        stateManager = gsm;
        batch = sb;
        cameraPreset = new OrthographicCamera();
    }

    protected abstract void handleInput();
    public abstract void update();
    public abstract void render();
    public abstract void dispose();
}
