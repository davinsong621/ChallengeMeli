package com.galaxyWeather.galaxyWeather.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

public class Planeta {

	private Long id;
	private String nombre;
	private float distancia;
	private int velocidadAngularPorDia;
	private int sentido;
	
	public Planeta(String nombre, float distancia, int velocidadAngularPorDia,
			int sentido) {
		this.nombre = nombre;
		this.distancia = distancia;
		this.velocidadAngularPorDia = velocidadAngularPorDia;
		this.sentido = sentido;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public float getDistancia() {
		return distancia;
	}
	
	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}
	
	public int getVelocidadAngularPorDia() {
		return velocidadAngularPorDia;
	}
	
	public void setVelocidadAngularPorDia(int velocidadAngularPorDia) {
		this.velocidadAngularPorDia = velocidadAngularPorDia;
	}
	
	public int getSentido() {
		return sentido;
	}

	public void setSentido(int sentido) {
		this.sentido = sentido;
	}

	public Punto getPosicion(int dia) {
		double posicionEnGrados = (dia * this.velocidadAngularPorDia * sentido) % 360;
		double posicionEnRad = Math.toRadians(posicionEnGrados);
		
		double x = Math.cos(posicionEnRad) * this.distancia;
		double y = Math.sin(posicionEnRad) * this.distancia;

		return new Punto(x, y);

	}
	
}
