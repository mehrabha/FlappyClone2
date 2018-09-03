package com.mehrab.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mehrab.game.Flappy;
import com.mehrab.game.sprites.Bird;
import com.mehrab.game.sprites.Tube;

public class PlayState extends State {
    private Texture background;
    private Bird bird;
    private Tube tube;

    public PlayState(GameStateManager gsm) {
        super(gsm); // CameraPreset object declared in the super class

        cameraPreset.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);

        background = new Texture("bg.png");

        // Place bird on the center
        bird = new Bird(SCREEN_WIDTH, SCREEN_HEIGHT);

        // Set tube horizontal position
        tube = new Tube(SCREEN_WIDTH / 2, SCREEN_WIDTH, SCREEN_HEIGHT);
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            bird.flap(SCREEN_HEIGHT); // Flap on touch
        }
    }

    @Override
    public void update() {
        handleInput();
        bird.update(); // Update bird velocity and position
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(cameraPreset.combined); // Zoom in
        batch.begin();

        batch.draw(background, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        // Draw tubes
        batch.draw(
                tube.getTopTube(),
                tube.getTopTubePosition().x,
                tube.getTopTubePosition().y
        );

        batch.draw(
                tube.getBottomTube(),
                tube.getBottomTubePosition().x,
                tube.getBottomTubePosition().y
        );


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
    }
}
