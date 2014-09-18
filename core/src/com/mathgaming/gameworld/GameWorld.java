package com.mathgaming.gameworld;

import com.mathgaming.gameobjects.RunActor;

public class GameWorld {
	private RunActor actor;
	
	public GameWorld(int midpointY){
		actor = new RunActor(40.0f,140.0f,20,20);
	}

    public void update(float delta) {
    	actor.update(delta);
    }

    public RunActor getRunActor() {
        return actor;
    }

}
