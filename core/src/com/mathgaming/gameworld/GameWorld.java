package com.mathgaming.gameworld;

import com.mathgaming.gameobjects.RunActor;
import com.mathgaming.gameobjects.Platform;
import com.mathgaming.gameobjects.ScrollHandler;

public class GameWorld {
	private RunActor runActor;
	private ScrollHandler scroller;
	
	public GameWorld(int midpointY){
		runActor = new RunActor(120.0f,140.0f,15,20); //Starts the main character and gives it a size -JTO
        scroller = new ScrollHandler(300); 
	}

    public void update(float delta) {
    	if(scroller.getLargePlatform1().collides(runActor) || scroller.getGround().collides(runActor)
    			|| scroller.getGround2().collides(runActor))
    		runActor.stop();
    	else
    		runActor.fall();
    	
    	runActor.update(delta);
    	scroller.update(delta);

    	
    	
    	
    }

    public RunActor getRunActor() {
        return runActor;
    }
    
    public Platform getLargePlatform1(){
    	return scroller.getLargePlatform1();
    }

    public Platform getGround(){
    	return scroller.getGround();
    }
    
    public Platform getGround2(){
    	return scroller.getGround2();
    }
}
