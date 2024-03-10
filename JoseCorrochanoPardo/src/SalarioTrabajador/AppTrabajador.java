package SalarioTrabajador;

public class AppTrabajador {

	public static void main(String[] args) {
		Trabajador t=new Trabajador();
		System.out.println("**********SALARIO NETO**********");
        System.out.println("2000 ==> "+t.calculaSalarioNeto(2000));
        System.out.println("1500 ==> "+t.calculaSalarioNeto(1500));
        System.out.println("1499.99 ==> "+t.calculaSalarioNeto(1499.99));
        System.out.println("1250 ==> "+t.calculaSalarioNeto(1250));
        System.out.println("1000 ==> "+t.calculaSalarioNeto(1000));
        System.out.println("999.99 ==> "+t.calculaSalarioNeto(999.99));
        System.out.println("500 ==> "+t.calculaSalarioNeto(500));
        System.out.println("0 ==> "+t.calculaSalarioNeto(0)); 
        System.out.println();
        System.out.println("**********SALARIO BRUTO*********");
        System.out.println("vendedor,2000,8 ==> "+t.calculaSalarioBruto("vendedor",2000,8));
        System.out.println("vendedor,1500,3 ==> "+t.calculaSalarioBruto("vendedor",1500,3));
        System.out.println("vendedor,1499.99,0 ==> "+t.calculaSalarioBruto("vendedor",1499.99,0));
        System.out.println("encargado,1250,8 ==> "+t.calculaSalarioBruto("encargado",1250,8));
        System.out.println("encargado,1000,0 ==> "+t.calculaSalarioBruto("encargado",1000,0));
        System.out.println("encargado,999.99,3 ==> "+t.calculaSalarioBruto("encargado",999.99,0));
        System.out.println("encargado,500,0 ==> "+t.calculaSalarioBruto("encargado",500,0));
        System.out.println("encargado,0,8 ==> "+t.calculaSalarioBruto("encargado",0,8));
	}

}
