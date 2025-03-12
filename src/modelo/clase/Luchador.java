package modelo.clase;

import modelo.Estadisticas;
import modelo.Clase;
import modelo.arma.ArmaFactory;

public class Luchador extends Clase
{

    public Luchador() 
    {
        Estadisticas estLuchador = new Estadisticas(20, 5, 2, 4, 0, 2, 0, 11, 5);
        
        this.setNombre("Luchador");
        this.setDescripcion("Muy fuerte pero baja defensa");
        this.setEstadisticas(estLuchador);
        
        this.setArmasPermitidas(ArmaFactory.SOLO_HACHA);
    }
}
