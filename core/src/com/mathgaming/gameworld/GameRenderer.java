package com.mathgaming.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
<<<<<<< HEAD
=======
import com.mathgaming.gameobjects.Platform;
>>>>>>> origin/jim-branch
import com.mathgaming.gameobjects.RunActor;
import com.mathgaming.rhelpers.AssetLoader;

public class GameRenderer {

	private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batcher;
    private RunActor runActor;
<<<<<<< HEAD
=======
    private Platform largePlatform1;
>>>>>>> origin/jim-branch
    
    private int midPointY;
    private int gameHeight;
    
    public static TextureRegion bg, ground, characterStepOne, characterStepTwo,
	platformSmall, platformMedium, platformLarge;
    private Animation runningAnimation;
    
	public GameRenderer(GameWorld world, int gameHeight, int midPointy) {
		myWorld = world;
		
		this.gameHeight = gameHeight;
		this.midPointY = midPointY;
		
		cam = new OrthographicCamera();
        cam.setToOrtho(true, 960, 640);
        
        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined); // switches to a y down coord 
        
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
     
        
        // Call helper methods to initialize instance variables
        initGameObjects();
        initAssets();
	}

	public void render(float runTime) {
		
		// Draw a black bg
		Gdx.gl.glClearColor(0, 0, 120/255.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); 
        
        //begin shaperenderer
        shapeRenderer.begin(ShapeType.Filled);

        //Draw sky bg color
        shapeRenderer.setColor(208/255.0f, 244/255.0f, 247/255.0f, 255/255.0f);
        shapeRenderer.rect(0, 0, 960, 200);
        
        //Draw lower bg color
        shapeRenderer.setColor(192/255.0f, 232/255.0f, 236/255.0f, 255/255.0f);
        shapeRenderer.rect(0, 430, 960, 250);
        
        shapeRenderer.end();
        
        // begin sprite batcher -JTO
        batcher.begin();
        
        // Disable transparency for performance -JTO
        batcher.disableBlending();
        batcher.draw(bg, 0, midPointY+160, 960, 280);
        
        // Re-enable blending for the character -JTO
        batcher.enableBlending();
        
        //Draw the main character animation -JTO
        batcher.draw(runningAnimation.getKeyFrame(runTime), 
        		runActor.getX(), runActor.getY(),  runActor.getWidth()*4, runActor.getHeight()*4);
        
        //test
<<<<<<< HEAD
        batcher.draw(platformLarge, 10, 560, 84*4, 10*4);
=======
        batcher.draw(platformLarge, largePlatform1.getX(), largePlatform1.getY(), 
        		largePlatform1.getWidth(), largePlatform1.getHeight());
>>>>>>> origin/jim-branch
        
        batcher.end();
        
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
<<<<<<< HEAD
        //shapeRenderer.rect(runActor.getBoundingBox().x, runActor.getBoundingBox().y, 15*4, 20*4);
=======
        // Debugging -JTO
        //shapeRenderer.rect(runActor.getBoundingBox().x, runActor.getBoundingBox().y, 15*4, 20*4);
        //shapeRenderer.rect(largePlatform1.getX(), largePlatform1.getY(), 84*4, 10*4);
>>>>>>> origin/jim-branch
        shapeRenderer.end();
       
		
	}
	
	private void initGameObjects() {
        runActor = myWorld.getRunActor();
<<<<<<< HEAD
=======
        largePlatform1 = myWorld.getLargePlatform1();
>>>>>>> origin/jim-branch
    }

    private void initAssets() {
        bg = AssetLoader.bg;
        runningAnimation = AssetLoader.runningAnimation;
        platformLarge = AssetLoader.platformLarge;
    }

}
