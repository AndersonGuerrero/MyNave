package play;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Pause extends Actor
{
	MyNave Juego;
	TextureRegion botonPause;
	TextureRegion botonReanudar;
	public boolean touch=false;
	public Pause(MyNave juego)
	{
		Juego=juego;
		
		
		
		setWidth(35);
		setHeight(40);
		setX(Juego.w/2-(getWidth()/2));
		setY(Juego.h-getHeight());
		botonPause=new TextureRegion((Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/botones.png"),320,0,64,64);
		botonReanudar=new TextureRegion((Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/botones.png"),128,0,64,64);
		
		
		addListener(new InputListener()
		{
			public boolean touchDown(InputEvent event, float x, float y,int pointer, int button) {
			      
				setHeight(100);
	        	setWidth(100);
	        	setX((Juego.w/2)-(getWidth()/2));
	        	setY(Juego.h-getHeight());
				touch=true;
				return true;
			}
			
		});
		
	}
	
	
	public void draw(SpriteBatch batch, float parentAlpha)
	{
		if(Juego.Pantallaplay.pause==false)
		{
			batch.draw(botonPause,getX(),getY(),getWidth(),getHeight());	
		}else
		{
			batch.draw(botonReanudar,getX(),getY(),getWidth(),getHeight());
		}
		
	}
	
	
	

}
