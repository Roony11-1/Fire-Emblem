package modelo.arma;

import modelo.Arma;

public class Arco extends Arma
{
    public Arco() 
    {
        this.setNombre("Arco");
        this.setAlcance(2);
        this.setPeso(5);
        this.setPotencia(6);
        this.setGolpe(85);
        this.setCritico(0);
    }
}
