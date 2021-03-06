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
    
    private boolean airborne;
    
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
        //boundingBox.set(position.x, position.y, position.x+15*4, position.y+20*4);
        
        boundingBox.set(position.x, position.y, 15*4, 20*4);
        
    }
    
    public void stop(){
    	if(velocity.y > 0){
    		velocity.y = 0;
    		airborne = false;
    	}
    }
    
    public void jump(){
    	if(!airborne){
    		velocity.y = -600;
    		airborne = true;
    	}
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
			velocity.y += 300;
	}
	
	public void onRestart(){
		position.x = 120.0f;
		position.y = 440.0f;
		acceleration.x = 0;
		acceleration.y = fGdown;
		velocity.x = 0;
		velocity.y= 0;
	}
}
