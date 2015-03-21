package play;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class LogicaPlay extends Table {

	MyNave Juego;
	Nave nave;
    Pause pause;
    BtnMenu botonMenu;
    Extraterrestre extrate;
	public LogicaPlay(MyNave juego,Screen pantalla)
	{
		Juego=juego;
		setClip(true);
		setBounds(0, 0, Juego.w,Juego.h);
		
		extrate=new Extraterrestre(Juego);
		
		addActor(extrate);
	pause=new Pause(Juego);
	addActor(pause);
		
	nave=new Nave(Juego);
	addActor(nave);
	
	
   
	botonMenu=new BtnMenu(Juego);
	}
	

	
	public void draw(SpriteBatch batch, float parentAlpha) {
		batch.setColor(Color.WHITE);
		super.draw(batch, parentAlpha);
	}


	public void act(float delta) {
		super.act(delta);
	}
	
	
}
