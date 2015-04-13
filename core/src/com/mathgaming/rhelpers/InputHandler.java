// This file handles all inputs -JTO

package com.mathgaming.rhelpers;

import com.badlogic.gdx.InputProcessor;
import com.mathgaming.gameobjects.RunActor;
import com.mathgaming.gameworld.GameWorld;

public class InputHandler implements InputProcessor {
	
	private RunActor actor;
	private GameWorld myWorld;
	
	public InputHandler(GameWorld myWorld){
		this.myWorld = myWorld;
		actor = myWorld.getRunActor();
	}
	

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == 62) // 62 is spacebar -JTO
			if(myWorld.isReady())
				myWorld.start();
			
			actor.jump(); // Calls jump on main character when spacebar is hit -JTO
			
			if(myWorld.isGameOver())
				myWorld.restart();
				
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
