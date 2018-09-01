package app;


import app.model.Jugador;
import app.model.Tablero;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 */
public class Juego {

    private static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    private static Jugador jugador1 = new Jugador();
    private static Jugador jugador2 = new Jugador();
    private static String figura, respuesta = null;
    private static Tablero tab;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        do {
            tab = new Tablero();
            pedirInformacion();
            do {
                juegaJugador(jugador1);
                juegaJugador(jugador2);
            } while (!tab.tableroLleno() && !tab.hayGanador());
            verGanador();
            try {
                do {
                    System.out.println("Otra vez? [si/no]: ");
                    respuesta = leer.readLine();
                    if (!respuesta.equalsIgnoreCase("no") && !respuesta.equalsIgnoreCase("si")) {
                        limpiarPantalla();
                    }
                } while (!respuesta.equalsIgnoreCase("no") && !respuesta.equalsIgnoreCase("si"));
            } catch (IOException e1) {
            }
        } while (respuesta.equalsIgnoreCase("si"));
        limpiarPantalla();
        System.out.println("Adios");
    }

    private static void pedirInformacion() {
        try {
            limpiarPantalla();
            System.out.println("Nombre Jugador 1: ");
            jugador1.setNombre(leer.readLine());
            do {
                limpiarPantalla();
                System.out.println(jugador1.getNombre() + ", elija figura [x/o]: ");
                figura = leer.readLine();
            } while (!figura.equalsIgnoreCase("x") && !figura.equalsIgnoreCase("o"));
            jugador1.setFigura(figura);

            if (jugador1.getFigura().equalsIgnoreCase("x")) {
                jugador2.setFigura("o");
            } else {
                jugador2.setFigura("x");
            }


            limpiarPantalla();
            System.out.println("Nombre Jugador 2: ");
            jugador2.setNombre(leer.readLine());
        } catch (IOException e) {
        }
    }

    private static void juegaJugador(Jugador jugador) {
        try {
            limpiarPantalla();
            tab.imprimirTablero();
            if (!tab.tableroLleno() && !tab.hayGanador()) {
                do {
                    do {
                        System.out.print("Juega " + jugador.getNombre() + "[" + jugador.getFigura() + "] >>>");
                        jugador.setPosicion(Integer.parseInt(leer.readLine()));
                    } while (jugador.getPosicion() < 1 || jugador.getPosicion() > 9);

                    if (tab.posicionOcupada(jugador.getPosicion())) {
                        limpiarPantalla();
                        tab.imprimirTablero();
                        System.out.println("Casilla Ocupada!!!");
                    }
                } while (tab.posicionOcupada(jugador.getPosicion()));
                tab.setFigura(jugador.getFigura(), jugador.getPosicion());
            }
        } catch (NumberFormatException e) {
            juegaJugador(jugador);
        } catch (IOException e) {
        }
    }

    private static void verGanador() {
        if (jugador1.getFigura().equalsIgnoreCase(tab.getGanador())) {
            System.out.println(jugador1.getNombre() + "[" + jugador1.getFigura() + "]" + " has ganado!!!!!!");
        } else if (jugador2.getFigura().equalsIgnoreCase(tab.getGanador())) {
            tab.imprimirTablero();
            System.out.println(jugador2.getNombre() + "[" + jugador2.getFigura() + "]" + " has ganado!!!!!!");
        } else {
            System.out.println("EMPATE!!!!!!!!!");
        }
    }

    private static void limpiarPantalla() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}
