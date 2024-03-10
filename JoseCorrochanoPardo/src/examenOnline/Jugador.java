package examenOnline;

public class Jugador {
	
	//Atributos
	private String nombre;
	private int edad;
	private String ciudad;
	private int[]lanzamientos;
	private int []gana;
	private double apuesta;
	
	//Constructor con los parámetros nombre,edad,ciudad
	public Jugador(String nombre, int edad, String ciudad) {
		this.nombre = nombre;
		this.edad = edad;
		this.ciudad = ciudad;
		this.lanzamientos=new int[10];
		this.gana=new int[4];
		this.apuesta=500;
	}

	//Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int[] getLanzamientos() {
		return lanzamientos;
	}

	public void setLanzamientos(int[] lanzamientos) {
		this.lanzamientos = lanzamientos;
	}

	public int[] getGana() {
		return gana;
	}

	public void setGana(int[] gana) {
		this.gana = gana;
	}

	public double getApuesta() {
		return apuesta;
	}

	public void setApuesta(double apuesta) {
		this.apuesta = apuesta;
	}

	//toString
	@Override
	public String toString() {
		return nombre+" de "+edad+" años de la ciudad "+ciudad;
	}
	
	//Métodos
	public double apostarDinero() {
		return Math.round(1+Math.random()*500);
	}
	
	public void lanzarDados() {
		for (int i = 0; i < this.getLanzamientos().length; i++) {
			this.lanzamientos[i]=(int)(1+Math.random()*6);
		}
	}
	
	//Prueba Unitaria
	public static void main(String[] args) {
		//Crear Jugadores
		Jugador j=new Jugador("José", 20, "Talavera");
		Jugador j2=new Jugador("Carlos", 24, "Toledo");
		
		//Mostrar Jugadores
		System.out.println(j);
		System.out.println(j2);
		
		//Lanzar dados de los dos jugadores
		j.lanzarDados();
		j2.lanzarDados();
		
		//Mostrar lanzamientos del primer jugador
		for (int i = 0; i < j.lanzamientos.length; i++) {
			System.out.print(j.lanzamientos[i]+" ");
		}
		System.out.println();
		
		//Mostrar lanzamientos del segundo jugador
		for (int i = 0; i < j2.lanzamientos.length; i++) {
			System.out.print(j2.lanzamientos[i]+" ");
		}
		System.out.println();
		
		//Mostrar el dinero que apuesta cada jugador
		System.out.println(j.apostarDinero());
		System.out.println(j2.apostarDinero());
	}
}
