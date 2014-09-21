package com.mathgaming.gameworld;

<<<<<<< HEAD
import com.mathgaming.gameobjects.RunActor;

public class GameWorld {
	private RunActor actor;
	
	public GameWorld(int midpointY){
		actor = new RunActor(120.0f,140.0f,15,20); //Starts the main character and gives it a size
	}

    public void update(float delta) {
    	actor.update(delta);
    }

    public RunActor getRunActor() {
        return actor;
=======
import com.mathgaming.gameobjects.Platform;
import com.mathgaming.gameobjects.RunActor;
import com.mathgaming.gameobjects.ScrollHandler;

public class GameWorld {
	private RunActor runActor;
	private ScrollHandler scroller;
	private Platform largePlatform1;
	
	public GameWorld(int midpointY){
		runActor = new RunActor(120.0f,140.0f,15,20); //Starts the main character and gives it a size
		largePlatform1 = new Platform(10, 560, 84*4, 10*4, -50);
	}

    public void update(float delta) {
    	runActor.update(delta);
    	if(largePlatform1.collides(runActor))
    		runActor.stop();
    }

    public RunActor getRunActor() {
        return runActor;
    }
    
    public Platform getLargePlatform1(){
    	return largePlatform1;
>>>>>>> origin/jim-branch
    }

}
