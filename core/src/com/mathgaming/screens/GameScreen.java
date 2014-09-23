package com.mathgaming.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.mathgaming.gameworld.GameRenderer;
import com.mathgaming.gameworld.GameWorld;
import com.mathgaming.rhelpers.InputHandler;

public class GameScreen implements Screen{
	
	private GameWorld world;
	private GameRenderer renderer;
	private float runTime;

	public GameScreen(){
		float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();      
        float gameWidth = 408;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        
        int midPointY = (int) (gameHeight / 2); //havent checked the math on these -JTO
        
		world = new GameWorld(midPointY);  // I feel like I forgot to capitalize P somewhere.. -JTO
		renderer = new GameRenderer(world, (int) gameHeight, midPointY);
		
		Gdx.input.setInputProcessor(new InputHandler(world.getRunActor())); // Set up the Input Handler -JTO
	}
	
	@Override
	public void render(float delta) {
		runTime += delta;
		world.update(delta);
		renderer.render(runTime);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
