package com.mathgaming.gameobjects;

import com.badlogic.gdx.math.Vector2;

public class Platform {

	protected Vector2 position;
	protected Vector2 velocity;
	protected int width;
	protected int height;

	protected boolean isScrolledLeft;
	
	public Platform(float x, float y, int width, int height, float scrollSpeed){
		position = new Vector2(x,y);
		velocity = new Vector2(scrollSpeed, 0);
		this.width = width;
		this.height = height;
		isScrolledLeft = false;
	}
	
	public void reset(float newX){
		position.x = newX;
		isScrolledLeft = false;
	}
	
	public float getTailX() {
        return position.x + width;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
	
}
