package modelo;

import java.util.HashMap;

public class MapaUnidades 
{
    private HashMap<String, Unidad> unidadesPorPosicion;

    public MapaUnidades() 
    {
        unidadesPorPosicion = new HashMap<>();
    }

    // Método para agregar una unidad a la posición dada
    public void agregarUnidad(Unidad unidad) 
    {
        String clavePosicion = unidad.getPosicion().getFila() + "," + unidad.getPosicion().getColumna();
        unidadesPorPosicion.put(clavePosicion, unidad);
    }

    // Método para obtener una unidad por su posición
    public Unidad obtenerUnidadPorPosicion(int fila, int columna) 
    {
        String clavePosicion = fila + "," + columna;
        return unidadesPorPosicion.get(clavePosicion); // Devuelve la unidad o null si no existe
    }
}