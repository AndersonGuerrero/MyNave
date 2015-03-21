package play;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Meteorito extends Actor{

	
	public float stateTime;
	MyNave Juego;
	public Animation mover;
	TextureRegion[] partes;
	TextureRegion temp;
	Texture imagen;
	boolean bug=false;
	 public TextureRegion currentFrame;
    ShapeRenderer shapeRenderer; 
	 Rectangle rect;
	
	public Meteorito(MyNave juego)
	{
		Juego=juego;
		
		
		setWidth(60);
		setHeight(70);
		rect= new Rectangle();
	    rect.height =getHeight()/2;
	    rect.width = getWidth()-20;
	    
	    rect.y =Juego.h-100;
		
	  
	   
	    
	    setOrigin(getWidth()/2, getHeight()/2);
	    
	    setRotation(-38);
	    
	    shapeRenderer=new ShapeRenderer();
		

		imagen=(Texture) Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/meteorito.png") ;
		
		 
		
		partes=new TextureRegion[10];
		temp =new TextureRegion(imagen,0,0,128,128);
		partes[0]=temp;
		
		temp =new TextureRegion(imagen,128,0,128,128);
		partes[1]=temp;
		
		temp =new TextureRegion(imagen,256,0,128,128);
		partes[2]=temp;
		
		temp =new TextureRegion(imagen,384,0,128,128);
		partes[3]=temp;
		
		temp =new TextureRegion(imagen,512,0,128,128);
		partes[4]=temp;
		
		temp =new TextureRegion(imagen,640,0,128,128);
		partes[5]=temp;
		
		temp =new TextureRegion(imagen,768,0,128,128);
		partes[6]=temp;
		
		temp =new TextureRegion(imagen,896,0,128,128);
		partes[7]=temp;
		temp =new TextureRegion(imagen,1024,0,128,128);
		partes[8]=temp;
		temp =new TextureRegion(imagen,1152,0,128,128);
		partes[9]=temp;
		
		
		mover=new Animation(0.1f, partes);

		stateTime=0f;
	    currentFrame = partes[0];    
		
		
	}
	
	
	
	public void modoBug()
	{
		  if(bug){
		        shapeRenderer.begin(ShapeType.Rectangle);
		    	shapeRenderer.setColor(Color.GREEN);
		    	shapeRenderer.rect(rect.x, rect.y, rect.width, rect.height);
		    	shapeRenderer.end();
		    	}
	}
	
	
}
