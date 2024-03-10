package examen;

import java.util.Arrays;
import java.util.Scanner;

public class JuegoCompleto {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String letra="";
		String jugadores[]=new String[4];
		String opcion="";
		int matriz[][]=new int[4][10];
		int gana[]=new int[4];
		double apuestas[]= {500.0,500.0,500.0,500.0};
		
		String[]participantes={"X123","Z3423","J111_Ma","X322","J222_IV","J123_Ca","J341_Ja",
				"Zdsfa","Xdfa","zeree","X111_Lu","X222_Mi","X256_PP","X299_An",
				"Juan999","LuisaCC2","XX1234","Z23","X_3234","Z876_Mi","Z100_TN",
				 "Z987_He","Z299_Rw","JJJ22"};
		
		//Selecciona la letra del nick
		do {
			System.out.println("Selecciona una letra: J, X o Z");
		    letra=sc.next();
		}while(!(letra.equals("J") || letra.equals("X")|| letra.equals("Z")));
		
		int k=0;
		for (int i = 0; i < participantes.length; i++) {
			
			if(participantes[i].matches(letra+"[0-9]{3}_[a-zA-Z]{2}")) {
				jugadores[k]=participantes[i];
				k++;
			}
		
		}
		System.out.println("Los jugadores seleccionados son: "+Arrays.toString(jugadores));
		System.out.println("Dinero disponible para apostar: "+Arrays.toString(apuestas));
		do {
			System.out.println("Nueva partida");
			int apuesta=0;
			double totalApostado=0;
			for(int i=0;i<jugadores.length; i++) {
				apuesta=(int)(1+Math.random()*100);
				System.out.println("El jugador "+jugadores[i]+" apuesta "+apuesta+"€");
				apuestas[i]-=apuesta;
				totalApostado+=apuesta;
			}
		
			System.out.println("Total apostado: "+totalApostado+"€");
		
		
			lanzarDados(matriz);
			imprimePartidas(matriz);
			menu();
			opcion=(sc.next()).toUpperCase();
			switch(opcion) {
				
				case "A":
					sumaSiguiente(matriz,gana);
					break;
				case "B":
					ImparPar(matriz,gana);
					break;
				case "C":
					break;
			
			}
			
			if(!opcion.equals("C")) {
				System.out.println("***************REPARTO****************");
				reparto(gana, totalApostado,apuestas);
				System.out.println("**************************************");
				System.out.println();
				System.out.println();
				
			}
			
		}while(!opcion.equals("C"));
		
		System.out.println("******************RESULTADOS*********************");
		for(int i=0; i<jugadores.length; i++) {
			System.out.println(jugadores[i]+": "+apuestas[i]+"€");
		}
		sc.close();
		
	}
	
	

	private static void reparto(int[] gana, double totalApostado,double[]apuestas) {
		int cont=0;
		for(int i=0; i<gana.length; i++)
			if(gana[i]==1) 
				cont++;
		
		if(cont>0) {
			System.out.println("Nº de ganadores: "+cont);
			double totalPorJugador=totalApostado/cont;
			for(int i=0; i<apuestas.length;i++) {
				if(gana[i]==1) {
					System.out.println("Gana el jugador "+i+" que ingresa "+totalPorJugador+"€");
					apuestas[i]+=totalPorJugador;
				}
			}
		}else {
			System.out.println("Gana la banca");
		}
		
		System.out.println(Arrays.toString(apuestas));
		for(int i=0; i<gana.length; i++)
			gana[i]=0;
	}



	private static void ImparPar(int[][] matriz,int[] gana) {
		int suma=0;
		for(int i=0;i<matriz.length;i++) {
			for(int j=1; j<matriz[0].length;j=j+2) {
				if(j%2==1) {
					suma+=matriz[i][j];
				}
				
			}
		
			if(suma%2==0) {
			//	System.out.println(suma);
				gana[i]=1;
			}
			suma=0;
		}
		//System.out.println(Arrays.toString(gana));
		
	}


	

	private static void sumaSiguiente(int[][] matriz,int []gana) {
		for(int i=0;i<matriz.length; i++) {
			for(int j=0; j<matriz[0].length-2;j++) {
				if(matriz[i][j]+matriz[i][j+1]==matriz[i][j+2]) {
					gana[i]=1;
					System.out.println("gana "+i+" "+i+" "+j);
				}
			}
		}
		
	}



	

	private static void menu() {
		System.out.println();
		System.out.println("A)Dos números suman el siguiente");
	   	System.out.println("B)Tirada impar suma par");
		System.out.println("C)Salir");
		System.out.println();
		
	}

	private static void lanzarDados(int[][] matriz) {
		for(int i=0; i<matriz.length; i++)
		{
			for(int j=0;j<matriz[0].length; j++)
				matriz[i][j]=(int)(1+Math.random()*6);
		}
		
	}
	private static void imprimePartidas(int[][]matriz) {
		System.out.print("************Lanzamientos************");
		for(int i=0; i<matriz.length; i++){
			System.out.println();
			for(int j=0;j<matriz[0].length; j++) {
				matriz[i][j]=(int)(1+Math.random()*6);
				System.out.print(matriz[i][j]+"  ");
			}
		}
		System.out.print("\n************************************\n");
	}

}