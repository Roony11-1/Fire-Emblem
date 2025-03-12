package modelo.clase;

import javax.swing.ImageIcon;
import modelo.Estadisticas;
import modelo.Clase;
import modelo.arma.ArmaFactory;

public class Espadachin extends Clase
{

    public Espadachin() 
    {
        Estadisticas estEspadachin = new Estadisticas(21, 6, 11, 10, 0, 5, 2, 7, 6);
        Estadisticas estEspMaximas = new Estadisticas(60, 25, 30, 26, 30, 25, 22, 15, 25);
        
        this.setNombre("Espadachin");
        this.setDescripcion("Alta evasión y porcentaje de evitar golpes");
        this.setEstadisticas(estEspadachin);
        
        this.setSprite(new ImageIcon(getClass().getResource("/resourses/imagenes/espadachin.png")).getImage());
        
        this.setPromocionada(true);
        
        this.setArmasPermitidas(ArmaFactory.SOLO_ESPADA);
        
        this.setEstadisticasMaximas(estEspMaximas);
    }
}