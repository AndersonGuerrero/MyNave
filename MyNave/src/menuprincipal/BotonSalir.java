package menuprincipal;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class BotonSalir extends Actor {
    MyNave Juego;
	TextureRegion btnsalir;
	public BotonSalir( MyNave juego)
	{
		Juego=juego;
		
		setHeight(64);
		setWidth(64);
		btnsalir=new TextureRegion((Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/botones.png"),384,0,64,64);
	
		addListener(new InputListener(){

			public boolean touchDown(InputEvent event, float x, float y,int pointer, int button) {
				Juego.dispose();
				return true;
			}
		});
	
	}
	
	public void draw(SpriteBatch batch,float parentAlpha)
	{
		batch.draw(btnsalir,getX(),getY(),getWidth(),getHeight());
	}
}
