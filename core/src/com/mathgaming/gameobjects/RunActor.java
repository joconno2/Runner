package com.mathgaming.gameobjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class RunActor {

	private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private int width;
    private int height;
    
    private int fGdown = 800;
    
    private Rectangle boundingBox;
    
    public RunActor(float x, float y, int width, int height){
    	this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, fGdown);
        boundingBox = new Rectangle();
    }
    
    public void update(float delta){
    	if(velocity.y != 0)  // Weird hack to see if I can get it to stop on a a platform -JTO
    		velocity.add(acceleration.cpy().scl(delta)); // Gravity

        if (velocity.y > 1000) {    // Terminal Velocity
            velocity.y = 1000;
        }

        position.add(velocity.cpy().scl(delta));
        
        //set bounding box
        boundingBox.set(position.x, position.y, position.x+15*4, position.y+20*4);
        
        boundingBox.set(position.x, position.y, 15*4, 20*4);
        
    }
    
    public void stop(){
    	velocity.y = 0;
    }
    
    public void jump(){
    	velocity.y = -600;
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
    
    public Rectangle getBoundingBox(){
    	return boundingBox;
    }

	public void fall() {
		if(velocity.y == 0)
			velocity.y += 100;
	}
}
