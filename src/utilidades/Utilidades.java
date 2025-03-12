package utilidades;

import javax.swing.JOptionPane;
import java.awt.Component;
import java.util.Random;

public class Utilidades 
{
    public static boolean validarRango(Component componente, int valor, int minimo, int maximo, String mensaje) 
    {
        if (valor < minimo || valor > maximo) {
            JOptionPane.showMessageDialog(componente, mensaje);
            return false;
        }
        return true;
    }
    
    public static boolean ocurrirEvento(int porcentaje) 
    {
        if (porcentaje < 0 || porcentaje > 100) 
            throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 100.");

        // Generar un número aleatorio entre 0 y 100
        Random random = new Random();
        
        int numeroAleatorio = random.nextInt(101); // Esto genera un número entre 0 y 100

        // Si el número aleatorio es menor o igual al porcentaje, el evento ocurre
        return numeroAleatorio <= porcentaje;
    }
}
