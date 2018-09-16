package com.mehrab.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mehrab.game.Flappy;
import com.mehrab.game.sprites.Bird;
import com.mehrab.game.sprites.Ground;
import com.mehrab.game.sprites.Tube;
import java.util.ArrayList;

public class PlayState extends State {
    private Texture background;
    private Bird bird;
    private ArrayList<Ground> grounds;
    private ArrayList<Tube> tubes;
    private Boolean gameOver;

    public PlayState(GameStateManager gsm, SpriteBatch batch) {
        super(gsm, batch);
        cameraPreset.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);

        background = new Texture("bg.png");
        bird = new Bird(SCREEN_WIDTH, SCREEN_HEIGHT);
        grounds = new ArrayList();
        tubes = new ArrayList();
        gameOver = false;

        // Push 2 ground objects into the list
        for(int i = 0; i < 2; i++){
            grounds.add(new Ground());
        }

        grounds.get(0).setGroundPos(0); // Place one on the screen
        grounds.get(1).setGroundPos(SCREEN_WIDTH); // Place one to the right side of the screen

        // Push 3 tubes into the list
        for(int i = 0; i < 3; i++){
            tubes.add(new Tube(SCREEN_WIDTH, SCREEN_HEIGHT));
        }

        // Set tube starting position
        tubes.get(0).setTubePos(SCREEN_WIDTH * 2);
        tubes.get(1).setTubePos(SCREEN_WIDTH * 3 / 2);
        tubes.get(2).setTubePos(SCREEN_WIDTH);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            if(!gameOver) {
                bird.flap(SCREEN_HEIGHT);
            } else {
                /*
                //Push GameOver state to the stack
               stateManager.pushState(new GameOverState(stateManager)); TODO
               dispose(); TODO
                */
                if(bird.getPosition().y <= 0) {
                    stateManager.pushState(new PlayState(stateManager, batch));
                    dispose(); //TODO
                }
            }
        }
    }

    @Override
    public void update() {
        handleInput();
        bird.update(); // Move bird

        if(!gameOver) {
            for (int i = 0; i < 3; i++) {
                tubes.get(i).update(SCREEN_WIDTH); // Move tubes

                // if bird collides into tube
                if(tubes.get(i).checkCollision(bird.getCollisionBox())) {
                    gameOver = true;
                }
            }

            for (int i = 0; i < 2; i++) {
                grounds.get(i).update(SCREEN_WIDTH); // Move ground

                // if bird hits the ground
                if(grounds.get(i).checkCollision(bird.getCollisionBox())) {
                    gameOver = true;
                }
            }
        }
    }

    @Override
    public void render() {
        // Screen size set in the State super class.
        batch.setProjectionMatrix(cameraPreset.combined);

        batch.begin();
        batch.draw(background, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        // Draw tubes
        for(int i = 0; i < 3; i++) {
            batch.draw(
                    tubes.get(i).getTopTube(),
                    tubes.get(i).getTopTubePosition().x,
                    tubes.get(i).getTopTubePosition().y
            );

            batch.draw(
                    tubes.get(i).getBottomTube(),
                    tubes.get(i).getBottomTubePosition().x,
                    tubes.get(i).getBottomTubePosition().y
            );
        }

        // Draw ground
        for(int i = 0; i < 2; i++) {
            batch.draw(
                    grounds.get(i).getGroundTexture(),
                    grounds.get(i).getGroundPos().x,
                    grounds.get(i).getGroundPos().y
            );
        }

        // Draw bird based on it's position
        batch.draw(
                bird.getTexture(),
                bird.getPosition().x,
                bird.getPosition().y
        );
        batch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        bird.dispose();

        for(int i = 0; i < 2; i++) {
            grounds.get(i).dispose();
        }

        for(int i = 0; i < 3; i++) {
            tubes.get(i).dispose();
        }
    }
}
