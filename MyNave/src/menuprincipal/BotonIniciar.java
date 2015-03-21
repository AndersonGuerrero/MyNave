package menuprincipal;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class BotonIniciar extends Actor {

	MyNave Juego;
	TextureRegion botoniniciar;
	boolean inicio=false;
	public BotonIniciar(MyNave juego)
	{
		Juego=juego;
		
		setWidth(64);
		setHeight(64);
		setPosition(Juego.w/2-(getWidth()/2),Juego.h-200);
		
		if(Juego.puntage==0){
		botoniniciar=new TextureRegion((Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/botones.png"),0,0,64,64);
		}else
		{
			botoniniciar=new TextureRegion((Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/botones.png"),128,0,64,64);
		}
	
		addListener(new InputListener()
		{
			public boolean touchDown(InputEvent event, float x, float y,int pointer, int button) {
	          inicio=true;
				return true;}});
	}
	
	
	
	
	public void draw(SpriteBatch batch,float parentAlpha)
	{
		batch.draw(botoniniciar,getX(),getY(),getWidth(),getHeight());
		
		if(inicio)
		{
			((Sound)Juego.carga.Assets.get("Sound/nave.ogg")).stop();	
			inicio=false;
			Juego.setScreen(Juego.Pantallaplay);
			this.remove();
		}
	}
	
}
