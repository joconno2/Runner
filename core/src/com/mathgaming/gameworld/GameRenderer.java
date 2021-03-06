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
import com.mathgaming.gameobjects.Enemy;
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
    
    private Enemy bee;

    
    private int midPointY;
    @SuppressWarnings("unused")
	private int gameHeight;
    
    public static TextureRegion bg, characterStepOne, characterStepTwo,
	platformSmall, platformMedium, platformLarge, groundTexture, fullHeart, emptyHeart;
    private Animation runningAnimation, beeAnimation;
    
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
        
        // Draw the bee animation -JTO
        batcher.draw(beeAnimation.getKeyFrame(runTime),
        		bee.getX(), bee.getY(), bee.getWidth(), bee.getHeight());
        
        //Draw the hearts -JTO
        //batcher.draw(heartAnimation.getKeyFrame(runTime), 100, 100, 50, 50); example anim
        if(myWorld.getHits() == 0){
        	batcher.draw(fullHeart, 50, 50, 50, 50);
        	batcher.draw(fullHeart, 105, 50, 50, 50);
        	batcher.draw(fullHeart, 160, 50, 50, 50);
        }else if(myWorld.getHits() == 1){
        	batcher.draw(fullHeart, 50, 50, 50, 50);
        	batcher.draw(fullHeart, 105, 50, 50, 50);
        	batcher.draw(emptyHeart, 160, 50, 50, 50);
        }else if(myWorld.getHits() == 2){
        	batcher.draw(fullHeart, 50, 50, 50, 50);
        	batcher.draw(emptyHeart, 105, 50, 50, 50);
        	batcher.draw(emptyHeart, 160, 50, 50, 50);
        }else{
        	batcher.draw(emptyHeart, 50, 50, 50, 50);
        	batcher.draw(emptyHeart, 105, 50, 50, 50);
        	batcher.draw(emptyHeart, 160, 50, 50, 50);
        }
        
        // Draw the ground to test, no collision yet
        batcher.draw(groundTexture, ground.getX(), ground.getY(), ground.getWidth(), ground.getHeight());
        //drawing ground hack to test something -JTO
        batcher.draw(groundTexture, ground2.getX(), ground2.getY(), ground2.getWidth(), ground2.getHeight());
        // worked, but creates a jagged line and wont give collision detection. I'd like to avoid creating a 
        // Separate class for the ground, with a front and back ground platform swapping places or something.
        // I think the above concept with the resetting can work instead with a handmade second ground platform
        // tied to getTail -JTO
        
        
        // Convert integer into String
        String score = myWorld.getScore() + "";

        // Draw shadow first
        AssetLoader.shadow.draw(batcher, "" + myWorld.getScore(), 460 - (3 * score.length()), 12);
        // Draw text
        AssetLoader.font.draw(batcher, "" + myWorld.getScore(), 460 - (3 * score.length() - 1), 11);
      
        if(myWorld.isReady()){
        	// Draw shadow first
            AssetLoader.shadow.draw(batcher, "PRESS ENTER TO START", 200, 180); // Should make this not hardcoded
            // Draw text
            AssetLoader.font.draw(batcher, "PRESS ENTER TO START", 200, 170);
        }
        
        if(myWorld.isGameOver()){
            AssetLoader.shadow.draw(batcher, "GAME OVER", 300, 150); // Should make this not hardcoded
            AssetLoader.font.draw(batcher, "GAME OVER", 300, 140);
        }
        
        
        batcher.end();
        
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);

        // Debugging -JTO
        //shapeRenderer.rect(bee.getBoundingBox().x+5, bee.getBoundingBox().y+5, 17*4, 13*4);
        //shapeRenderer.rect(runActor.getBoundingBox().x, runActor.getBoundingBox().y, 15*4, 20*4);
        //shapeRenderer.rect(largePlatform1.getX(), largePlatform1.getY(), 84*4, 10*4);

        shapeRenderer.end();
       
		
	}
	
	private void initGameObjects() {
        runActor = myWorld.getRunActor();
        largePlatform1 = myWorld.getLargePlatform1();
        ground = myWorld.getGround();
        ground2 = myWorld.getGround2();
        bee = myWorld.getBee();
    }

    private void initAssets() {
        bg = AssetLoader.bg;
        runningAnimation = AssetLoader.runningAnimation;
        platformLarge = AssetLoader.platformLarge;
        groundTexture = AssetLoader.ground;
        beeAnimation = AssetLoader.beeAnimation;
        fullHeart = AssetLoader.fullHeart;
        emptyHeart = AssetLoader.emptyHeart;
    }

}
