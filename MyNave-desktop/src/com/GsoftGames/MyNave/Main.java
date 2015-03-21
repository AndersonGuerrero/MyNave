package com.GsoftGames.MyNave;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "MyNave";
		cfg.width = 800;
		cfg.height = 600;	
		//cfg.resizable=false;
		//cfg.fullscreen=true;
		new LwjglApplication(new MyNave(), cfg);
	}
}
