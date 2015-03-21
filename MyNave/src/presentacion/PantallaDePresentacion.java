package presentacion;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class PantallaDePresentacion implements Screen {


	MyNave Juego;
	SpriteBatch batch;
	OrthographicCamera Camera;
	Stage stage;
	LogicaDePresentacion LogicaPresentacion;
	TextureRegion fondo;
	
	public PantallaDePresentacion(MyNave juego)
	{
		Juego=juego;
		stage=new Stage();
	}
	
	public void render(float delta) {

		   Gdx.gl.glClearColor(0,0,0,0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
			  
			  batch.setProjectionMatrix(Camera.combined);
			  
			  batch.begin();
			  batch.draw(fondo,0,-3,Juego.w+3,Juego.h);
			  batch.end();
			  
			  stage.act(delta);
			  stage.draw();
	}


	public void resize(int width, int height) {
   
	}


	public void show() 
	{
		
		fondo=new TextureRegion((Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/presentacion.jpg"),0,0,Juego.w,Juego.h);
		LogicaPresentacion=new LogicaDePresentacion(Juego);
		batch=new SpriteBatch(); 
		  
		stage.addActor(LogicaPresentacion);
		
		
        Camera=new OrthographicCamera();
        Camera.setToOrtho(false,Juego.w,Juego.h);
     
        ((Music)Juego.carga.Assets.get("Sound/presentacion.ogg")).setVolume(0.3f);
        ((Music)Juego.carga.Assets.get("Sound/presentacion.ogg")).play();
	}


	public void hide()
	{}

	public void pause() {}

	public void resume() {}

	public void dispose() 
	{
	}

}
