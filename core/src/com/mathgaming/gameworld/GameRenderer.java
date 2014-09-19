package com.mathgaming.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mathgaming.gameobjects.RunActor;
import com.mathgaming.rhelpers.AssetLoader;

public class GameRenderer {

	private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batcher;
    
    private int midPointY;
    private int gameHeight;
    
	public GameRenderer(GameWorld world, int gameHeight, int midPointy) {
		myWorld = world;
		cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, 204);
        
        batcher = new SpriteBatch();
        
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
	}

	public void render(float runTime) {
		
		RunActor runActor = myWorld.getRunActor();
		
		// Draw a black bg
		Gdx.gl.glClearColor(0, 0, 120/255.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); 
        
        //begin shaperenderer
        shapeRenderer.begin(ShapeType.Filled);

        //Draw sky bg color
        shapeRenderer.setColor(208/255.0f, 244/255.0f, 247/255.0f, 255/255.0f);
        shapeRenderer.rect(0, 0, 420, 100);
        
        //Draw lower bg color
        shapeRenderer.setColor(192/255.0f, 232/255.0f, 236/255.0f, 255/255.0f);
        shapeRenderer.rect(0, 150, 420, 100);
        
        shapeRenderer.end();
        
        // begin sprite batcher -JTO
        batcher.begin();
        
        // Disable transparency for performance -JTO
        batcher.disableBlending();
        batcher.draw(AssetLoader.bg, 0, midPointY+160, 960, 280);
        
        // Re-enable blending for the character -JTO
        batcher.enableBlending();
        
        //Draw the main character animation -JTO
        batcher.draw(AssetLoader.runningAnimation.getKeyFrame(runTime), 
        		runActor.getX(), runActor.getY(),  runActor.getWidth()*4, runActor.getHeight()*4);
        
        //test
        batcher.draw(AssetLoader.platformLarge, 10, 40, 84*4, 10*4);
        
        batcher.end();
       
		
	}

}
