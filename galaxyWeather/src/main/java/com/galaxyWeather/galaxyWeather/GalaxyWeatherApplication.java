package com.galaxyWeather.galaxyWeather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.galaxyWeather.galaxyWeather.service.GalaxyMlServiceImpl;
import com.galaxyWeather.galaxyWeather.model.*;
import com.galaxyWeather.galaxyWeather.repository.*;

@SpringBootApplication
public class GalaxyWeatherApplication {

	private static final Logger logger = LoggerFactory.getLogger(GalaxyWeatherApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GalaxyWeatherApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner setup(PronosticoRepository pronosticoRepository) {
		return (args) -> {
			int sentidoHorario = 1;
			int sentidoAntiHorario = -1;
			
			Planeta ferengi = new Planeta("Ferengi", 500, 1, sentidoHorario);
			Planeta betasoide = new Planeta("Betasoide", 2000, 3, sentidoHorario);
			Planeta vulcano = new Planeta("Vulcano", 1000, 5, sentidoAntiHorario);
			
			GalaxyMlServiceImpl galaxyService = new GalaxyMlServiceImpl();
			galaxyService.init(ferengi, betasoide, vulcano, pronosticoRepository);
			
			logger.info("Data loaded succesfully");
		};
	}

}
