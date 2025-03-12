package modelo;

public abstract class Arma 
{
    private String nombre;
    private int maestria;
    private int alcance;
    private int peso;
    private int potencia;
    private int golpe;
    private int critico;

    public Arma() 
    {
        this.nombre = "XX";
        this.maestria = 0;
        this.alcance = 1;
        this.peso = 0;
        this.potencia = 0;
        this.golpe = 0;
        this.critico = 0;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getMaestria() { return maestria; }
    public void setMaestria(int maestria) { this.maestria = maestria; }

    public int getAlcance() { return alcance; }
    public void setAlcance(int alcance) { this.alcance = alcance; }

    public int getPeso() { return peso; }
    public void setPeso(int peso) { this.peso = peso; }

    public int getPotencia() { return potencia; }
    public void setPotencia(int potencia) { this.potencia = potencia; }

    public int getGolpe() { return golpe; }
    public void setGolpe(int golpe) { this.golpe = golpe; }

    public int getCritico() { return critico; }
    public void setCritico(int critico) { this.critico = critico; }
}
