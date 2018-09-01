package app.model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class Tablero{
    private String[] tab = new String[9];
    private String ganador = null;

    public Tablero(){
        for(int i=0 ; i<tab.length ; i++){
            tab[i] = Integer.toString(i+1);
        }
    }

    public void imprimirTablero(){
        int cont = 0;
        System.out.print("\t\t\t");
        for(int i=0 ; i<tab.length ; i++){
            System.out.print("  "+tab[i]+"  ");
            cont++;
            if(cont == 3){
                System.out.print("\n\n");
                System.out.print("\t\t\t");
                cont = 0;
            }
        }
    }

    public void setFigura(String fig, int num){
        tab[num-1] = fig;
    }

    public boolean tableroLleno(){
        int cont = 0;
        for(int i=0 ; i<tab.length ; i++){
            if(!tab[i].equalsIgnoreCase(Integer.toString(i+1))){
                cont++;
            }
        }
        if(cont == 9)
            return true;
        else return false;
    }

    public boolean posicionOcupada(int posicion){
        if(tab[posicion-1].equalsIgnoreCase("x")
        || tab[posicion-1].equalsIgnoreCase("o"))
            return true;
        else
            return false;
    }

    public boolean hayGanador(){
        if(tab[0].equalsIgnoreCase(tab[1]) && tab[1].equalsIgnoreCase(tab[2])){
            ganador = tab[0];
            return true;
        }else if(tab[3].equalsIgnoreCase(tab[4]) && tab[4].equalsIgnoreCase(tab[5])){
            ganador = tab[3];
            return true;
        }else if(tab[6].equalsIgnoreCase(tab[7]) && tab[7].equalsIgnoreCase(tab[8])){
            ganador = tab[6];
            return true;
        }else if(tab[0].equalsIgnoreCase(tab[3]) && tab[3].equalsIgnoreCase(tab[6])){
            ganador = tab[0];
            return true;
        }else if(tab[1].equalsIgnoreCase(tab[4]) && tab[4].equalsIgnoreCase(tab[7])){
            ganador = tab[1];
            return true;
        }else if(tab[2].equalsIgnoreCase(tab[5]) && tab[5].equalsIgnoreCase(tab[8])){
            ganador = tab[2];
            return true;
        }else if(tab[0].equalsIgnoreCase(tab[4]) && tab[4].equalsIgnoreCase(tab[8])){
            ganador = tab[0];
            return true;
        }else if(tab[2].equalsIgnoreCase(tab[4]) && tab[4].equalsIgnoreCase(tab[6])){
            ganador = tab[2];
            return true;
        }else return false;
    }

    public String getGanador(){
        return ganador;
    }
}
