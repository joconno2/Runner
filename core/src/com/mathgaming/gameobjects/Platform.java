package com.mathgaming.gameobjects;

<<<<<<< HEAD
=======
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
>>>>>>> origin/jim-branch
import com.badlogic.gdx.math.Vector2;

public class Platform {

	protected Vector2 position;
	protected Vector2 velocity;
	protected int width;
	protected int height;

	protected boolean isScrolledLeft;
	
<<<<<<< HEAD
=======
	protected Rectangle boundingBox;
	
>>>>>>> origin/jim-branch
	public Platform(float x, float y, int width, int height, float scrollSpeed){
		position = new Vector2(x,y);
		velocity = new Vector2(scrollSpeed, 0);
		this.width = width;
		this.height = height;
		isScrolledLeft = false;
<<<<<<< HEAD
=======
		boundingBox = new Rectangle(x,y,width,height);
>>>>>>> origin/jim-branch
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
<<<<<<< HEAD
=======

	public void update(float delta) {
		// TODO Auto-generated method stub
		
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
>>>>>>> origin/jim-branch
	
}
