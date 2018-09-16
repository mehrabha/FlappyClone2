package com.mehrab.game;

import com.mehrab.game.states.GameStateManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mehrab.game.states.MenuState;

public class Flappy extends ApplicationAdapter {
    private GameStateManager stateManager;
    private SpriteBatch batch;

    @Override
    public void create () {
        batch = new SpriteBatch();
        stateManager = new GameStateManager();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        // push a new menu state into the stack upon launch
        stateManager.pushState(new MenuState(stateManager, batch));
    }

    @Override
    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // white screen

        // update and render the pushed state
        stateManager.update();
        stateManager.render();
    }

    @Override
    public void dispose () {
        stateManager.dispose();
    }
}
