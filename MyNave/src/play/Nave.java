package play;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Nave extends Actor
{
    MyNave Juego;
    TextureRegion up,left,right,destroid;
    TextureRegion up2,left2,right2,destroid2;
	Animation Aup,Aleft,Aright,Adestrid;
	Animation Aup2,Aleft2,Aright2,Adestrid2;
	TextureRegion[][] Temp,Temp2;
	Vector2 velocidad;
	 private float stateTime;
	 public  TextureRegion currentFrame;
	 Rectangle punta1,punta2,punta3;
	 public boolean choque=false;
	
	 boolean boug=false;
	 ShapeRenderer shapeRenderer;
	 Explocion explo;
	 Texture text,text2;
	 
	public Nave(MyNave juego)
	{
		
	Juego=juego;
	
	
	text2=(Texture) Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/nave2.png");
	
	
	
Temp2= TextureRegion.split(text2, text2.getWidth()/4,text2.getHeight());
	
	
	up2=new TextureRegion();
	up2=Temp2[0][0];
	
	left2=new TextureRegion();
	left2=Temp2[0][2];
	
	right2=new TextureRegion();
	right2=Temp2[0][3];
	
	destroid2=new TextureRegion();
	destroid2=Temp2[0][1];
	
    Aup2=new Animation(0.2f, up2);
    
    Aleft2=new Animation(0.2f, left2);
    Aright2=new Animation(0.2f, right2);
    
	Adestrid2=new Animation(0.2f, destroid2);
	
	
	
	
	
	
	
	
	
	
	
	
	text=(Texture) Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/nave1.png");
	
	
	Temp= TextureRegion.split(text, text.getWidth()/4,text.getHeight());
	
	
	up=new TextureRegion();
	up=Temp[0][0];
	
	left=new TextureRegion();
	left=Temp[0][2];
	
	right=new TextureRegion();
	right=Temp[0][3];
	
	destroid=new TextureRegion();
	destroid=Temp[0][1];
	
    Aup=new Animation(0.2f, up);
    
    Aleft=new Animation(0.2f, left);
    Aright=new Animation(0.2f, right);
    
	Adestrid=new Animation(0.2f, destroid);
	
	setWidth(64);
	setHeight(64);
	setPosition(Juego.w/2-(getWidth()/2), 0);
	velocidad=new Vector2(0, 0);
	
	stateTime = 0f;
	if(Juego.nivel<3){
	currentFrame=up;
	}else{currentFrame=up2;}
	   punta1=new Rectangle();
       punta1.height=20;
       punta1.width=13;
       punta1.x=getX();
       punta1.y=(getY()+getHeight())-punta1.height;

       punta2=new Rectangle();
       punta2.height=10;
       punta2.width=35;
       punta2.x=getX()+15;
       punta2.y=(getY()+getHeight())-(punta1.height+punta2.height);
       
       
       punta3=new Rectangle();
       punta3.height=10;
       punta3.width=61;
       punta3.x=getX()+2;
       punta3.y=getY()+18;
       
      shapeRenderer=new ShapeRenderer(); 
      
      
      
      
     
	}

	
	
	public void draw(SpriteBatch batch, float parentAlpha) 
	{
		
	velocidad.x=0;
	velocidad.y=0;
		
	if(Juego.Pantallaplay.pause==false)
	{
	if(Juego.tipo==1)
	{
		if(Gdx.input.getAccelerometerX()<-2){velocidad.x=Juego.nivel;}
		
		if( Gdx.input.getAccelerometerX()>2){velocidad.x=-Juego.nivel;}
		
		
	}else
	{
		if(Gdx.input.isKeyPressed(Keys.LEFT) ){velocidad.x=-Juego.nivel*2;}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)){velocidad.x=Juego.nivel*2;}
	}
	
	}
	
		
		if(choque==false){
		setX(getX()+velocidad.x);
		setY(getY()+velocidad.y);
		}
		
		
	

		if(getX()+getWidth()>=Juego.w)
		{
		setX(getX()-velocidad.x);
		}
		
		if(getX()<=0)
		{
			setX(getX()-velocidad.x);
		}
		
		
		
		punta1.x=(getX()+(getWidth()/2))-(punta1.width/2);
		punta1.y=(getY()+getHeight())-punta1.height-2;

		 punta2.x=getX()+15;
	     punta2.y=(getY()+getHeight())-(punta1.height);
		
	     
	     punta3.x=getX()+2;
	       punta3.y=getY()+18;
	     
		
		if(velocidad.x<0)
		{
			punta1.x=punta1.x-10;
			punta2.x=punta2.x-8;
		}else if(velocidad.x>0)
		{
			punta1.x=punta1.x+10;
			punta2.x=punta2.x+8;
		}
		
		
		if(Juego.nivel>=3)
		{
			currentFrame = Aup2.getKeyFrame(stateTime,true);
			if(velocidad.x> 0 & velocidad.y == 0)    currentFrame = Aright2.getKeyFrame(stateTime,true);
	        if(velocidad.x< 0 & velocidad.y == 0)    currentFrame = Aleft2.getKeyFrame(stateTime,true);
		}
		else{
		currentFrame = Aup.getKeyFrame(stateTime,true);
		if(velocidad.x> 0 & velocidad.y == 0)    currentFrame = Aright.getKeyFrame(stateTime,true);
        if(velocidad.x< 0 & velocidad.y == 0)    currentFrame = Aleft.getKeyFrame(stateTime,true);
		}
       
		
		
		  if(boug){
		        shapeRenderer.begin(ShapeType.Rectangle);
		    	shapeRenderer.setColor(Color.YELLOW);
		    	shapeRenderer.rect(punta1.x, punta1.y, punta1.width, punta1.height);
		    	shapeRenderer.rect(punta2.x, punta2.y, punta2.width, punta2.height);
		    	shapeRenderer.rect(punta3.x, punta3.y, punta3.width, punta3.height);
		    	shapeRenderer.end();}
		
        if(choque)
        {
        	
        	
        	explo.currentFrame = explo.explo.getKeyFrame(explo.stateTime,true);
        	
        	explo.draw(batch);
        	
        	if(explo.stateTime>=1)
            {
            	choque=false;
            }
        }else{
        
        stateTime += Gdx.graphics.getDeltaTime();   
        batch.draw(currentFrame, getX(), getY());
        
        }
        
        
      
        
	}
	
	public void exploto()
	{
		explo=new Explocion(Juego, new Vector2(getX()-30, getY()-5));
	}
	


}
