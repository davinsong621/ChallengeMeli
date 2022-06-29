package com.galaxyWeather.galaxyWeather.repository;

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

import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PronosticoRepositoryTests {
	 
	@Autowired
    private PronosticoRepository pronosticoRepository;
    	
	@Test
	public void findByDiaTest() throws Exception{
		Pronostico pronostico = pronosticoRepository.findByDia(0);
        assertEquals("sequia", pronostico.getClima());
	}

	@Test
	public void findByClimaTest() throws Exception{
		List<Pronostico> diasDeSequia = pronosticoRepository.findByClima("sequia");
        assertEquals("sequia", diasDeSequia.get(0).getClima());
        assertEquals(0, diasDeSequia.get(0).getDia());
	}

	@Test
	public void findFirstByOrderByPerimetroDescTest() throws Exception{
		Pronostico pronosticoTormenta = pronosticoRepository.findFirstByOrderByPerimetroDesc();
        assertEquals("tormenta", pronosticoTormenta.getClima());
	}
	
	@Test
	public void findByDiaLessThanAndClimaTest() throws Exception{
		List<Pronostico> pronosticos = pronosticoRepository.findByDiaLessThanAndClima(5, "soleado");
        assertEquals("soleado", pronosticos.get(0).getClima());
        assertTrue(pronosticos.get(pronosticos.size()-1).getDia() <= 5);
	}
	
	@Test
	public void findByPerimetroTest() throws Exception{
		Pronostico pronosticoTormenta = pronosticoRepository.findFirstByOrderByPerimetroDesc();
		List<Pronostico> pronosticos = pronosticoRepository.findByPerimetro(pronosticoTormenta.getPerimetro());
        assertTrue(pronosticos.size() == 4); //en 4 puntos el perimetro entre los planetas se encuentra en su máximo
	}
	
	@Test
	public void findAllTest() throws Exception{
		List<Pronostico> pronosticos = pronosticoRepository.findAll();
        assertTrue(pronosticos.size() == 360); 
	}
	
}
