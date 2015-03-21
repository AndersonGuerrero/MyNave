package carga;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
public class BarraDeCargar extends Actor 
{
	MyNave Juego;
	Texture texturabarra,llenado;
	TextureRegion barra;
	int cont=0;
	public BarraDeCargar(MyNave juego)
	{
		Juego=juego;
		setHeight(Juego.h);
		setWidth(Juego.w);
		setPosition(0,0);
		
	llenado=new Texture(Gdx.files.internal("Images/"+Juego.w+"x"+Juego.h+"/llenado.jpg"));
	texturabarra=new Texture(Gdx.files.internal("Images/"+Juego.w+"x"+Juego.h+"/carga.png"));
	barra=new TextureRegion(texturabarra,Juego.w,Juego.h);
	}

	
	public void draw(SpriteBatch batch,float parentAlpha)
	{	
	
		Juego.carga.CargarAssets();
		Juego.carga.Assets.update();
		 batch.draw(llenado, getX()+27,Juego.h/3-40,cont,64);
		 batch.draw(barra, 5,0);
		 if(Juego.carga.Assets.getProgress()<1){cont=cont+7;}
		 
		 if(Juego.carga.Assets.getProgress()==1)
		 {
			 
			 Juego.setScreen(Juego.pantallaPresentacion);
			 
			 this.remove();
			
		 }
	}
}