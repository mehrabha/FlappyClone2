package com.mehrab.game.sprites;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Tube {
    private final int TUBE_SPEED = -2;

    private int gapLowest;
    private int gapPosition;
    private int gapSize;

    private Texture topTube, bottomTube;
    private Vector2 topTubePosition, bottomTubePosition;
    private Rectangle topTubeCollisionBox, bottomTubeCollisionBox;
    private Random randomNumber;

    public Tube(int screenWidth, int screenHeight){
        gapLowest = screenHeight / 5; // Set the lowest boundary at 20% of screen
        gapPosition = screenHeight / 2; // Generate gap anywhere within 50% of the screen
        gapSize = screenHeight / 5 ;

        topTube = new Texture("toptube.png");
        bottomTube = new Texture("bottomtube.png");
        randomNumber = new Random();
    }

    public void setTubePos(int horizontalPos){
        topTubePosition = new Vector2(
                horizontalPos,
                // Randomly generate a gap from 25% - 75%
                randomNumber.nextInt(gapPosition) + gapSize + gapLowest
        );

        bottomTubePosition = new Vector2(
                horizontalPos,
                // Draw bottom tube under the top tube
                topTubePosition.y - gapSize - bottomTube.getHeight()
        );

        // Create collision box around tubes
        topTubeCollisionBox = new Rectangle(
                topTubePosition.x,
                topTubePosition.y,
                topTube.getWidth(),
                topTube.getHeight()
        );

        bottomTubeCollisionBox = new Rectangle(
                bottomTubePosition.x,
                bottomTubePosition.y,
                bottomTube.getWidth(),
                bottomTube.getHeight()
        );
    }

    // Continuously move tubes to the left
    public void update(int screenWidth){
        topTubePosition.add(TUBE_SPEED, 0);
        bottomTubePosition.add(TUBE_SPEED, 0);

        // Reset tube position once it moves past the screen
        if(topTubePosition.x + screenWidth / 2 < 0){
            setTubePos(screenWidth);
        }

        // Update tube collision box
        topTubeCollisionBox.setPosition(topTubePosition);
        bottomTubeCollisionBox.setPosition(bottomTubePosition);
    }


    public Boolean checkCollision(Rectangle bird) {
        if(bird.overlaps(topTubeCollisionBox) || bird.overlaps(bottomTubeCollisionBox)) {
            return true;
        } else {
            return false;
        }
    }

    public void dispose() {
        topTube.dispose();
        bottomTube.dispose();
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getTopTubePosition() {
        return topTubePosition;
    }

    public Vector2 getBottomTubePosition() {
        return bottomTubePosition;
    }
}
