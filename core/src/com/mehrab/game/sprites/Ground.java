package com.mehrab.game.sprites;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Texture;

public class Ground {
    private final float GROUND_SPEED = -2.2f;
    private final int GROUND_HEIGHT = -20;
    Texture ground;
    Rectangle collisionBox;
    Vector2 groundPosition;

    public Ground() {
        ground = new Texture("ground.png");
        groundPosition = new Vector2(0,0);
        collisionBox = new Rectangle(0, GROUND_HEIGHT, ground.getWidth(), ground.getHeight());
    }

    public void setGroundPos(int horizontalPos) {
        groundPosition.set(horizontalPos, GROUND_HEIGHT);
    }

    // Continuously move ground to the left
    public void update(int screenWidth) {
        groundPosition.x += GROUND_SPEED;

        if(groundPosition.x < -screenWidth) {
            groundPosition.x = screenWidth; // Set it back to the right side of screen
        }
    }

    public boolean checkCollision(Rectangle bird) {
        if(bird.overlaps(collisionBox)){
            return true;
        } else {
            return false;
        }
    }
    public void dispose() {
        ground.dispose();
    }

    public Texture getGroundTexture() {
        return ground;
    }

    public Vector2 getGroundPos() {
        return groundPosition;
    }
}
