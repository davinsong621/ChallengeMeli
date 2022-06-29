package com.galaxyWeather.galaxyWeather.service;

import com.galaxyWeather.galaxyWeather.model.*;
import com.galaxyWeather.galaxyWeather.repository.PronosticoRepository;

public interface GalaxyMlService {
	
	Pronostico getPronostico(int dia);
	
	void calcularTormentas();
	
	void init(Planeta planeta1, Planeta planeta2, Planeta planeta3, PronosticoRepository pronosticoRepository);

}