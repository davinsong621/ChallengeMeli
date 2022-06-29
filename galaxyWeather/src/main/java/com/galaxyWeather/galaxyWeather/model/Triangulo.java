package com.galaxyWeather.galaxyWeather.model;

public class Triangulo {

	private Punto punto1;
	private Punto punto2;
	private Punto punto3;

	public Triangulo(Punto punto1, Punto punto2, Punto punto3) {
		super();
		this.punto1 = punto1;
		this.punto2 = punto2;
		this.punto3 = punto3;
	}
	
	/*
	 * @return float 
	 * calcula el area del triangulo
	 */
	public float area() {
		return Math.abs((float)( punto1.getX() * (punto2.getY() - punto3.getY()) + punto2.getX() * (punto3.getY() - punto1.getY()) + punto3.getX() * (punto1.getY() - punto2.getY()))/2);
	}
	
	/*
	 * @param Punto
	 * @return boolean
	 * dado un punto devuelve true si dicho punto esta contenido en el triangulo
	 */
	public boolean contieneUnPunto(Punto punto) {
		Triangulo tr1 = new Triangulo(punto, punto2, punto3);
		Triangulo tr2 = new Triangulo(punto1, punto, punto3);
		Triangulo tr3 = new Triangulo(punto1, punto2, punto);
		
		return tr1.area() + tr2.area() + tr3.area() == this.area();
		
	}
	
	/*
	 * @return double
	 * calcula el perimetro del triangulo
	 */
	public double perimetro (){
		double xy = this.punto1.distancia(punto2);
		double yz = this.punto2.distancia(punto3);
		double xz = this.punto3.distancia(punto1);
	
		return xy + yz + xz;
	}
}
