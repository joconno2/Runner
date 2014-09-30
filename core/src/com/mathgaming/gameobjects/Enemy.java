package com.mathgaming.gameobjects;

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
	
	public Enemy(float x, float y, int width, int height, int health, float scrollSpeed){
		this.width = width;
		this.height = height;
		position = new Vector2(x,y);
		this.health = health;
		isAlive = true;
		velocity = new Vector2(scrollSpeed,0);
		boundingBox = new Rectangle();
	}
	
	public void update(float delta){
		position.add(velocity.cpy().scl(delta));
		
		boundingBox.x = position.x;
		boundingBox.y = position.y-5;
		
		
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

}
