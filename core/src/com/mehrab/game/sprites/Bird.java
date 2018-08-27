package com.mehrab.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Bird {
    private Vector2 position;
    private Vector2 velocity;

    private Texture bird;

    public Bird(int x_coord, int y_coord){
        position = new Vector2(x_coord, y_coord); // default position
        velocity = new Vector2(0, 0); // default velocity

        bird = new Texture("bird.png");
    }

    public void update(){
        velocity.add(0, -15); // Increase velocity magnitude with time

        float deltaTime = Gdx.graphics.getDeltaTime(); // get time between each frame

        // Update bird position based on velocity.
        // Scale velocity with deltaTime to ensure constant bird speeds across all devices
        position.add(0, velocity.y * deltaTime);

    }

    public Vector2 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return bird;
    }

    public void flap() {
        velocity.y = 250; // set velocity on the positive direction
    }
}
