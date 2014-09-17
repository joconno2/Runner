package com.mathgaming.gameworld;

import java.util.Random;

import com.badlogic.gdx.math.Rectangle;

public class GameWorld {

	private Rectangle rect = new Rectangle(40, 20, 17, 12);
	private Random r = new Random();

    public void update(float delta) {
    	
    	rect.x--;
        if (rect.x < -17) {
            rect.x = 136;
            rect.y = r.nextInt(200);
        }
        
        
        
    }

    public Rectangle getRect() {
        return rect;
    }

}
