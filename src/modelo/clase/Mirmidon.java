package modelo.clase;

import javax.swing.ImageIcon;
import modelo.Estadisticas;
import modelo.Clase;
import modelo.arma.ArmaFactory;

public class Mirmidon extends Clase
{

    public Mirmidon() 
    {
        Estadisticas estMirmidon = new Estadisticas(16, 4, 9, 10, 0, 2, 1, 5, 5);
        
        this.setNombre("Mirmidon");
        this.setDescripcion("Espadachines con mucho potencial");
        this.setEstadisticas(estMirmidon);
        
        this.setSprite(new ImageIcon(getClass().getResource("/resourses/imagenes/mirmidon.png")).getImage());
        
        this.setArmasPermitidas(ArmaFactory.SOLO_ESPADA);
    }
}
