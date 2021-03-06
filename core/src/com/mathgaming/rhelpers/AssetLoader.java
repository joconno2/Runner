package com.mathgaming.rhelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

	public static Texture texture;
	public static TextureRegion bg, ground, characterStepOne, characterStepTwo,
								platformSmall, platformMedium, platformLarge,
								beeUp, beeDown, fullHeart, halfHeart, emptyHeart;
	
	public static Animation runningAnimation, beeAnimation, heartAnimation;
	
	public static BitmapFont font, shadow;
	
	public static void load(){
		
		 // The spritesheet has to be stored in the android folder. I should look up why -JTO
		texture = new Texture(Gdx.files.internal("data/spritesheet.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		// TextureRegion x y width height -JTO
		bg = new TextureRegion(texture, 0, 0, 230, 62);
		bg.flip(false, true);
		
		// Large Platform
		platformLarge = new TextureRegion(texture, 0, 89, 84, 11);
		platformLarge.flip(false, true);
		
		// Ground
		ground = new TextureRegion(texture, 0, 129, 250, 20);
		ground.flip(false, true);

		// Import the running character sprites -JTO
		characterStepOne = new TextureRegion(texture, 210, 64, 16, 21);
		characterStepOne.flip(false, true);
		characterStepTwo = new TextureRegion(texture, 233, 64, 16, 21);
		characterStepTwo.flip(false, true);
		
		// Import the Bee sprites -JTO
		beeUp = new TextureRegion(texture, 88, 89, 20, 14);
		beeUp.flip(false, true);
		beeDown = new TextureRegion(texture, 109, 89, 20, 14);
		beeDown.flip(false, true);
		
		// build the runnning animation -JTO
		TextureRegion[] running = {characterStepOne, characterStepTwo};
		runningAnimation = new Animation(0.12f, running); //0.1f is the speed of animation -JTO
		runningAnimation.setPlayMode(Animation.PlayMode.LOOP);
		
		// build the bee animation -JTO
		TextureRegion[] beeFly = {beeUp, beeDown};
		beeAnimation = new Animation(0.3f, beeFly);
		beeAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
		
		// build the font -JTO
		font = new BitmapFont(Gdx.files.internal("data/text.fnt"));
		font.setScale(0.85f, -0.85f);
		shadow = new BitmapFont(Gdx.files.internal("data/shadow.fnt"));
		shadow.setScale(0.85f, -0.85f);
		
		// Hearts
		fullHeart = new TextureRegion(texture, 160, 89, 16, 15);
		fullHeart.flip(false, true);
		halfHeart = new TextureRegion(texture, 178, 89, 16, 15);
		halfHeart.flip(false, true);
		emptyHeart = new TextureRegion(texture, 196, 89, 16, 15);
		emptyHeart.flip(false, true);
		
		TextureRegion[] heartDamage = {fullHeart, halfHeart, emptyHeart};
		heartAnimation = new Animation(0.3f, heartDamage);
		heartAnimation.setPlayMode(Animation.PlayMode.LOOP);
		 
		
	}
	
	public static void dispose(){
		texture.dispose();
		font.dispose();
		shadow.dispose();
	}
	
}
