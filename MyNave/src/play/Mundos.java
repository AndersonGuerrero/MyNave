package play;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Mundos extends Actor{
	public float velocidad=-5;
	MyNave Juego;
	float p=0;
	TextureRegion mundo;
	Texture img;
	float recorido=0.5f;
	public Mundos(MyNave juego)
	{
		Juego=juego;
		velocidad=0;
		
		img=(Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/Mundos/mundo"+Juego.nivel+".jpg");
		
		mundo=new TextureRegion(img,0,5,Juego.w,Juego.h-7);
	}
	

	public void draw(SpriteBatch batch, float parentAlpha) 
	{
		
		if(Juego.nivel>=3){
		if(velocidad<=-Juego.h)
		{
			velocidad=0;
		}
		
		if(Juego.Pantallaplay.pause==false){velocidad-=recorido;}
		
		p=Juego.h+velocidad;

		batch.draw(mundo,0,velocidad,Juego.w,Juego.h);
		batch.draw(mundo,0,p,Juego.w,Juego.h);
		
		}else{
		batch.draw(mundo,0,0,Juego.w,Juego.h);
		}
	}
	



	
	
}
