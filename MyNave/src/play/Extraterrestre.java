package play;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Extraterrestre extends Actor {

	MyNave Juego;
	TextureRegion img;
	public int velocidad=0;
	public Extraterrestre(MyNave juego)
	{
		Juego=juego;

		
		setWidth(246);
		setHeight(100);
		velocidad=1;
		setPosition(Juego.w/2-(getWidth()/2), Juego.h-getHeight()+5);
		img=new TextureRegion((Texture) Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/extraterrestre.png"),10,0,(int)getWidth(),(int)getHeight());
	}
	
	
	public void draw(SpriteBatch batch, float parentAlpha) 
	{
		
		batch.draw(img,getX()-60,getY(),200,64);

	}
	
	
	
	
	public int NuevaPosiscion()
	{
		return(int)MathUtils.random(0 ,(Juego.w-60));
	}
	
}
