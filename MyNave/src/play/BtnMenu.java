package play;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class BtnMenu extends Actor
{
	MyNave Juego;
	TextureRegion botonMenu;
	boolean touch;
	public BtnMenu(MyNave juego)
	{
	Juego=juego;
		
		
		
		setWidth(64);
		setHeight(64);
		setX(Juego.w/2-(getWidth()/2));
	
		botonMenu=new TextureRegion((Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/botones.png"),64,0,64,64);
		
		
		
		addListener(new InputListener()
		{
			public boolean touchDown(InputEvent event, float x, float y,int pointer, int button) {

				Juego.Pantallaplay.dispose();
				Juego.setScreen(Juego.menuPrincipal);
				
				return true;
			}
			
		});
	}

	
	
	public void draw(SpriteBatch batch, float parentAlpha)
	{
			batch.draw(botonMenu,getX(),getY(),getWidth(),getHeight());	

	}
	
	
	
}
