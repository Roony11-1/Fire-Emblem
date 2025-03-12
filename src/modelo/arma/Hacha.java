package modelo.arma;

import modelo.Arma;

public class Hacha extends Arma
{
    public Hacha() 
    {
        this.setNombre("Hacha");
        this.setPeso(10);
        this.setPotencia(8);
        this.setGolpe(85);
        this.setCritico(0);
    }
}
