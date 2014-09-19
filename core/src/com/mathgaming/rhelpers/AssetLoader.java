package com.mathgaming.rhelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

	public static Texture texture;
	public static TextureRegion bg, ground, characterStepOne, characterStepTwo,
								platformSmall, platformMedium, platformLarge;
	
	public static Animation runningAnimation;
	
	public static void load(){
		
		 // The spritesheet has to be stored in the android folder. I should look up why -JTO
		texture = new Texture(Gdx.files.internal("data/spritesheet.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		// TextureRegion x y width height -JTO
		bg = new TextureRegion(texture, 0, 0, 230, 62);
		
		// Large Platform
		platformLarge = new TextureRegion(texture, 0, 89, 84, 11);

		// Import the running character sprites -JTO
		characterStepOne = new TextureRegion(texture, 210, 64, 16, 21);
		characterStepTwo = new TextureRegion(texture, 233, 64, 16, 21);
		
		// build the runnning animation -JTO
		TextureRegion[] running = {characterStepOne, characterStepTwo};
		runningAnimation = new Animation(0.12f, running); //0.1f is the speed of animation -JTO
		runningAnimation.setPlayMode(Animation.PlayMode.LOOP);
		
		
		 
		
	}
	
	public static void dispose(){
		texture.dispose();
	}
	
}
