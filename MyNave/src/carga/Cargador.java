package carga;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class Cargador {

	public AssetManager Assets;

	int w,h;
	public Cargador(int w,int h)
	{
		Assets=new AssetManager();
		this.w=w;
		this.h=h;
	}
	
	public void CargarAssets()
	{
		//              Imagenes
    Assets.load("Images/"+w+"x"+h+"/botones.png",Texture.class);
   
	Assets.load("Images/"+w+"x"+h+"/estrella.png",Texture.class);	
	Assets.load("Images/"+w+"x"+h+"/meteorito.png",Texture.class);
	Assets.load("Images/"+w+"x"+h+"/misil.png",Texture.class);
	Assets.load("Images/"+w+"x"+h+"/nave1.png",Texture.class);
	Assets.load("Images/"+w+"x"+h+"/nave2.png",Texture.class);
	Assets.load("Images/"+w+"x"+h+"/numeros.png",Texture.class);
	Assets.load("Images/"+w+"x"+h+"/presentacion.jpg",Texture.class);	
	Assets.load("Images/"+w+"x"+h+"/black.jpg",Texture.class);	
	Assets.load("Images/"+w+"x"+h+"/fondomenu.jpg",Texture.class);	
	Assets.load("Images/"+w+"x"+h+"/soundOF.png",Texture.class);	
	Assets.load("Images/"+w+"x"+h+"/soundON.png",Texture.class);	
	Assets.load("Images/"+w+"x"+h+"/btncerrar.png",Texture.class);
	Assets.load("Images/"+w+"x"+h+"/navemenu.png",Texture.class);
	Assets.load("Images/"+w+"x"+h+"/barraestado.jpg",Texture.class);
	Assets.load("Images/"+w+"x"+h+"/findelJuego.png",Texture.class);
	Assets.load("Images/"+w+"x"+h+"/explosion.png",Texture.class);
	Assets.load("Images/"+w+"x"+h+"/planeta.png",Texture.class);
	Assets.load("Images/"+w+"x"+h+"/fondotransparente.png",Texture.class);
	Assets.load("Images/"+w+"x"+h+"/exploNuclear.png",Texture.class);
	Assets.load("Images/"+w+"x"+h+"/extraterrestre.png",Texture.class);
	
	//                 Mundos
	Assets.load("Images/"+w+"x"+h+"/Mundos/mundo1.jpg",Texture.class);	
	Assets.load("Images/"+w+"x"+h+"/Mundos/mundo2.jpg",Texture.class);	
	Assets.load("Images/"+w+"x"+h+"/Mundos/mundo3.jpg",Texture.class);	
	Assets.load("Images/"+w+"x"+h+"/Mundos/mundo4.jpg",Texture.class);	
	Assets.load("Images/"+w+"x"+h+"/Mundos/mundo5.jpg",Texture.class);	
	Assets.load("Images/"+w+"x"+h+"/Mundos/mundo6.jpg",Texture.class);
	
	
	//           Sonidos
	Assets.load("Sound/Boton.ogg",Sound.class);	
	Assets.load("Sound/disparo.ogg",Sound.class);
	Assets.load("Sound/explosion.ogg",Sound.class);
	Assets.load("Sound/mover.ogg",Sound.class);
	Assets.load("Sound/punto.ogg",Sound.class);
	Assets.load("Sound/star.ogg",Sound.class);	
	Assets.load("Sound/nave.ogg",Sound.class);
	//                         Music
	Assets.load("Sound/presentacion.ogg",Music.class);
	
	}
	
}
