package menuprincipal;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class LogicaMenuPrincipal extends Table
{
	MyNave Juego;
	BotonIniciar btnInicio;
	BotonOP btnOp;
	BotonSalir btnsalir;
	public LogicaMenuPrincipal(MyNave juego,Screen Pantalla)
	{
		Juego=juego;
		setBounds(0, 0, Juego.w, Juego.h);
		setClip(true);
		
		btnInicio=new BotonIniciar(Juego);
		btnOp=new BotonOP(Juego);
		btnOp.setPosition(btnInicio.getX(), btnInicio.getY()-100);
		
		btnsalir=new BotonSalir(Juego);
		btnsalir.setPosition(btnOp.getX(), btnOp.getY()-100);
		addActor(btnInicio);
		addActor(btnOp);
		addActor(btnsalir);
	}

	
	public void act(float delta) 
	{super.act(delta);}
	
	public void draw(SpriteBatch batch, float parentAlpha) 
	{
	      batch.setColor(Color.WHITE);
	      super.draw(batch, parentAlpha);
	}
	
}
