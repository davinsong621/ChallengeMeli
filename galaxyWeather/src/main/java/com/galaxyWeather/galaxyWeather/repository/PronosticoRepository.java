package com.galaxyWeather.galaxyWeather.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.galaxyWeather.galaxyWeather.model.Pronostico;

@Repository("pronosticoRepository")
public interface PronosticoRepository extends PagingAndSortingRepository<Pronostico, Long> {

    /**
     * 
     * @param dia
     * @return Devuelve el pronostico de un día en particular
     */
    public Pronostico findByDia(int dia);
    
    /**
     * @param clima
     * @return Devuelve una lista con todos los pronosticos del clima ingresado
     */
    public List<Pronostico> findByClima(String clima);
    
    /**
    * 
    * @return devuelve el pronostico que tenga mayor perimetro
    */
   public Pronostico findFirstByOrderByPerimetroDesc();

   /**
   *
   * @param dia
   * @param clima
   * @return Devuelve una lista con los pronosticos de ese 
   * clima en la que el dia sea menor al ingresado
   */
  public List<Pronostico> findByDiaLessThanAndClima(int dia, String clima);
  
   /**
    *
    * @param perimetro
    * @return devuelve una lista con las predicciones que tienen exactamente el mismo perimetro
    */
   public List<Pronostico> findByPerimetro(double perimetro);
	

   /**
    *
    * @return devuelve la lista de pronosticos completa
    */
   public List<Pronostico> findAll();
}