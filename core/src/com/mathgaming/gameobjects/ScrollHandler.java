package com.mathgaming.gameobjects;

import java.util.Random;

public class ScrollHandler {

	private Platform largePlatform1;
	private Platform ground;
	private Random randomY = new Random();
	private static final int DEFAULT_SCROLL_SPEED = -240;
	
	public ScrollHandler(float yPos){
	
		largePlatform1 = new Platform(10, 360, 84*4, 10*4, DEFAULT_SCROLL_SPEED); //last arg is SCROLLSPEED< add constant -JTO
		ground = new Platform(0, 560, 250*4, 20*4, DEFAULT_SCROLL_SPEED - 110); // Need the foreground to run faster than background for a parallax effect -JTO

	}
	
	public void update(float delta){
		largePlatform1.update(delta);
		ground.update(delta);

		if(largePlatform1.isScrolledLeft())
			largePlatform1.reset(960,randomY.nextInt(400)+100); // 400+100 to give room in the top and the bottom of screen -JTO
		
		if(ground.isScrolledLeft())
			ground.reset(0, 560);
			
		
		
	}

	public Platform getLargePlatform1(){
		return largePlatform1;
	}

	public Platform getGround() {
		return ground;
	}
	
}
