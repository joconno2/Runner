package com.mathgaming.gameobjects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Platform {

	protected Vector2 position;
	protected Vector2 velocity;
	protected int width;
	protected int height;

	protected boolean isScrolledLeft;
	
	protected Rectangle boundingBox;
	
	
	public Platform(float x, float y, int width, int height, float scrollSpeed){
		position = new Vector2(x,y);
		velocity = new Vector2(scrollSpeed, 0);
		this.width = width;
		this.height = height;
		isScrolledLeft = false;
		boundingBox = new Rectangle(x,y,width,height);
	}
	
	public void update(float delta) {
		position.add(velocity.cpy().scl(delta));
		boundingBox.x = position.x;
		boundingBox.y = position.y-5; // subtracting 5 fixed an error, am I off by 5 somewhere? -JTO //Still not perfect -JTO
		
		if(position.x + width < 0)
			isScrolledLeft = true;
		
	}
	
	public void reset(float newX, float newY){
		position.x = newX;
		position.y = newY;
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

    public boolean isScrolledLeft(){
    	return isScrolledLeft;
    }
	
	public Rectangle getBoundingBox(){
		return boundingBox;
	}
	
	// Terrifying mess used to debug. Leaving it in until collision doesnt suck -JTO
	public boolean collides(RunActor runActor){
		if(position.x <= runActor.getX()+runActor.getWidth()){
			if(Intersector.overlaps(runActor.getBoundingBox(), getBoundingBox())){
				//System.out.print(Intersector.overlaps(runActor.getBoundingBox(), getBoundingBox()));
				//System.out.print("- x: "+getBoundingBox().x+" - y:"+getBoundingBox().y+
				//		" - height: "+getBoundingBox().height+" - width: "+getBoundingBox().width+"\n");
				//System.out.println("actor - x: "+runActor.getBoundingBox().x+" - y:"+runActor.getBoundingBox().y+
				//		" - height: "+runActor.getBoundingBox().height+ " - width: "+runActor.getBoundingBox().width);
				return Intersector.overlaps(runActor.getBoundingBox(), getBoundingBox());
			}
		}
		return false;
	}
	
}
