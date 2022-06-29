package com.galaxyWeather.galaxyWeather.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DiscriminatorValue("pronostico")
@JsonIgnoreProperties("perimetro")
public class Pronostico {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
	private String clima;
	private int dia;
	private double perimetro;
	
	public Pronostico() {}
	
	public Pronostico(int dia, String clima, double perimetro) {
		super();
		this.dia = dia;
		this.clima = clima;
		this.perimetro = perimetro;
	}

	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}

	public double getPerimetro() {
		return perimetro;
	}

	public void setPerimetro(double perimetro) {
		this.perimetro = perimetro;
	}

	@Override
	public String toString() {
		return "Pronostico [clima=" + clima + ", dia=" + dia + "]";
	}
	
}
