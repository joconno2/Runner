package com.mathgaming.runner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mathgaming.screens.GameScreen;

public class RunnerGame extends Game{

	@Override
	public void create() {
		Gdx.app.log("RunnerGame","created");
		setScreen(new GameScreen());
	}
	
}