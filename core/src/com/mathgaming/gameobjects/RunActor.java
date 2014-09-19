package com.mathgaming.gameobjects;

import com.badlogic.gdx.math.Vector2;

public class RunActor {

	private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private int width;
    private int height;
    
    public RunActor(float x, float y, int width, int height){
    	this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, -400);
    }
    
    public void update(float delta){
    	velocity.add(acceleration.cpy().scl(delta)); // Gravity

        if (velocity.y < -1000) {    // Terminal Velocity
            velocity.y = -10800;
        }

        position.add(velocity.cpy().scl(delta));
    }
    
    public void jump(){
    	velocity.y = 400;
    }
	
    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
