package play;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Estrella extends Actor
{
    MyNave Juego;
    public float statetime;
    TextureRegion[] texturas;
    Animation Aestrella;
    Rectangle rectangulo;
    TextureRegion currenFrame;
    ShapeRenderer shapeRenderer;
boolean bug=false;

	public Estrella(MyNave juego )
	{
		Juego=juego;
		
		setWidth(25);
		setHeight(25);
		setX(MathUtils.random(0 ,(Juego.w - getWidth())));
		setY(Juego.h);
		
	
	
		rectangulo=new Rectangle();
		
		rectangulo.setWidth(getWidth());
		rectangulo.setHeight(getWidth());
		rectangulo.x=getX();
		rectangulo.y=getY();
		
		shapeRenderer=new ShapeRenderer();
		
		texturas=new TextureRegion[23];
	 int cont=0;
		for(int i=0;i<texturas.length;i++)
		{
			texturas[i]=new TextureRegion((Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/estrella.png"),cont,0,64,64);
			cont+=64;
		}
		
		Aestrella=new Animation(0.05f, texturas);
		statetime= 0f;
		currenFrame=texturas[0];
	}

	

	
	

	public void draw(SpriteBatch batch) {
		
		statetime+= Gdx.graphics.getDeltaTime(); 
 	   currenFrame = Aestrella.getKeyFrame(statetime,true);

 	
 	  if(bug){
          shapeRenderer.begin(ShapeType.Rectangle);
      	shapeRenderer.setColor(Color.BLUE);
      	shapeRenderer.rect(rectangulo.x, rectangulo.y, rectangulo.width, rectangulo.height);
      	shapeRenderer.end();}
 	  
 	   rectangulo.y=getY();
         batch.draw(currenFrame,getX(),getY(),30,30); 
        
	}


	
}

