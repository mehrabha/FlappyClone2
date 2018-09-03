package com.mehrab.game.sprites;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Tube {
    private Texture topTube, bottomTube;
    private Vector2 topTubePosition, bottomTubePosition;
    private Random randomNumber;

    private int gapLowest;
    private int gapPosition;
    private int gapSize;

    public Tube(float horizontalPos, int screenWidth, int screenHeight){
        topTube = new Texture("toptube.png");
        bottomTube = new Texture("bottomtube.png");
        randomNumber = new Random();

        gapLowest = screenHeight / 4; // Set the lowest boundary at 25% of screen
        gapPosition = screenHeight / 2; // Generate gap within 50% of the screen
        gapSize = screenHeight / 5 ;

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
