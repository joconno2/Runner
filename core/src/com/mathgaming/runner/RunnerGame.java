package com.mathgaming.runner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mathgaming.rhelpers.AssetLoader;
import com.mathgaming.screens.GameScreen;

public class RunnerGame extends Game{

	@Override
	public void create() {
		Gdx.app.log("RunnerGame","created");
		AssetLoader.load();
		setScreen(new GameScreen());
	}
	
	@Override
	public void dispose(){
		super.dispose();
		AssetLoader.dispose();
	}
	
}