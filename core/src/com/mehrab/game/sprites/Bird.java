package com.mehrab.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bird {
    private final int GRAVITY = -18;
    private final int MAX_FALL_VELOCITY = -500;
    private final int JUMP_VELOCITY = 380;

    private Vector2 position;
    private Vector2 velocity;
    private Texture bird;
    private Rectangle birdCollisionBox;

    public Bird(int screenWidth, int screenHeight){
        // Set bird coordinates based on the provided screen size
        velocity = new Vector2(0, 0);
        bird = new Texture("bird.png");

        position = new Vector2(
                (screenWidth - bird.getWidth()) / 3,
                (screenHeight - bird.getHeight()) / 2
        );

        birdCollisionBox = new Rectangle(
                screenWidth,
                screenHeight,
                bird.getWidth(),
                bird.getHeight()
        );
    }

    public void update(){
        if(velocity.y > MAX_FALL_VELOCITY) {
            velocity.add(0, GRAVITY); // Increase velocity magnitude with time
        }

        if (Gdx.input.justTouched() && position.y <= 0){
            position.y = 1; // Prevent the bird from being stuck to the bottom of the screen
        }

        if(position.y > 0) { // Keep the bird from falling out of the screen
            // Update bird position based on velocity.
            // Scale velocity with deltaTime to ensure constant bird speeds across all devices
            position.add(0, velocity.y * Gdx.graphics.getDeltaTime());
        }

        // Follow collision box to the bird position
        birdCollisionBox.setPosition(position);
    }

    public void flap(int screenHeight) {
        // set velocity on the positive direction while the bird is inside the screen
        if(position.y < screenHeight - bird.getHeight()) {
            velocity.y = JUMP_VELOCITY;
        }
    }

    public Vector2 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return bird;
    }

    public Rectangle getCollisionBox() {
        return birdCollisionBox;
    }
}
