package modelo;

public class Posicion 
{
    private int fila;
    private int columna;

    public Posicion() 
    {
        this.fila = 0;
        this.columna = 0;
    }

    public int getFila() { return fila; }
    public void setFila(int fila) { this.fila = fila; }

    public int getColumna() { return columna; }
    public void setColumna(int columna) { this.columna = columna; }
}
