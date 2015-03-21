package menuprincipal;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class BotonOP  extends Actor
{
	MyNave Juego;
	TextureRegion botonop;
	public boolean touch=false;
	public BotonOP( MyNave juego)
	{
	Juego=juego;
	
	setWidth(64);
	setHeight(64);
	botonop=new TextureRegion((Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/botones.png"),192,0,64,64);
	
	
	
	addListener(new InputListener()
	{
		public boolean touchDown(InputEvent event, float x, float y,int pointer, int button) {
		      
			touch=true;
			return true;
		}
		
	});
	
	}
	
	public void draw(SpriteBatch batch,float parentAlpha)
	{
		batch.draw(botonop,getX(),getY(),getWidth(),getHeight());
	}
	
	
	
	
}
