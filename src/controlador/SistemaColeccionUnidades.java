package controlador;

import modelo.Unidad;
import modelo.Clase;
import modelo.clase.ClaseFactory;
import modelo.Crecimiento;
import modelo.Estadisticas;

import java.util.ArrayList;
import java.util.List;

public class SistemaColeccionUnidades 
{
    private List<Unidad> unidades;

    public SistemaColeccionUnidades() 
    {
        this.unidades = new ArrayList<>();
    }

    // Verificar si la colección está vacía
    public boolean isEmpty() 
    {
        return this.unidades.isEmpty();
    }

    // Obtener y establecer unidades
    public ArrayList<Unidad> getUnidades() 
    {
        return (ArrayList<Unidad>) unidades;
    }

    public void setUnidades(List<Unidad> unidades) 
    {
        this.unidades = unidades;
    }

    // Agregar una unidad
    public boolean agregarUnidad(Unidad unidad) 
    {
        if (unidad == null) 
        {
            System.err.println("La unidad proporcionada es nula. No se puede agregar.");
            return false;
        }
        try 
        {
            unidades.add(unidad);
            return true;
        } 
        catch (Exception e) 
        {
            System.err.println("Error al agregar la unidad: " + e.getMessage());
            return false;
        }
    }

    // Listar unidades por clase
    public List<Unidad> listarUnidadesPorClase(String nombreClase) 
    {
        List<Unidad> lista = new ArrayList<>();
        Class<? extends Clase> claseObj = ClaseFactory.obtenerClase(nombreClase);

        if (claseObj == null) 
        {
            System.err.println("Clase no reconocida: " + nombreClase);
            return lista; // Devuelve lista vacía si no se encuentra la clase
        }

        for (Unidad unidad : unidades) 
        {
            if (claseObj.isAssignableFrom(unidad.getClase().getClass()))
                lista.add(unidad);
        }

        return lista;
    }

    // Promocionar una unidad
    public boolean promocionarUnidad(Unidad unidad) 
    {
        if (unidad == null || unidad.getClase() == null) 
        {
            System.err.println("La unidad o su clase es nula. No se puede promocionar.");
            return false;
        }
        
        if (unidad.getClase().isPromocionada())
        {
            System.err.println("La unidad ya esta promocionada");
            return false;
        }

        String nombreClaseActual = obtenerNombreClase(unidad);
        if (nombreClaseActual == null) 
        {
            System.err.println("La clase actual de la unidad no está registrada.");
            return false;
        }

        String nombreClasePromocionada = ClaseFactory.obtenerPromocion(nombreClaseActual);
        if (nombreClasePromocionada == null) 
        {
            System.err.println("No hay promoción definida para la clase: " + nombreClaseActual);
            return false;
        }
        
        int nivel = unidad.getClase().getNivel().getNivel();
        if (nivel != 20)
        {
            System.err.println("La unidad debe ser nivel 20 para poder promocionar, nivel: " + nivel);
            return false;
        }

        try {
            Clase nuevaClase = ClaseFactory.crearClase(nombreClasePromocionada);
            Estadisticas estAntiguas = unidad.getClase().getEstadisticas();
            Crecimiento creAntiguo = unidad.getClase().getCrecimiento();
            
            System.out.println(unidad.getNombre()+" a promocionado de: "+unidad.getClase().getNombre()+" a "+nuevaClase.getNombre());
            
            unidad.setClase(nuevaClase);
            
            unidad.getClase().setEstadisticas(estAntiguas);
            unidad.getClase().setCrecimiento(creAntiguo);
            
            unidad.getClase().getNivel().setNivel(0);
            
            unidad.getClase().subirNivel(unidad.getNombre());
                    
            return true;
        } 
        catch (Exception e) 
        {
            System.err.println("Error al promocionar la unidad: " + e.getMessage());
            return false;
        }
    }

    // Obtener el nombre de la clase actual de una unidad
    private String obtenerNombreClase(Unidad unidad) 
    {
        for (String nombreClase : ClaseFactory.obtenerClasesRegistradas().keySet()) 
        {
            Class<? extends Clase> clase = ClaseFactory.obtenerClase(nombreClase);
            if (clase != null && clase.isAssignableFrom(unidad.getClase().getClass()))
                return nombreClase;
        }
        return null;
    }
    
    public void subirNivelUnidad(Unidad unidad, int cantNivel)
    { 
        String nombre = unidad.getNombre();
        
        if (cantNivel == 0)
            return;
        
        for (int i = 1; i <= cantNivel; i++) 
        {
            unidad.getClase().subirNivel(nombre);
        }
    }
}
