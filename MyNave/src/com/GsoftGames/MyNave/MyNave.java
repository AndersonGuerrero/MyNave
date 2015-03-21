package com.GsoftGames.MyNave;

import menuprincipal.PantallaMenuPrincipal;
import play.PantallaPlay;
import presentacion.PantallaDePresentacion;
import carga.Cargador;
import carga.PantallaDeCarga;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class MyNave extends Game {
	
	public int w,h;
	public boolean sound;
	public Configuraciones config;
	public Cargador carga; 
	public int nivel;
	public int tipo;
	public int puntage;
	public int vida;
	public int  recor;
	PantallaDeCarga pantallaCarga;
	public PantallaMenuPrincipal menuPrincipal;
	public PantallaDePresentacion pantallaPresentacion;
	public PantallaPlay Pantallaplay;
	public void create() {	
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
	   
	   if(Gdx.app.getClass().getSimpleName().equals("LwjglApplication")){tipo=0;}else{tipo=1;}

		config=new Configuraciones(this);
		carga=new Cargador(w,h);
		
		pantallaPresentacion=new PantallaDePresentacion(this);
		menuPrincipal=new PantallaMenuPrincipal(this);
		
		pantallaCarga=new PantallaDeCarga(this);
		
		Pantallaplay=new PantallaPlay(this);
		
		sound=config.getsonido();
		recor=config.getrecor();
		puntage=config.getpuntage();
		nivel=config.getnivel();
		vida=config.getvida();
		if(vida==0){vida=3;}
		if(nivel==0){nivel=1;}
		
		this.setScreen(pantallaCarga);
	}

	
	public void dispose()
	{
		config.setsonido(sound);
		config.setpuntage(puntage);
		config.setnivel(nivel);
		config.setrecor(recor);
		config.setvida(vida);
           Gdx.app.exit();
	}
}
