package examenOnline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class AppJuego {
	
	//Atributos
	public ArrayList<Jugador>jugadores;
	public double dineroBanca;
	
	//Constructor por defecto
	public AppJuego() {
		this.jugadores = new ArrayList<Jugador>();
		this.dineroBanca = 0;
	}

	//Getters y Setters
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public double getDineroBanca() {
		return dineroBanca;
	}

	public void setDineroBanca(double dineroBanca) {
		this.dineroBanca = dineroBanca;
	}
	
	//Métodos
	//Cargar jugadores
	public void cargarJugadores(String fichero) throws FileNotFoundException {
		File file = new File(fichero);
	    Scanner scanner = new Scanner(file);
	    while (scanner.hasNextLine()) {
	        String line = scanner.nextLine();
	        String[] parts = line.split(";");

	        String nombre = parts[0];
	        int edad = Integer.parseInt(parts[1]);
	        String ciudad = parts[2];

	        Jugador jugador = new Jugador(nombre, edad, ciudad);
	        jugadores.add(jugador);
	    }
	    scanner.close();
	}
	
	//Mostrar Jugadores
	public void mostrarJugadores() {
	    for (Jugador j : jugadores) {
	        System.out.println(j);
	    }
	}

	//Jugar
	private void jugar(int nPartida) {
		double totalApostado=0;
		for (Jugador j : jugadores) {
	       j.lanzarDados();
	       for (int i = 0; i < j.getLanzamientos().length-2; i++) {
	    	   if(j.getLanzamientos()[i]==j.getLanzamientos()[i+1] && j.getLanzamientos()[i+1]==j.getLanzamientos()[i+2]) {
	    		   j.getGana()[nPartida]=1;
	    	   }
	       }
	       double dineroApostado=j.apostarDinero();
	       double dineroRestante=j.getApuesta()-dineroApostado;
	       j.setApuesta(dineroRestante);
	       totalApostado+=dineroApostado;
	       System.out.print(j.getNombre()+" "+Arrays.toString(j.getLanzamientos()));
	       System.out.println("\n\tApuesta: "+dineroApostado+"€-----le quedan "+dineroRestante+"€");
	    }
		System.out.println("\t\tTOTAL APOSTADO: "+totalApostado+"€");
		repartoTotal(totalApostado, nPartida);
		System.out.println();
	}
	
	//Reparto Total
	private void repartoTotal(double totalApostado, int nPartida) {
		int cont=0;
		boolean unGanador=false;
		for (Jugador j : jugadores) {
			if(j.getGana()[nPartida]==1) {
				cont++;
				double reparto=totalApostado/cont;
				j.setApuesta(j.getApuesta()+reparto);
				System.out.println("GANADOR "+j.getNombre()+" "+j.getApuesta()+"€");
				unGanador=true;
			}
		}
		if(!unGanador) {
			System.out.println("GANA LA BANCA: "+totalApostado+"€");
		}
	}
	
	//Mostrar Informes
	private void mostrarInformes() {
		System.out.println("\n****************************************");
		System.out.println("************Resultado final*************");
		for (Jugador j : jugadores) {
			System.out.println(j.getNombre()+" de "+j.getCiudad()+" tiene "+j.getApuesta()+"€");
		}
		System.out.println("****************************************");
		System.out.println("****************************************");
	}
	
	//PruebaUnitaria
	public static void main(String[] args) throws FileNotFoundException {
		// Crear una instancia de AppJuego
	    AppJuego app = new AppJuego();
	    app.cargarJugadores("jugadores.csv");
	    System.out.println("Los jugadores son: ");
	    app.mostrarJugadores();
	    System.out.println("****************************************");
	    System.out.println("***********Comienza el juego************");
	    System.out.println("****************************************");

	    for (int i = 0; i < 4; i++) {
			app.jugar(i);
		}
	    
	    app.mostrarInformes();
	   
	}
}
