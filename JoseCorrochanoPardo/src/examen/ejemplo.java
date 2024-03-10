package examen;

import java.util.Scanner;

public class ejemplo {

    public static void main(String[] args) {
        String[][] t = new String[3][3];
        crearTablero(t); // inicializa las casillas a " "
        mostrarTablero(t);
        String jugador = "X";
        int x, y;
        Scanner sc = new Scanner(System.in);
        boolean juegoEnCurso = true;

        while (juegoEnCurso) {
            System.out.println("Jugador elige una posición x: ");
            x = sc.nextInt();
            System.out.println("Jugador elige una posición y: ");
            y = sc.nextInt();

            // Cambios aquí
            int resultadoColocarFicha = colocaFicha(jugador, x, y, t);
            if (resultadoColocarFicha == 0) {
                if (gana(jugador, t)) {
                    System.out.println("¡El jugador " + jugador + " ha ganado!");
                    juegoEnCurso = false;
                } else if (tableroLleno(t)) {
                    System.out.println("¡Empate! El tablero está lleno.");
                    juegoEnCurso = false;
                } else {
                    // Turno de la PC
                    if (juegaPC(t) == -1) {
                        System.out.println("¡La PC ha tenido un problema!");
                        juegoEnCurso = false;
                    } else {
                        mostrarTablero(t);
                        if (gana("O", t)) {
                            System.out.println("¡La PC ha ganado!");
                            juegoEnCurso = false;
                        } else if (tableroLleno(t)) {
                            System.out.println("¡Empate! El tablero está lleno.");
                            juegoEnCurso = false;
                        } else {
                            // Cambia de jugador
                            jugador = "X";
                        }
                    }
                }
            } else {
                System.out.println("Posición ocupada. Pierdes el turno.");
                // No cambies de jugador en este caso
            }
        }
        sc.close();
        System.out.println("¡Fin del juego!");
    }

    private static boolean tableroLleno(String[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                if (t[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }


    private static boolean gana(String jugador, String[][] t) {
        return compruebaHorizontal(jugador, t) ||
               compruebaVertical(jugador, t) ||
               compruebaDiagonal(jugador, t);
    }

    private static void mostrarTablero(String[][] t) {
        System.out.println("**********");
        for (int i = 0; i < t.length; i++) {
            System.out.print("|");
            for (int j = 0; j < t[0].length; j++) {
                System.out.print(t[i][j] + " |");
            }
            System.out.println();
        }
        System.out.println("**********");
    }

    private static void crearTablero(String[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                t[i][j] = " ";
            }
        }
    }

    private static int colocaFicha(String jugador, int x, int y, String[][] t) {
        if (t[x][y].equals(" ")) {
            t[x][y] = jugador;
            System.out.println("Ficha colocada correctamente.");
            mostrarTablero(t);
            return 0;
        } else {
            System.out.println("Posición ocupada. Pierdes el turno.");
            return -1;
        }
    }

    private static int juegaPC(String[][] t) {
        if (tableroLleno(t)) {
            return -1; // Tablero lleno, no puede jugar la PC
        }

        int x, y;
        do {
            x = (int) (Math.random() * 3);
            y = (int) (Math.random() * 3);
        } while (!t[x][y].equals(" "));

        t[x][y] = "O";
        return 0;
    }

    private static boolean compruebaHorizontal(String jugador, String[][] t) {
        for (int i = 0; i < t.length; i++) {
            boolean hayTresEnRaya = true;
            for (int j = 0; j < t[0].length; j++)
                hayTresEnRaya = hayTresEnRaya && t[i][j].equals(jugador);
            if (hayTresEnRaya)
                return true;
        }
        return false;
    }

    private static boolean compruebaVertical(String jugador, String[][] t) {
        for (int i = 0; i < t[0].length; i++) {
            boolean hayTresEnRaya = true;
            for (int j = 0; j < t.length; j++)
                hayTresEnRaya = hayTresEnRaya && t[j][i].equals(jugador);
            if (hayTresEnRaya)
                return true;
        }
        return false;
    }

    private static boolean compruebaDiagonal(String jugador, String[][] t) {
        boolean hayTresEnRaya = true;
        for (int i = 0; i < t.length; i++)
            hayTresEnRaya = hayTresEnRaya && t[i][i].equals(jugador);
        if (hayTresEnRaya)
            return true;
        hayTresEnRaya = true;
        for (int i = 0; i < t.length; i++)
            hayTresEnRaya = hayTresEnRaya && t[i][2 - i].equals(jugador);
        return hayTresEnRaya;
    }
}

