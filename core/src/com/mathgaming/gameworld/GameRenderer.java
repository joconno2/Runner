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
import com.mathgaming.gameobjects.Platform;
import com.mathgaming.gameobjects.RunActor;
import com.mathgaming.rhelpers.AssetLoader;

public class GameRenderer {

	private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batcher;
    private RunActor runActor;

    private Platform largePlatform1;
    private Platform ground, ground2;

    
    private int midPointY;
    @SuppressWarnings("unused")
	private int gameHeight;
    
    public static TextureRegion bg, characterStepOne, characterStepTwo,
	platformSmall, platformMedium, platformLarge, groundTexture;
    private Animation runningAnimation;
    
	public GameRenderer(GameWorld world, int gameHeight, int midPointY) {
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
        batcher.draw(bg, 0, midPointY+60, 960, 280);
        
        // Re-enable blending for the character -JTO
        batcher.enableBlending(); 
        
        //Draw the main character animation -JTO
        batcher.draw(runningAnimation.getKeyFrame(runTime), 
        		runActor.getX(), runActor.getY(),  runActor.getWidth()*4, runActor.getHeight()*4);
        

        // Draw the large platform -JTO
        batcher.draw(platformLarge, largePlatform1.getX(), largePlatform1.getY(), 
        		largePlatform1.getWidth(), largePlatform1.getHeight());
        
        
        // Draw the ground to test, no collision yet
        batcher.draw(groundTexture, ground.getX(), ground.getY(), ground.getWidth(), ground.getHeight());
        //drawing ground hack to test something -JTO
        batcher.draw(groundTexture, ground2.getX(), ground2.getY(), ground2.getWidth(), ground2.getHeight());
        // worked, but creates a jagged line and wont give collision detection. I'd like to avoid creating a 
        // Separate class for the ground, with a front and back ground platform swapping places or something.
        // I think the above concept with the resetting can work instead with a handmade second ground platform
        // tied to getTail -JTO
        
      
        batcher.end();
        
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);

        //shapeRenderer.rect(runActor.getBoundingBox().x, runActor.getBoundingBox().y, 15*4, 20*4);

        // Debugging -JTO
        //shapeRenderer.rect(runActor.getBoundingBox().x, runActor.getBoundingBox().y, 15*4, 20*4);
        //shapeRenderer.rect(largePlatform1.getX(), largePlatform1.getY(), 84*4, 10*4);

        shapeRenderer.end();
       
		
	}
	
	private void initGameObjects() {
        runActor = myWorld.getRunActor();
        largePlatform1 = myWorld.getLargePlatform1();
        ground = myWorld.getGround();
        ground2 = myWorld.getGround2();
    }

    private void initAssets() {
        bg = AssetLoader.bg;
        runningAnimation = AssetLoader.runningAnimation;
        platformLarge = AssetLoader.platformLarge;
        groundTexture = AssetLoader.ground;
    }

}
