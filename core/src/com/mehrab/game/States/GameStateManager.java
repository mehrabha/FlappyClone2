package com.mehrab.game.States;

import java.util.Stack;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameStateManager {
    private Stack<State> states; // contains all game states

    public GameStateManager() {
        states = new Stack<State>();
    }

    public void pushState(State s) {
        states.push(s);
    }

    public void popState() {
        states.pop();
    }

    public void popState(State s) {
        states.pop();
        states.push(s); // Replace with new state if it is provided
    }

    public void update(float Time) {
        states.peek().update(Time); // Update new state
    }

    public void render(SpriteBatch batch) {
        states.peek().render(batch); // Render new state
    }

    public void dispose(SpriteBatch batch) {
        states.peek().dispose(batch);
    }
}
