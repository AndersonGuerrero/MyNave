package play;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class Misil
{
	 public float stateTime;
	MyNave Juego;
	public Animation volar;
	TextureRegion[] partes;
	TextureRegion temp;
	Texture imagen;
	 public TextureRegion currentFrame;

	 Rectangle rect;
	 ShapeRenderer shapeRenderer; 
	 
public Misil(MyNave juego,Nave n)
{
	shapeRenderer=new ShapeRenderer();
	
	    rect= new Rectangle();
	    rect.height = 64;
	    rect.width = 12;
	    rect.x = n.getX()+10;
	    rect.y = n.getHeight()/2;

	Juego=juego;

	imagen=(Texture) Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/misil.png") ;
	
	
	partes=new TextureRegion[6];
	temp =new TextureRegion(imagen,0,0,12,imagen.getHeight());
	partes[0]=temp;
	
	temp =new TextureRegion(imagen,12,0,12,imagen.getHeight());
	partes[1]=temp;
	
	temp =new TextureRegion(imagen,24,0,12,imagen.getHeight());
	partes[2]=temp;
	
	temp =new TextureRegion(imagen,36,0,12,imagen.getHeight());
	partes[3]=temp;
	
	temp =new TextureRegion(imagen,48,0,12,imagen.getHeight());
	partes[4]=temp;
	
	temp =new TextureRegion(imagen,60,0,12,imagen.getHeight());
	partes[5]=temp;
	volar=new Animation(0.1f, partes);

    currentFrame = partes[0];     
	
}



public void Bug()
{
	
	        shapeRenderer.begin(ShapeType.Rectangle);
	    	shapeRenderer.setColor(Color.YELLOW);
	    	shapeRenderer.rect(rect.x, rect.y, rect.width, rect.height);
	    	shapeRenderer.end();
}


}
