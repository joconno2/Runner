package com.mathgaming.gameobjects;

import java.util.Random;

import com.mathgaming.gameworld.GameWorld;

public class ScrollHandler {

	private Platform largePlatform1;
	private Platform ground, ground2;
	private Enemy bee;
	private Random randomY = new Random();
	private GameWorld gameWorld;
	private static final int DEFAULT_SCROLL_SPEED = -240;
	private static final float OFFSET = 20;
	
	public ScrollHandler(GameWorld gameWorld, float yPos){
		this.gameWorld = gameWorld;		
		largePlatform1 = new Platform(10, 360, 84*4, 10*4, DEFAULT_SCROLL_SPEED); //last arg is SCROLLSPEED< add constant -JTO
		bee = new Enemy(200,200, 20*4, 14*4, 3, DEFAULT_SCROLL_SPEED - 200); // Enemy should move slightly faster than everything else
		ground = new Platform(0, 560, 250*4, 20*4, DEFAULT_SCROLL_SPEED - 110); // Need the foreground to run faster than background for a parallax effect -JTO
		ground2 = new Platform(ground.getTailX()-OFFSET, 560, 250*4, 20*4, DEFAULT_SCROLL_SPEED - 110); // The second stitched ground JTO
	}
	
	public void update(float delta){
		largePlatform1.update(delta);
		ground.update(delta);
		ground2.update(delta);
		bee.update(delta);
		
		int platformVal = randomY.nextInt(400)+100;

		if(largePlatform1.isScrolledLeft())
			largePlatform1.reset(960,platformVal); // 400+100 to give room in the top and the bottom of screen -JTO
		
		if(bee.isScrolledLeft()){
			bee.reset(960, platformVal-100);
			addScore(1); // THis line is for testing the score -JTO
		}
		
		if(ground.isScrolledLeft())
			ground.reset(ground2.getTailX()-OFFSET, 560);
		
		if(ground2.isScrolledLeft())
			ground2.reset(ground.getTailX()-OFFSET, 560);
		
		
			
			
	}

	public Platform getLargePlatform1(){
		return largePlatform1;
	}

	public Platform getGround() {
		return ground;
	}

	public Platform getGround2() {
		return ground2;
	}
	
	public Enemy getBee(){
		return bee;
	}
	
	private void addScore(int increment){
		gameWorld.addScore(increment);
	}
	
	public void onRestart(){
		largePlatform1.reset(960,randomY.nextInt(400)+100);
		bee.onRestart(200,200);
		ground.reset(0, 560);
		ground2.reset(ground.getTailX()-OFFSET, 560);
	}
	
}
