package com.galaxyWeather.galaxyWeather.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.galaxyWeather.galaxyWeather.model.Planeta;
import com.galaxyWeather.galaxyWeather.model.Pronostico;
import com.galaxyWeather.galaxyWeather.service.GalaxyMlServiceImpl;
import com.galaxyWeather.galaxyWeather.repository.PronosticoRepository;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PuntoTests {
	 
	@Autowired
    private PronosticoRepository pronosticoRepository;
    
	
	@Test
	public void distanciaAunPuntoTest() throws Exception{
		Triangulo triangulo = new Triangulo(new Punto(0,0), new Punto(0,3), new Punto(4,0));
		double areaEsperada = 6;
		assertEquals(areaEsperada,(double)triangulo.area(), 0);
	}

}
