package com.mathgaming.gameobjects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Enemy {

	private Vector2 position;
	private Vector2 velocity;
	
	private int width;
	private int height;	
	private int health;
	
	private Rectangle boundingBox;

	private boolean isAlive;
	private boolean isScrolledLeft;
	
	public Enemy(float x, float y, int width, int height, int health, float scrollSpeed){
		this.width = width;
		this.height = height;
		position = new Vector2(x,y);
		this.health = health;
		isAlive = true;
		velocity = new Vector2(scrollSpeed,0);
		boundingBox = new Rectangle();
		isScrolledLeft = false;
	}
	
	public void update(float delta){
		position.add(velocity.cpy().scl(delta));
		
		//set bounding box
        boundingBox.set(position.x+5, position.y+5, 17*4, 13*4);
		
		if(position.x + width < 0)
			isScrolledLeft = true;
		
	}
		
	public void reset(float newX, float newY){
		position.x = newX;
		position.y = newY;
		isScrolledLeft = false;
	}
	
	public Rectangle getBoundingBox(){
		return boundingBox;
	}
	
	public float getX(){
		return position.x;
	}
	public float getY(){
		return position.y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getHealth(){
		return health;
	}
	
	public boolean isAlive(){
		return isAlive;
	}

	public boolean isScrolledLeft(){
		return isScrolledLeft;
	}
	
	public boolean collides(RunActor runActor){
		if(position.x <= runActor.getX()+runActor.getWidth()){
			if(Intersector.overlaps(runActor.getBoundingBox(), getBoundingBox())){
				return true;
			}
		}
		return false;
	}

}
