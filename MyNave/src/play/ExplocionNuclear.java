package play;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ExplocionNuclear extends Actor
{
     MyNave Juego;
	TextureRegion [] partes;
	TextureRegion temp;
	Texture imagen;
    public Animation explonuclear;
    public float stateTime;
	public TextureRegion currentFrame;
    int ancho=0;

    
	public ExplocionNuclear(MyNave juego,Vector2 ubi)
	{
		Juego=juego;
		
	setX(ubi.x);
	setY(ubi.y);
		
       imagen=(Texture) Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/exploNuclear.png") ;
		
       partes=new TextureRegion[22];
	
       for(int i=0;i<partes.length;i++){
		
		temp =new TextureRegion(imagen,ancho,0,64,64);
		ancho+=64;
		partes[i]=temp;
       }
		explonuclear=new Animation(0.3f, partes);

		stateTime=0f;
	    currentFrame = partes[0];    
	
	}

	
	public void draw(SpriteBatch batch) 
	{
	    stateTime+= Gdx.graphics.getDeltaTime(); 
	 	currentFrame = explonuclear.getKeyFrame(stateTime,true);
	 	 
	        batch.draw(currentFrame,getX(),getY(),80,80); 
	        
	}
	
	
	
		
		
		




	
}
