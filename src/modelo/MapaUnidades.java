package modelo;

import java.util.HashMap;

public class MapaUnidades 
{
    private HashMap<String, Unidad> unidadesPorPosicion;

    public MapaUnidades() 
    {
        unidadesPorPosicion = new HashMap<>();
    }

    // M�todo para agregar una unidad a la posici�n dada
    public void agregarUnidad(Unidad unidad) 
    {
        String clavePosicion = unidad.getPosicion().getFila() + "," + unidad.getPosicion().getColumna();
        unidadesPorPosicion.put(clavePosicion, unidad);
    }

    // M�todo para obtener una unidad por su posici�n
    public Unidad obtenerUnidadPorPosicion(int fila, int columna) 
    {
        String clavePosicion = fila + "," + columna;
        return unidadesPorPosicion.get(clavePosicion); // Devuelve la unidad o null si no existe
    }
}