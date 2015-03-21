package play;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Explocion extends Actor
{
     MyNave Juego;
	TextureRegion [] partes;
	TextureRegion temp;
	Texture imagen;
    public Animation explo;
    public float stateTime;
	public TextureRegion currentFrame;
    int ancho=108,posicion=0;

    
	public Explocion(MyNave juego,Vector2 ubi)
	{
		Juego=juego;
		
	setX(ubi.x);
	setY(ubi.y);
		
       imagen=(Texture) Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/explosion.png") ;
		
       partes=new TextureRegion[18];
	
       for(int i=0;i<partes.length;i++){
		
		temp =new TextureRegion(imagen,posicion,0,ancho,imagen.getHeight());
		posicion+=ancho;
		partes[i]=temp;
       }
		explo=new Animation(0.1f, partes);

		stateTime=0f;
	    currentFrame = partes[0];    
	
	}

	
	public void draw(SpriteBatch batch) 
	{
	    stateTime+= Gdx.graphics.getDeltaTime(); 
	 	currentFrame = explo.getKeyFrame(stateTime,true);
	 	 
	        batch.draw(currentFrame,getX(),getY()); 
	        
	}
	
	
	
		
		
		




	
}
