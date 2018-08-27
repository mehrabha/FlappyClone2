package com.mehrab.game.states;

import java.util.Stack;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameStateManager {
    private Stack<State> states; // contains all game states

    public GameStateManager() {
        states = new Stack<State>();
    }

    public void pushState(State s) {
        states.push(s); // push any subclass object into the stack
    }

    public void popState() {
        states.pop();
    }

    public void popState(State s) {
        states.pop();
        states.push(s); // Replace with new state if it is provided
    }

    public void update() {
        states.peek().update(); // Update new state
    }

    public void render(SpriteBatch batch) {
        states.peek().render(batch); // Render the state at the top of the stack
    }

    public void dispose() {
        states.peek().dispose();
    }
}
