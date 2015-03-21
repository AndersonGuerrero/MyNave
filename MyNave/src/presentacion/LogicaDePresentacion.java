package presentacion;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class LogicaDePresentacion extends Table
{
	
MyNave Juego;
Black black;
	public LogicaDePresentacion(MyNave juego)
	{
		Juego=juego;
		setClip(true);
		setBounds(0, 0, Juego.w, juego.h);
		 
		black=new Black(Juego);
		addActor(black);
	}
	
	
public void act(float delta) {super.act(delta);    }
	
	
	public void draw(SpriteBatch batch, float parentAlpha) {
	      batch.setColor(Color.WHITE);
	      super.draw(batch, parentAlpha);
	     }
}
