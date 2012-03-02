/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class Jugador {
    private String figura;
    private String nombre;
    private int posicion;

    public void setFigura(String figura){
        this.figura = figura;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getFigura(){
        return this.figura;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setPosicion(int posicion){
        this.posicion = posicion;
    }

    public int getPosicion(){
        return posicion;
    }
}
