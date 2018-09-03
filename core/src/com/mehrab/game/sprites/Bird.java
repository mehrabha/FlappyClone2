package com.mehrab.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Bird {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 gravity;

    private Texture bird;

    public Bird(int screenWidth, int screenHeight){
        // Set bird coordinates based on the provided screen size
        velocity = new Vector2(0, 0);
        gravity = new Vector2(0, -18);
        bird = new Texture("bird.png");

        position = new Vector2(
                (screenWidth - bird.getWidth()) / 2,
                (screenHeight - bird.getHeight()) / 2
        );
    }

    public void update(){
        if(velocity.y > -450) {
            velocity.add(gravity); // Increase velocity magnitude with time
        }

        if (Gdx.input.justTouched() && position.y <= 0){
            position.y = 1; // Prevent the bird from being stuck to the bottom of the screen
        }

        if(position.y > 0) { // Keep the bird from falling out of the screen
            float deltaTime = Gdx.graphics.getDeltaTime(); // get time between each frame

            // Update bird position based on velocity.
            // Scale velocity with deltaTime to ensure constant bird speeds across all devices
            position.add(0, velocity.y * deltaTime);
        }

    }

    public Vector2 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return bird;
    }

    public void flap(int screenHeight) {
        // set velocity on the positive direction while the bird is inside the screen
        if(position.y < screenHeight - bird.getHeight()) {
            velocity.y = 400;
        }
    }
}
