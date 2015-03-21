package carga;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class LogicaDeCarga extends Table{

     MyNave Juego;	
     BarraDeCargar Barra;
	public LogicaDeCarga(MyNave juego,Screen pantalla)
	{
		Juego=juego;
		setBounds(0, 0,Juego.w, Juego.h);
		setClip(true);
		
		Barra=new BarraDeCargar(Juego);
		addActor(Barra);
	}

	
	public void act(float delta) 
	{super.act(delta);}
	
	public void draw(SpriteBatch batch, float parentAlpha) 
	{
	      batch.setColor(Color.WHITE);
	      super.draw(batch, parentAlpha);
	}
	
}
