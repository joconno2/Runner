// Run this as Java app to run the program on a desktop -JTO

package com.mathgaming.runner.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mathgaming.runner.RunnerGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Runner Game";
        config.width = 960; // Need to make sure the width and height are (cont)
        config.height = 640; // standard for a portrait android game -JTO
        new LwjglApplication(new RunnerGame(), config);
	}
}
