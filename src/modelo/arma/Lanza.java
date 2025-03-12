package modelo.arma;

import modelo.Arma;

public class Lanza extends Arma
{
    public Lanza() 
    {
        this.setNombre("Lanza");
        this.setPeso(8);
        this.setPotencia(7);
        this.setGolpe(80);
        this.setCritico(0);
    }
}
