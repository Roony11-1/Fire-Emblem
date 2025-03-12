package modelo.clase;

import modelo.Estadisticas;
import modelo.Clase;
import modelo.arma.ArmaFactory;

public class Campeon extends Clase
{
    public Campeon() 
    {
        Estadisticas estCampeon = new Estadisticas(22, 6, 9, 10, 0, 8, 2, 15, 6);
        Estadisticas estCamMaximas = new Estadisticas(60, 25, 30, 26, 30, 30, 25, 15, 25);
        
        this.setNombre("Campeón");
        this.setDescripcion("Sin una gran debilidad");
        this.setEstadisticas(estCampeon);
        
        this.setPromocionada(true);
        
        this.setArmasPermitidas(ArmaFactory.ESPADA_Y_HACHA);
        
        this.setEstadisticasMaximas(estCamMaximas);
    }
}