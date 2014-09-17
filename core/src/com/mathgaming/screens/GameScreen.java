package com.mathgaming.screens;

import com.badlogic.gdx.Screen;
import com.mathgaming.gameworld.GameRenderer;
import com.mathgaming.gameworld.GameWorld;

public class GameScreen implements Screen{
	
	private GameWorld world;
	private GameRenderer renderer;

	public GameScreen(){
		world = new GameWorld();
		renderer = new GameRenderer(world);
	}
	
	@Override
	public void render(float delta) {
		world.update(delta);
		renderer.render();
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
