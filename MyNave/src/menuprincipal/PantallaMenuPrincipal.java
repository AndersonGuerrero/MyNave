package menuprincipal;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class PantallaMenuPrincipal implements Screen {

	MyNave Juego;
    OrthographicCamera Camera;
    SpriteBatch batch;
    int dirX,dirY;
	Stage stage;
	int fase=1;
	TextureRegion fondo;
	TextureRegion naveup,navedow,navelef,navering;
	LogicaMenuPrincipal LogicaMenuPrincipal;
	TextureRegion soundOF,soundON,btncerrar;
	
	public PantallaMenuPrincipal(MyNave juego)
	{
		Juego=juego;
		stage=new Stage();
	}
	
	public void render(float delta) {
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        
        batch.setProjectionMatrix(Camera.combined);
        
        
		batch.begin();
        batch.draw(fondo,0,-5,Juego.w+5,Juego.h+5);
        
        if(dirY+64>=Juego.h && dirX+64>=Juego.w){fase=2;}
       
        if(dirY<=0 && dirX<=0){fase=1;}
        
        if(fase==1){
        	
        if(dirY+64<=Juego.h)
        {
        	dirY++;
        	batch.draw(naveup,dirX,dirY);
        }
        else if(dirX+64<=Juego.w)
        {
        	dirX++;
        	batch.draw(navering,dirX,dirY);
        }
        }
        
        if(fase==2)
        {
        	if(dirY+64>=64)
            {
            	dirY--;
            	batch.draw(navedow,dirX,dirY);
            }
            else if(dirX+64>=64)
            {
            	dirX--;
            	batch.draw(navelef,dirX,dirY);
            }
        }
        batch.end();
        stage.act(delta);
        stage.draw();
        
      
        if(LogicaMenuPrincipal.btnOp.touch)
        {
        	batch.begin();
        	
        	if(Juego.sound)
        	{
        	batch.draw(soundON,0,0);
        	batch.draw(btncerrar,0,Juego.h-btncerrar.getRegionHeight());
        	}else
        	{
        		
        		batch.draw(soundOF,0,0);
        		batch.draw(btncerrar,0,Juego.h-btncerrar.getRegionHeight());
        	}
        	
        	if(Gdx.input.isTouched())
        	{
        		if(Gdx.input.getX()<=btncerrar.getRegionWidth() && Gdx.input.getY()<=btncerrar.getRegionHeight())
        		{
        			LogicaMenuPrincipal.btnOp.touch=false;
        		}
        	}
        	
        	if(Gdx.input.isTouched())
        	{
        		if(( Gdx.input.getX()<=Juego.w/2+100 && Gdx.input.getX()>=Juego.w/2-100) && (Gdx.input.getY()<=(Juego.h/2)+100 && Gdx.input.getY()>=(Juego.h/2)-100 ))
        		{
        			if(Juego.sound)
        			{Juego.sound=false;
        			((Sound)Juego.carga.Assets.get("Sound/nave.ogg")).stop();
        			}
        			else{Juego.sound=true;
        			((Sound)Juego.carga.Assets.get("Sound/nave.ogg")).loop(0.5f);
        			}
        		}
        	}
        	batch.end();
        }
	}
	
	public void resize(int width, int height) {}

	public void show() {
		Gdx.input.setInputProcessor(stage);	
		LogicaMenuPrincipal=new LogicaMenuPrincipal(Juego,this);
		stage.addActor(LogicaMenuPrincipal);
		batch=new SpriteBatch();
        Camera=new OrthographicCamera();
		Camera.setToOrtho(false, Juego.w, Juego.h);
		
		fondo=new TextureRegion((Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/fondomenu.jpg"),0,0,Juego.w,Juego.h);
		navedow=new TextureRegion((Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/navemenu.png"),64,0,64,64);
		naveup=new TextureRegion((Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/navemenu.png"),0,0,64,64);
		navelef=new TextureRegion((Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/navemenu.png"),128,0,64,64);
		navering=new TextureRegion((Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/navemenu.png"),192,0,64,64);
		
		if(Juego.sound)
		{
			((Sound)Juego.carga.Assets.get("Sound/nave.ogg")).loop(0.5f);	
		}
		
		soundON=new TextureRegion((Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/soundON.png"),0,0,Juego.w,Juego.h);
		soundOF=new TextureRegion((Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/soundOF.png"),0,0,Juego.w,Juego.h);
	    btncerrar=new TextureRegion((Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/btncerrar.png"),0,0,32,32);		
	}

	public void hide() {}

	public void pause() {}

	public void resume() {}
	
	public void dispose() {}

}
