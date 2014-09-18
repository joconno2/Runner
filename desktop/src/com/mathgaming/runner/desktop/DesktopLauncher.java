// Run this as Java app to run the program on a desktop
// Testing git on home machine

// PULL THIS TEST

package com.mathgaming.runner.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mathgaming.runner.RunnerGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Runner Game";
        config.width = 408;
        config.height = 272;
        new LwjglApplication(new RunnerGame(), config);
	}
}
