package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import modelo.MapaUnidades;
import modelo.Unidad;

public class VentanaMapaJuego extends JPanel {

    private ArrayList<Unidad> listaUnidades; // Lista de unidades a dibujar
    private final int TAMANO_CELDA = 16;
    private final int filas;
    private final int columnas;
    private final int[][] mapa;
    private final Image tierra;
    private final Image pilar;
    private boolean colocarUnidades = false;
    private MapaUnidades ubicacionUnidades;

    // Coordenadas del cursor
    private int cursorFila = 0;
    private int cursorColumna = 0;

    public VentanaMapaJuego(int numFilas, int numColumnas) 
    {
        listaUnidades = new ArrayList<>();
        ubicacionUnidades = new MapaUnidades();
        
        mapa = new int[numFilas][numColumnas];
        generarMapaAleatorio();

        tierra = new ImageIcon(getClass().getResource("/resourses/imagenes/suelo.png")).getImage();
        pilar = new ImageIcon(getClass().getResource("/resourses/imagenes/pilar.png")).getImage();

        setPreferredSize(new Dimension(numColumnas * TAMANO_CELDA, numFilas * TAMANO_CELDA));
        
        this.filas = numFilas;
        this.columnas = numColumnas;

        setFocusable(true);
        addKeyListener(new KeyListener() 
        {
            @Override
            public void keyPressed(KeyEvent e) 
            {
                moverCursor(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) 
            {
                // No usado
            }

            @Override
            public void keyTyped(KeyEvent e) 
            {
                // No usado
            }
        });
    }
    
    // Método para actualizar la lista de unidades
    public void setListaUnidades(ArrayList<Unidad> lista) { this.listaUnidades = lista; }

    private void generarMapaAleatorio() 
    {
        for (int i = 0; i < filas; i++) 
        {
            for (int j = 0; j < columnas; j++) 
            {
                mapa[i][j] = Math.random() < 0.7 ? 0 : 1;
            }
        }
    }

    private void moverCursor(int keyCode) 
    {
        switch (keyCode) 
        {
            case KeyEvent.VK_W:
                if (cursorFila > 0) cursorFila--;
                break;
            case KeyEvent.VK_S:
                if (cursorFila < filas - 1) cursorFila++;
                break;
            case KeyEvent.VK_A:
                if (cursorColumna > 0) cursorColumna--;
                break;
            case KeyEvent.VK_D:
                if (cursorColumna < columnas - 1) cursorColumna++;
                break;
        }
        imprimirInformacionUnidad(cursorFila, cursorColumna);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        for (int i = 0; i < filas; i++) 
        {
            for (int j = 0; j < columnas; j++) 
            {
                Image sprite = mapa[i][j] == 0 ? tierra : pilar;

                g.drawImage(sprite, j * TAMANO_CELDA, i * TAMANO_CELDA, TAMANO_CELDA, TAMANO_CELDA, this);
            }
        }
        
        if (listaUnidades.isEmpty()) 
        {
            System.out.println("No hay unidades registradas");
            return;
        }
        
        // Dibujar las unidades
        for (Unidad unidad : listaUnidades) 
        {
            colocarUnidadesAleatorias(unidad);

            // Dibujar el sprite de la unidad en la celda correspondiente
            g.drawImage(unidad.getClase().getSprite(), unidad.getPosicion().getColumna() * TAMANO_CELDA, unidad.getPosicion().getFila() * TAMANO_CELDA, TAMANO_CELDA, TAMANO_CELDA, this);
            
        }
        
        g.setColor(Color.RED);
        g.drawRect(cursorColumna * TAMANO_CELDA, cursorFila * TAMANO_CELDA, TAMANO_CELDA, TAMANO_CELDA);
    }
    
    public void imprimirInformacionUnidad(int fila, int columna)
    {
        Unidad unidad = ubicacionUnidades.obtenerUnidadPorPosicion(fila, columna);
        
        if (unidad == null)
            return;
        
        if (fila == cursorFila && columna == cursorColumna)
        {
            System.out.println(unidad.datosUnidad());
        }
    }
    
    public void colocarUnidadesAleatorias(Unidad unidad) 
    {
        // Para que sean colocadas una sola vez
        if (colocarUnidades)
            return;
        
        Random rand = new Random();
        
        int fila = rand.nextInt(14);
        int columna = rand.nextInt(14);
        
        unidad.setCorPosicion(fila, columna);
        
        ubicacionUnidades.agregarUnidad(unidad);
        
        
        colocarUnidades = true;
    }
}
