package modelo;

import java.awt.Image;
import java.util.ArrayList;
import modelo.arma.ArmaFactory;

public class Unidad 
{
    private String nombre;
    private Clase clase;
    private ArrayList<Arma> armas;
    private Posicion posicion;

    public Unidad() 
    {
        this.nombre = "NN";
        this.clase = null;
        this.armas = new ArrayList<>();
        this.posicion = new Posicion();
    }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Clase getClase() { return clase; }
    public void setClase(Clase clase) { this.clase = clase; }
    
    public ArrayList<Arma> getArmas() { return armas; }
    public void setArmas(ArrayList<Arma> armas) { this.armas = armas; }
    
    // Getters y setters para comodidad
    public int getNivel() { return getClase().getNivel().getNivel(); }
    public int getExperiencia() { return getClase().getNivel().getExperiencia(); }
    
    public String getNombreClase() { return getClase().getNombre(); }

    // Métodos para obtener y establecer la posición
    public void setCorPosicion(int fila, int columna) 
    {
        this.posicion.setFila(fila);
        this.posicion.setColumna(columna);
    }

    public Posicion getPosicion() { return posicion; }
    public void setPosicion(Posicion posicion) { this.posicion = posicion; }
    
    public Image getSprite() { return clase.getSprite(); }
    
    public void añadirArma()
    {
        ArrayList<String> armasPermitidas = this.clase.getArmasPermitidas();
         
        if (armasPermitidas == null) 
            return;
        
        for (String armaPermitida : armasPermitidas) 
        {
            try 
            {
                this.armas.add(ArmaFactory.crearArma(armaPermitida));
            } 
            catch (IllegalArgumentException e) 
            {
                System.out.println("Error al añadir el arma el arma: " + armaPermitida);
                // Puedes manejar la excepción o registrar un mensaje
            }
        }
    }
    
    public void listarArmas()
    {
        if (armas.isEmpty())
            return;
        
        for (Arma arma : armas) 
        {
            System.out.println(arma.getNombre());
        }
    }
    
    public String datosUnidad()
    {
        String info;
        
        info = "-- Datos --\nNombre: "+this.getNombre()+"\nClase: "+this.getNombreClase()+
                "\n---\nNivel: "+this.getNivel()+"\nExperiencia: "+this.getExperiencia()+"\n---\n";
        
        return info;
    }
}
