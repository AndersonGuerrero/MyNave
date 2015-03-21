package play;

import java.util.Iterator;

import com.GsoftGames.MyNave.MyNave;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class PantallaPlay implements Screen{
	
	MyNave Juego;
	int rapidezmete=1;
	
	long tiempodisparo;
	boolean puedeDisparar;
	
	Stage stage;
	float desplazarplaneta=0;
	int disparotime;
	
	OrthographicCamera camera;
	SpriteBatch batch;
	boolean disparo;
	LogicaPlay logica;
	public boolean pause=false;

	private long timeestrellas;

	private Array<Misil> misiles;
	private Array<Explocion> explociones;
	private Array<ExplocionNuclear> explocionesNucleares;
	private Array<Meteorito>meteoritos;
	private Array<Estrella>estrellas;
	TextureRegion barraestado,finJuego,planeta,meteoritobarra,estrellabarra;
	Vector2 posicionNave;
    int numeroEstrellas=0;
	 boolean fin=false;
	 Vector2 Ubiexplocion;
     Mundos mundos;
	
	 Numeros numeros;
	public PantallaPlay(MyNave juego)
	{
		Juego=juego;
		stage=new Stage();
	}
	
	public void render(float delta) 
	{
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        
        batch.setProjectionMatrix(camera.combined);
        
        
        
        if(logica.pause.touch){logica.pause.touch=false;pause();}
        
      if(pause==false){
       
    	  
    	  if(Juego.nivel>=3)
    	  {
    	   if(TimeUtils.millis() - timeestrellas > 5000){
              
               NuevaEstrella();
               timeestrellas = TimeUtils.millis();
           }
    	  }
    	  
  
         
   
        
        
        if(TimeUtils.millis() - tiempodisparo > disparotime){
            puedeDisparar=true;
            tiempodisparo = TimeUtils.millis();
        }
        
        
        if(Juego.tipo==1)
        {
        	if(Gdx.input.isTouched() && puedeDisparar)
        	{
        	dispararMisil();
        	puedeDisparar=false;
        	}
        }else if(Juego.tipo==0)
        {
        	if(Gdx.input.isKeyPressed(Keys.UP) && puedeDisparar)
        	{
            puedeDisparar=false;
        	dispararMisil();
        	}
        }

        
	}
      
      
        
        if(fin)
        {
        	if(Gdx.input.isTouched())
        	{
        		((Sound)Juego.carga.Assets.get("Sound/nave.ogg")).stop();	
        		Juego.setScreen(Juego.menuPrincipal);	
        		fin=false;
        		Juego.vida=3;
        	}
        }
       
        batch.begin();
        
        
        mundos.draw(batch,0);
        
        
    	if((int)logica.extrate.getX()<(int)posicionNave.x)
  	     {
  	    	 logica.extrate.setX(logica.extrate.getX()+logica.extrate.velocidad); 
  	     }else if((int)logica.extrate.getX()>(int)posicionNave.x)
  	     {logica.extrate.setX(logica.extrate.getX()-logica.extrate.velocidad);}
        
        spawn();
      
        iteratorExplociones();
        
        iterator();
        
    
        iteratormisiles();
        iteratorEstrellas();
        
        batch.draw(barraestado,0,Juego.h-32);
        
        
        
       
        
   if(Juego.nivel>=3){
        	
        	desplazarplaneta-=0.3f;
        	if(desplazarplaneta>-100){
        		batch.draw(planeta,0,desplazarplaneta);
        	}
        
        }else
        {
        	batch.draw(planeta,0,0);
        }
        
   iteratorExplocionesNucleares();
        
        
        if(fin)
        {
        	Juego.puntage=0;	
            batch.draw(finJuego,0,0);
        }

        
      
        
        if(pause)
        {
        	
      	  batch.draw((Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/fondotransparente.png"),0,0,Juego.w,Juego.h);
        }
        
        int acu=0;
        for(int i=0;i<Juego.vida;i++)
        {
        acu=acu+20;
        batch.draw(logica.nave.currentFrame,Juego.w-acu,Juego.h-32,20,32);
        }
        
        pintarPuntageestrellas(numeros.pintarcifra(numeroEstrellas));
        pintarPuntage(numeros.pintarcifra(Juego.puntage));
        batch.end();
        
        if(fin==false){
            stage.act();
    		stage.draw();
            }

      
        
	}

	
	public void resize(int width, int height){}


	public void show() 
	{
		
		  
	        
	        
	        if(Juego.nivel<3)
	        {
	        	disparotime=1000;
	        }else
	        {
	        	disparotime=800;
	        }
	        
	        logica=new LogicaPlay(Juego, this);
	        stage.addActor(logica);
		Gdx.input.setInputProcessor(stage);
		
		batch=new SpriteBatch();
		camera=new OrthographicCamera();
		camera.setToOrtho(false, Juego.w, Juego.h);
		
		

		tiempodisparo=TimeUtils.millis();
		
	 
	 Ubiexplocion=new Vector2();
	 posicionNave=new Vector2();
	 posicionNave.x=(Juego.w/2);
	 explociones=new Array<Explocion>();
	 explocionesNucleares=new Array<ExplocionNuclear>();
	 
		meteoritos = new Array<Meteorito>();
		misiles =new Array<Misil>();
		estrellas=new Array<Estrella>();
		
		numeros=new Numeros(Juego);

		
		mundos=new Mundos(Juego);
		
		
		barraestado=new TextureRegion((Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/barraestado.jpg"),0,0,Juego.w,32);
		
		finJuego=new TextureRegion((Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/findelJuego.png"),0,0,Juego.w,Juego.h);
		
		planeta=new TextureRegion((Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/planeta.png"),0,0,Juego.w,Juego.h);
		   
		
		meteoritobarra=new TextureRegion((Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/meteorito.png"),0,0,128,128);
	
		estrellabarra=new TextureRegion((Texture)Juego.carga.Assets.get("Images/"+Juego.w+"x"+Juego.h+"/estrella.png"),0,0,64,64);
		
		
	        posicionNave.x=logica.extrate.NuevaPosiscion();
	        
		if(Juego.sound){
			((Sound)Juego.carga.Assets.get("Sound/star.ogg")).play(0.3f);	
			((Sound)Juego.carga.Assets.get("Sound/nave.ogg")).loop(0.2f);	
		}

	}

	public void hide()
	{
		stage.clear();
		logica.clear();
	}


	public void pause() {
		
	
		if(pause==false)
		{
			pause=true;
			
	
			   
			   if(Juego.Pantallaplay.pause)
			   {
				   logica.botonMenu.setY(logica.pause.getY()-100);
				   logica.addActor(logica.botonMenu);
			   }
			
		}
		else if(pause){
			
			logica.removeActor(logica.botonMenu);
			pause=false;
			logica.pause.setWidth(35);
			logica.pause.setHeight(40);
			logica.pause.setX(Juego.w/2-(logica.pause.getWidth()/2));
			logica.pause.setY(Juego.h-logica.pause.getHeight());	
		}
		
	}


	public void resume() {

		
	}


	public void dispose() {

logica.clear();
pause=false;
stage.clear();
	}

	
	public void spawn(){
		
	   	 
		if(pause==false){
	     if(logica.extrate.getX()==posicionNave.x)
	     {
	    	 Meteorito rec = new Meteorito(Juego);
	    	 rec.rect.x=logica.extrate.getX();
	    	 meteoritos.add(rec); 	 
	    	 posicionNave.x=logica.extrate.NuevaPosiscion();
	     }
	   
		}
	} 
	
	
	public void dispararMisil()
	{
		  Misil m=new Misil(Juego,logica.nave);
		  
		  int direccion=0;
		  
   	   if(logica.nave.velocidad.x==1){direccion=10;}
   	   else 
   	   if(logica.nave.velocidad.x==-1){direccion=-10;}
		  m.rect.x+=direccion;
		  misiles.add(m);
		  
		  
		  ((Sound)Juego.carga.Assets.get("Sound/disparo.ogg")).play();
		  
		  if(Juego.nivel>=3)
		  {
			  Misil m2=new Misil(Juego,logica.nave);
			  m2.rect.x+=30;
			  misiles.add(m2);  
		  }
	}
	

	
	
	
	public void iterator()
	{
	       Iterator<Meteorito> iter = meteoritos.iterator();
	       Meteorito mete=null; 
	       while(iter.hasNext()){
	    	   mete = iter.next();
	
                mete.stateTime+= Gdx.graphics.getDeltaTime(); 
	    	   mete.currentFrame = mete.mover.getKeyFrame(mete.stateTime,true);
	    	   
	            batch.draw(mete.currentFrame,mete.rect.x-7,mete.rect.y-3,mete.getOriginX(),mete.getOriginY(),mete.getWidth(),mete.getHeight(),mete.getScaleX(),mete.getScaleY(),mete.getRotation()); 
	    	    mete.modoBug();
	            
	    	    if(pause==false){mete.rect.y-=rapidezmete;}
	            
	            if(mete.rect.y<0)
	            {
	            	if(Juego.nivel<3){
	            	Ubiexplocion.x=mete.rect.x;
	            	Ubiexplocion.y=0;
	            	
	            	 ((Sound)Juego.carga.Assets.get("Sound/explosion.ogg")).play(0.3f);
	            	explotarNuclear();
	            	iter.remove();
	            	}else
	            	{
	            		iter.remove();
	            	}
	            	
	            	
	            }else{
	            
	            
	            		
	            if(mete.rect.overlaps(logica.nave.punta1) || mete.rect.overlaps(logica.nave.punta2) || mete.rect.overlaps(logica.nave.punta3) ){     
	                  iter.remove();     
	                    
	            	logica.nave.exploto();
	                    logica.nave.choque=true;
	                    
	                    Juego.vida--;
	                    
	                    ((Sound)Juego.carga.Assets.get("Sound/explosion.ogg")).play(0.3f);
	                    
	                    if(Juego.vida<=0)
	                    {
	                    	fin=true;
	                    	Juego.nivel=1;
	                    	
	                    	if(Juego.recor<Juego.puntage){Juego.recor=Juego.puntage;}
	                    	Juego.puntage=0;
	                    	rapidezmete=1;
	                    }
	            }
	            
	            
	            
	            }
	            }
	}
	
	
	
	
	public void iteratorExplociones()
	{
		  Iterator<Explocion> iter = explociones.iterator();
	       Explocion ex=null; 
	       while(iter.hasNext())
	       {
	    	   ex = iter.next();
		 	   ex.draw(batch);
				if(ex.stateTime>=1)
				{
					iter.remove();
				}
			         
	    	   }
	}
	

	
	public void iteratorExplocionesNucleares()
	{
		  Iterator<ExplocionNuclear> iter = explocionesNucleares.iterator();
	       ExplocionNuclear ex=null; 
	       while(iter.hasNext())
	       {
	    	   ex = iter.next();
		 	   ex.draw(batch);
				if(ex.stateTime>=3)
				{
					iter.remove();
				}
			         
	    	   }
	}
	
	
	
	public void iteratorEstrellas()
	{
		
		  Iterator<Estrella> iter = estrellas.iterator();
	       Estrella es=null; 
	       while(iter.hasNext())
	       {
	    	   es = iter.next();
	    	if(pause==false){es.setY(es.getY()-mundos.recorido);}
	    	   
	    	   es.draw(batch);
	    
	    	if( (es.rectangulo.overlaps(logica.nave.punta1)) || (es.rectangulo.overlaps(logica.nave.punta2)) || (es.rectangulo.overlaps(logica.nave.punta3)))
	    	{
	    		((Sound)Juego.carga.Assets.get("Sound/punto.ogg")).play(0.3f);
	    		numeroEstrellas++;
	    		if(numeroEstrellas>=50){numeroEstrellas=0;Juego.vida++;}
	    		iter.remove();
	    	}
              
	    	
 
	    	   }

	}
	
	
	
	
	public void iteratormisiles()
	{
	       Iterator<Misil> iter = misiles.iterator();
	       Misil m=null; 
	       while(iter.hasNext()){
	    	   
	    	   m = iter.next();
	    	   m.stateTime+= Gdx.graphics.getDeltaTime(); 
	    	   m.currentFrame = m.volar.getKeyFrame(m.stateTime,true);
	  
	    	   
	            batch.draw(m.currentFrame,m.rect.x,m.rect.y); 
	      
	            if(pause==false){m.rect.y+=2;}
	            
	            if(m.rect.y>Juego.h+m.currentFrame.getRegionHeight())
	            {
	            	iter.remove();
	            }
	            else
	            {
	            	  Iterator<Meteorito> itermeteoritos = meteoritos.iterator();
	       	       Meteorito meteorito=null; 
	       	       while(itermeteoritos.hasNext()){
	       	    	   meteorito = itermeteoritos.next();
	       	    	   
	       	    	   if(m.rect.overlaps(meteorito.rect))
	       	    	   {
	       	    		((Sound)Juego.carga.Assets.get("Sound/explosion.ogg")).play(0.3f);
	       	    		   
	       	    		
	       	  	   Ubiexplocion.x=m.rect.x;
   	    		   Ubiexplocion.y=m.rect.y;
   	    		 
   	    		   explotar();
	       	    		 
   	    		   itermeteoritos.remove();
	       	       iter.remove();  

	       	    		   Juego.puntage++;
	       	    		   
	       	    		if(Juego.puntage>=50 && Juego.nivel==1){Juego.nivel++;mundos=new Mundos(Juego);}
	       	    		if(Juego.puntage>=100 && Juego.nivel==2)
	       	    		{
	       	    			Juego.nivel++;

	       	    			mundos=new Mundos(Juego); 	    		
	       	    		}
	       	    		
	       	    		if(Juego.puntage>=150 && Juego.nivel==3){Juego.nivel++;mundos=new Mundos(Juego);rapidezmete=2;}
	       	    		if(Juego.puntage>=200 && Juego.nivel==4){Juego.nivel++;mundos=new Mundos(Juego);rapidezmete=3; mundos.recorido=1f;}
	       	    		if(Juego.puntage>=250 && Juego.nivel==5){Juego.nivel++;mundos=new Mundos(Juego);rapidezmete=4;mundos.recorido=2f;}
	       	    		
	       	    		break;
	       	    	   }
	       	       } 		
	            }
	            
	            }
	}
	
	
	
	
	
	public void pintarPuntage(Array<TextureRegion> texturas)
	{
	
	int ancho=0;
	for(int i=0;i<texturas.size;i++){
		
			batch.draw(texturas.get(i),ancho,(Juego.h-35),20,32);
			ancho +=texturas.get(i).getRegionWidth()-12;
	}
	
	
	batch.draw(meteoritobarra,ancho,Juego.h-35,20,32);
		
	}
	
	public void pintarPuntageestrellas(Array<TextureRegion> texturas)
	{
	
	int ancho=0;
	for(int i=0;i<texturas.size;i++)
	{	
			batch.draw(texturas.get(i),ancho,0,20,25);
			ancho +=20;
	}
	
	batch.draw(estrellabarra,ancho,0,20,25);
	
	}
	
	
	
	public void NuevaEstrella()
	{
		Estrella es=new Estrella(Juego);
		estrellas.add(es);
	}
	
	
	
	public void explotarNuclear()
	{
       // Ubiexplocion.x+=-40;
      //  Ubiexplocion.y+=+20;
		ExplocionNuclear ex=new ExplocionNuclear(Juego,Ubiexplocion);
        explocionesNucleares.add(ex);       
	}
	
	
	public void explotar()
	{
        Ubiexplocion.x+=-40;
        Ubiexplocion.y+=+20;
		Explocion ex=new Explocion(Juego,Ubiexplocion);
        explociones.add(ex);       
	}
	
}
