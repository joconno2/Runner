package com.mathgaming.gameobjects;

import java.util.Random;


public class ScrollHandler {

	private Platform largePlatform1;
	private Random randomY = new Random();
	
	public ScrollHandler(float yPos){
	
		largePlatform1 = new Platform(10, 560, 84*4, 10*4, -250); //last arg is SCROLLSPEED< add constant -JTO

	}
	
	public void update(float delta){
		largePlatform1.update(delta);

		if(largePlatform1.isScrolledLeft())
			largePlatform1.reset(960,randomY.nextInt(500)+100); // 500+100 to give room in the top -JTO
		
	}

	public Platform getLargePlatform1(){
		return largePlatform1;
	}
	
}
