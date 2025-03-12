package modelo.arma;

import modelo.Arma;

public class Espada extends Arma
{
    public Espada() 
    {
        this.setNombre("Espada");
        this.setPeso(5);
        this.setPotencia(5);
        this.setGolpe(90);
        this.setCritico(0);
    }
}
