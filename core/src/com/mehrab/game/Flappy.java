package com.mehrab.game;

import com.mehrab.game.States.GameStateManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Flappy extends ApplicationAdapter {
	//private GameStateManager stateManager;
	private SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//stateManager = new GameStateManager();
	}

	@Override
	public void render () {
		//stateManager.update(Gdx.graphics.getDeltaTime()); // Provide time between each frame
		//stateManager.render(batch); // Provide the batch file
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
