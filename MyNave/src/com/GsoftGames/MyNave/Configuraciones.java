package com.GsoftGames.MyNave;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Configuraciones {

	private Preferences preferenicias;
	MyNave Juego;
	
	public Configuraciones(MyNave juego)
	{
		Juego=juego;
		preferenicias=Gdx.app.getPreferences("com.GsofGames.MyNave");
	}
	
	
	
	
	public void setsonido(boolean sonido)
	{
		preferenicias.putBoolean("sonido", sonido);
		preferenicias.flush();
	}
	
	public boolean getsonido()
	{
		boolean sonido=preferenicias.getBoolean("sonido");
		return sonido;
	}
	
	
	public void setnivel(int niviel)
	{
		preferenicias.putInteger("nivel",niviel);
		preferenicias.flush();
	}
	
	
	
	public int getnivel()
	{
		int temp=preferenicias.getInteger("nivel");
		
		return temp;
	}
	
	
	public void setpuntage(int puntage)
	{
		preferenicias.putInteger("puntage",puntage);
		preferenicias.flush();
	}
	
	
	public int getpuntage()
	{
		int temp=preferenicias.getInteger("puntage");
		return temp;
	}
	
	
	public void setrecor(int recor)
	{
		preferenicias.putInteger("recor",recor);
		preferenicias.flush();
	}
	
	
	public int getrecor()
	{
		int temp=preferenicias.getInteger("recor");
		return temp;
	}
	
	
	public void setvida(int vida)
	{
		preferenicias.putInteger("vida",vida);
		preferenicias.flush();
	}
	
	
	public int getvida()
	{
		int temp=preferenicias.getInteger("vida");
		return temp;
	}
	
	
}
