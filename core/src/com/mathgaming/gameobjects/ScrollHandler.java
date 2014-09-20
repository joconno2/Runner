package com.mathgaming.gameobjects;



public class ScrollHandler {

	private Platform largePlatform1;
	
	public ScrollHandler(float yPos){
	
		largePlatform1 = new Platform(10, 560, 84*4, 10*4, -50);

	}

	public Platform getLargePlatform1(){
		return largePlatform1;
	}
	
}
