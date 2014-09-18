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
	
	public static Animation characterAnimation;
	
	public static void load(){
		
		 // The spritesheet has to be stored in the android folder. I should look up why -JTO
		texture = new Texture(Gdx.files.internal("data/spritesheet.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		/*
		 * Start filling in texture regions once spritesheet is built, as follows:
		 * 
		 * bg = new TextureRegion(texture, 0, 0, 136, 43);
		 * bg.flip(false, true);
		 * 
		 * -JTO
		 */
		
	}
	
	public static void dispose(){
		texture.dispose();
	}
	
}
