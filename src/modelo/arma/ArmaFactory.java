package modelo.arma;

import modelo.Arma;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArmaFactory 
{
    private static final Map<String, Class<? extends Arma>> armasRegistradas = new HashMap<>();
    
    // Definir las combinaciones de armas reutilizables
    public static final ArrayList<String> SOLO_ESPADA = new ArrayList<>(List.of("Espada"));
    public static final ArrayList<String> SOLO_HACHA = new ArrayList<>(List.of("Hacha"));
    public static final ArrayList<String> SOLO_LANZA = new ArrayList<>(List.of("Lanza"));
    public static final ArrayList<String> SOLO_ARCO = new ArrayList<>(List.of("Arco"));
    public static final ArrayList<String> ESPADA_Y_HACHA = new ArrayList<>(List.of("Espada", "Hacha"));
    public static final ArrayList<String> ESPADA_Y_LANZA = new ArrayList<>(List.of("Espada", "Lanza"));
    public static final ArrayList<String> ESPADA_HACHA_Y_LANZA = new ArrayList<>(List.of("Espada", "Hacha", "Lanza"));
    
    static
    {
        // Registro de armas
        registrarArma("Espada", Espada.class);
        registrarArma("Hacha", Hacha.class);
        registrarArma("Lanza", Lanza.class);
        registrarArma("Arco", Arco.class);
    }
    
    public static void registrarArma(String nombreArma, Class<? extends Arma> arma) 
    {
        armasRegistradas.put(nombreArma, arma);
    }
    
    // Crear una instancia de una clase
    public static Arma crearArma(String nombreArma) 
    {
        Class<? extends Arma> arma = armasRegistradas.get(nombreArma);
        if (arma == null)
            throw new IllegalArgumentException("Arma no reconocida: " + nombreArma);

        try 
        {
            return arma.getDeclaredConstructor().newInstance();
        } 
        catch (Exception e) 
        {
            throw new RuntimeException("Error al instanciar el arma: " + nombreArma, e);
        }
    }
    
    // Obtener una clase por nombre
    public static Class<? extends Arma> obtenerArma(String nombreArma) 
    {
        return armasRegistradas.get(nombreArma);
    }
}
