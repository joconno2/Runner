// This file handles all inputs -JTO

package com.mathgaming.rhelpers;

import com.badlogic.gdx.InputProcessor;
import com.mathgaming.gameobjects.RunActor;

public class InputHandler implements InputProcessor {
	
	private RunActor actor;
	
	public InputHandler(RunActor givenActor){
		actor = givenActor;
	}
	

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == 62) // 62 is spacebar -JTO
			actor.jump(); // Calls jump on main character when spacebar is hit -JTO
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
