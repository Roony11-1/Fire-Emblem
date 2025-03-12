package modelo.clase;

import modelo.Clase;
import java.util.HashMap;
import java.util.Map;

public class ClaseFactory 
{
    private static final Map<String, Class<? extends Clase>> clasesRegistradas = new HashMap<>();
    private static final Map<String, String> promociones = new HashMap<>();

    // Bloque estático: Registro inicial de clases
    static 
    {
        // Clases Básicas
        registrarClase("Mirmidon", Mirmidon.class, "Espadachin");
        registrarClase("Luchador", Luchador.class, "Campeon");
        
        // Clases Promocionadas
        registrarClase("Campeon", Campeon.class);
        registrarClase("Espadachin", Espadachin.class);
    }

    // Registrar una clase con o sin promoción
    public static void registrarClase(String nombreClase, Class<? extends Clase> clase, String promocion) 
    {
        clasesRegistradas.put(nombreClase, clase);
        if (promocion != null)
            promociones.put(nombreClase, promocion);
    }

    // Registrar clase en tiempo de ejecucion
    public static void registrarClase(String nombreClase, Class<? extends Clase> clase) 
    {
        registrarClase(nombreClase, clase, null);
    }

    // Obtener una clase por nombre
    public static Class<? extends Clase> obtenerClase(String nombreClase) 
    {
        return clasesRegistradas.get(nombreClase);
    }

    // Obtener el nombre de la promoción asociada
    public static String obtenerPromocion(String nombreClase) 
    {
        return promociones.get(nombreClase);
    }

    // Crear una instancia de una clase
    public static Clase crearClase(String nombreClase) 
    {
        Class<? extends Clase> clase = clasesRegistradas.get(nombreClase);
        if (clase == null)
            throw new IllegalArgumentException("Clase no reconocida: " + nombreClase);

        try 
        {
            return clase.getDeclaredConstructor().newInstance();
        } 
        catch (Exception e) 
        {
            throw new RuntimeException("Error al instanciar la clase: " + nombreClase, e);
        }
    }

    // Obtener todas las clases registradas
    public static Map<String, Class<? extends Clase>> obtenerClasesRegistradas() 
    {
        return new HashMap<>(clasesRegistradas);
    }
}
