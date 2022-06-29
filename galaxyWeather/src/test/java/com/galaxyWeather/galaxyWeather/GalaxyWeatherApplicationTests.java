package com.galaxyWeather.galaxyWeather;

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
public class GalaxyWeatherApplicationTests {
	 
	@Autowired
    private PronosticoRepository pronosticoRepository;
	
	@Test
	public void testPronostico() throws Exception{
		Planeta ferengi = new Planeta("Ferengi", 500, 1, 1);
		Planeta betasoide = new Planeta("Betasoide", 2000, 3, 1);
		Planeta vulcano = new Planeta("Vulcano", 1000, 5, -1);

        GalaxyMlServiceImpl service = new GalaxyMlServiceImpl();
        service.init(ferengi, betasoide, vulcano, pronosticoRepository);

        Pronostico pronosticoSequia = service.getPronostico(0);
        Pronostico pronosticoLluvia = service.getPronostico(70);
        Pronostico pronosticoSoleado = service.getPronostico(60);
        
        assertEquals("sequia", pronosticoSequia.getClima());
        assertEquals("lluvia", pronosticoLluvia.getClima());
        assertEquals("soleado", pronosticoSoleado.getClima());
	}
	
	@Test
	public void unAnioTiene360Dias() throws Exception{
		Planeta ferengi = new Planeta("Ferengi", 500, 1, 1);
		Planeta betasoide = new Planeta("Betasoide", 2000, 3, 1);
		Planeta vulcano = new Planeta("Vulcano", 1000, 5, -1);

        GalaxyMlServiceImpl service = new GalaxyMlServiceImpl();
        service.init(ferengi, betasoide, vulcano, pronosticoRepository);
        
        assertEquals("sequia", service.getPronostico(0).getClima());
        assertEquals("sequia", service.getPronostico(360).getClima());
        assertEquals("sequia", service.getPronostico(720).getClima());
        assertEquals("sequia", service.getPronostico(1080).getClima());
	}
}
