package com.galaxyWeather.galaxyWeather.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Periodo {

	private String clima;
	private int cantidadDeDias;
	
	public Periodo() {}
	
	public Periodo(int cantidadDeDias, String clima) {
		super();
		this.cantidadDeDias = cantidadDeDias;
		this.clima = clima;
	}
	
	public int getCantidadDeDias() {
		return cantidadDeDias;
	}

	public void setCantidadDeDias(int cantidadDeDias) {
		this.cantidadDeDias = cantidadDeDias;
	}

	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}

	@Override
	public String toString() {
		return "Periodo [clima=" + clima + ", cantidadDeDias=" + cantidadDeDias + "]";
	}
	
}
