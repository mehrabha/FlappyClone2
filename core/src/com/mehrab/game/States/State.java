package com.mehrab.game.States;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

// Used by a game state (eg. Menu)
public abstract class State {
    protected OrthographicCamera camera;
    protected GameStateManager stateManager;

    protected State(GameStateManager gsm) {
        stateManager = gsm; // Pass on
        camera = new OrthographicCamera();
    }

    protected abstract void handleInput();
    public abstract void update(float time);
    public abstract void render(SpriteBatch batch);
    public abstract void dispose(SpriteBatch batch);
}
