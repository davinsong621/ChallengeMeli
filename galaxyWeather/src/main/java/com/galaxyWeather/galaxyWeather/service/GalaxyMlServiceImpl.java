package com.galaxyWeather.galaxyWeather.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxyWeather.galaxyWeather.model.*;
import com.galaxyWeather.galaxyWeather.repository.PronosticoRepository;

@Service("galaxyMlService")
public class GalaxyMlServiceImpl implements GalaxyMlService {
	
	@Autowired
	PronosticoRepository pronosticoRepository; 
	
    private final int duracionAnio = 360; //en 360 dias la posicion de los planetas vuelve a su estado inicial
    private Planeta planeta1;
    private Planeta planeta2;
    private Planeta planeta3;
    
	/**
	 * @param Planeta, Planeta, Planeta
	 * @return
	 * almacena el pronostico del primer año en la base
	 * de datos teniendo en cuenta que este es lineal
	 */
    public void init(Planeta planeta1, Planeta planeta2, Planeta planeta3, PronosticoRepository pronosticoRepository) {
    	this.pronosticoRepository=pronosticoRepository;
    	this.planeta1=planeta1;
    	this.planeta2=planeta2;
    	this.planeta3=planeta3;
    	
	    pronosticoRepository.deleteAll();
	    
        for(int i = 0; i < duracionAnio; i++) {
        	pronosticoRepository.save(getPronostico(i));
        }
        calcularTormentas();
    }
    
	/**
	 * @param 
	 * @return
	 * calcula la cantidad de dias que se repite el maximo perimetro
	 * de los pronosticos almacenados
	 */
	public void calcularTormentas() {
		Pronostico pronosticoMaximoPerimetro = pronosticoRepository.findFirstByOrderByPerimetroDesc();
		double perimetroMaximo = pronosticoMaximoPerimetro.getPerimetro();
		List<Pronostico> pronosticosDeTormenta = pronosticoRepository.findByPerimetro(perimetroMaximo);
		for(int i = 0; i < pronosticosDeTormenta.size(); i++) {
			Pronostico pronostico = pronosticosDeTormenta.get(i);
			pronostico.setClima("tormenta");
			pronosticoRepository.save(pronostico);
		}
	}
	
	/**
	 * @param cantidad de años
	 * @return Pronostico del dia ingresado
	 * calcula la condicion climatica de un dia en particular
	 */
	public Pronostico getPronostico(int dia) {				
			Triangulo triangulo = new Triangulo(planeta1.getPosicion(dia), planeta2.getPosicion(dia),
						planeta3.getPosicion(dia));
			Punto posicionDelSol = new Punto(0, 0);
			
			if(triangulo.contieneUnPunto(planeta3.getPosicion(dia)) && triangulo.area() == 0) { //es una linea
				if(triangulo.contieneUnPunto(posicionDelSol)) {
					return new Pronostico(dia, "sequia", triangulo.perimetro());
				}
				return new Pronostico(dia, "optimo", triangulo.perimetro());
			}else if (triangulo.contieneUnPunto(posicionDelSol)) {
					return new Pronostico(dia, "lluvia", triangulo.perimetro());
			} else {
				return new Pronostico(dia, "soleado", triangulo.perimetro());
			}
	}


}