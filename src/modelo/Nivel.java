package modelo;

public class Nivel 
{
    private int nivel;
    private int experiencia;

    public Nivel() 
    {
        this.nivel = 0;
        this.experiencia = 0;
    }

    public int getNivel() { return nivel; }
    public void setNivel(int nivel) { this.nivel = nivel; }

    public int getExperiencia() { return experiencia; }
    public void setExperiencia(int experiencia) { this.experiencia = experiencia; } 
}
