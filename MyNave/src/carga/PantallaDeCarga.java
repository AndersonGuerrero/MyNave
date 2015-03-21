package carga;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class PantallaDeCarga implements Screen{

MyNave Juego;
private Stage stage;
private LogicaDeCarga LogicaCarga;
SpriteBatch Batch;
OrthographicCamera Camera;

public PantallaDeCarga(MyNave juego)
{
	this.Juego=juego;
	stage=new Stage();
}

	public void render(float delta) {
	
		Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        
        Batch.setProjectionMatrix(Camera.combined);
        
        stage.act(delta);
        stage.draw();
	}

	public void show() 
	{
		
	LogicaCarga=new LogicaDeCarga(Juego, this);
	
	Gdx.input.setInputProcessor(stage);
	stage.addActor(LogicaCarga);
	
	Batch=new SpriteBatch();
	
	Camera=new OrthographicCamera();
	Camera.setToOrtho(false,Juego.w,Juego.h);
	
	}
	
    public void resize(int width, int height) {}

	public void hide() {}

	public void pause() {}

	public void resume() {}

	public void dispose() {}

}
