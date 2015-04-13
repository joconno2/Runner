package com.mathgaming.gameworld;

import com.mathgaming.gameobjects.Enemy;
import com.mathgaming.gameobjects.RunActor;
import com.mathgaming.gameobjects.Platform;
import com.mathgaming.gameobjects.ScrollHandler;

public class GameWorld {
	private RunActor runActor;
	private ScrollHandler scroller;
	private int score = 0;
	private int hits = 0;
	private boolean safe = true;
	private GameState currentState;
	
    public enum GameState{
    	READY, RUNNING, GAMEOVER
    }

	public GameWorld(int midpointY){
		runActor = new RunActor(120.0f,140.0f,15,20); //Starts the main character and gives it a size -JTO
        scroller = new ScrollHandler(this, 300); 
        currentState = GameState.READY;
	}

	public void update(float delta){
		switch (currentState){
		case READY:
			updateReady(delta);
			break;
		case RUNNING:
			default:
				updateRunning(delta);
				break;
		}
	}
	
	public void updateReady(float delta){
		
	}
	
    public void updateRunning(float delta) {
    	if(scroller.getLargePlatform1().collides(runActor) || scroller.getGround().collides(runActor)
    			|| scroller.getGround2().collides(runActor))
    		runActor.stop();
    	else
    		runActor.fall();
    	
    	// Checks to see if player is in contact with bee, only allows one hit at a time -JTO
    	if(scroller.getBee().collides(runActor)){
    		if(safe == true)
    			addHit();
    		safe = false;
    	}else
    		safe = true;
    	
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
    
    public Enemy getBee(){
    	return scroller.getBee();
    }
    
    public int getScore() {
        return score;
    }

    public void addScore(int increment){
    	score += increment;
    }
    
    public int getHits(){
    	return hits;
    }
    
    private void addHit() {
		hits++;
	}
    
    public boolean isReady(){
    	return currentState == GameState.READY;
    }
    
    public void start(){
    	currentState = GameState.RUNNING;	
    }
    
    public void restart(){
    	currentState = GameState.READY;
    	score = 0;
    	runActor.onRestart(); // Test this
    	scroller.onRestart();
    	currentState = GameState.READY;	
    }
    
    public boolean isGameOver(){
    	return currentState == GameState.GAMEOVER;
    }
    
    
}
