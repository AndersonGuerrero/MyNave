package com.GsoftGames.MyNave;
import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;

public class MainActivity extends AndroidApplication {
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initialize(new MyNave(),true);
	}	
}