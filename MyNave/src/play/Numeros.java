package play;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Numeros 
{
MyNave Juego;
      TextureRegion uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,cero;
      Array<TextureRegion> cantidad;
	public Numeros(MyNave juego)
	{
		Juego=juego;
		
		uno=new TextureRegion( (Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/numeros.png"),0,0,32,64);
		dos=new TextureRegion( (Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/numeros.png"),32,0,32,64);
		tres=new TextureRegion( (Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/numeros.png"),64,0,32,64);
		cuatro=new TextureRegion( (Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/numeros.png"),96,0,32,64);
		cinco=new TextureRegion( (Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/numeros.png"),128,0,32,64);
		seis=new TextureRegion( (Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/numeros.png"),160,0,32,64);
		siete=new TextureRegion( (Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/numeros.png"),192,0,32,64);
		ocho=new TextureRegion( (Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/numeros.png"),224,0,32,64);
		nueve=new TextureRegion( (Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/numeros.png"),256,0,32,64);
		cero=new TextureRegion( (Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/numeros.png"),288,0,32,64);
	}
	
	public Array<TextureRegion> pintarcifra(int cantidad)
	{
		this.cantidad=new Array<TextureRegion>();
		String n=cantidad+"";
		
		
		
		for(int i=0;i<n.length();i++)
		{
			
			if(n.charAt(i)=='1')
			{
				this.cantidad.add(uno);
				
			}
			else if(n.charAt(i)=='2')
			{
				this.cantidad.add(dos);
			}
			else if(n.charAt(i)=='3')
			{
				this.cantidad.add(tres);
			}
			if(n.charAt(i)=='4')
			{
				this.cantidad.add(cuatro);
			}
			if(n.charAt(i)=='5')
			{
				this.cantidad.add(cinco);
			}
			if(n.charAt(i)=='6')
			{
				this.cantidad.add(seis);
			}
			if(n.charAt(i)=='7')
			{
				this.cantidad.add(siete);
			}
			if(n.charAt(i)=='8')
			{
				this.cantidad.add(ocho);
			}
			if(n.charAt(i)=='9')
			{
				this.cantidad.add(nueve);
			}
			if(n.charAt(i)=='0')
			{
				this.cantidad.add(cero);
			}
		}
		
		return this.cantidad;
		
	}
	
}
