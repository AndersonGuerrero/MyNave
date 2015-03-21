package presentacion;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Black extends Actor
{
	MyNave Juego; 
	 
	    AlphaAction alpha,alpha2;
	    DelayAction delay;
	    SequenceAction sequence;
	    Texture BlackRectangle;
	    TextureRegion br;
	   
	    Image ImgBR;
	    boolean fin;
	    
	public Black(MyNave juego)
	{
		Juego=juego;
		
		
		sequence = new SequenceAction();
 
        alpha = new AlphaAction();
        alpha.setAlpha(0f);
        alpha.setDuration(2f);
        
        
        alpha2 = new AlphaAction();
        alpha2.setAlpha(1f);
        alpha2.setDuration(2f);
        
       
        delay = new DelayAction();
        delay.setDuration(5f);
        
        sequence.addAction(alpha);
        sequence.addAction(delay);
        sequence.addAction(alpha2);
    
        addAction(sequence);

        BlackRectangle =(Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/black.jpg");
        
        br = new TextureRegion(BlackRectangle,0,0,Juego.w,Juego.h);

        ImgBR = new Image(br);
        ImgBR.getColor().a = 1;
	
	}
	
	
    public void draw(SpriteBatch batch,float parentAlpha){
     
        ImgBR.getColor().a = getColor().a;
        ImgBR.draw(batch, parentAlpha);
        
        if(sequence.getActions().size == 0)
        {
        	((Music)Juego.carga.Assets.get("Sound/presentacion.ogg")).stop();
           Juego.setScreen(Juego.menuPrincipal);
            this.remove();
        }
    }
	
	
}
