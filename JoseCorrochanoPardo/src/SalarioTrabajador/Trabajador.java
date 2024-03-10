package SalarioTrabajador;

public class Trabajador {
    private String nombre;
    private int mes;
    private int año;
    private double SalarioBruto;
    private double SalarioNeto;
    
    //constructor por defecto
    //inicializa variables y rserva memoria
    public Trabajador(){
        this.nombre="";
        this.mes=0;
        this.año=0;
        this.SalarioBruto=0;
        this.SalarioNeto=0;
    }
    
    //constructor con todos los parámetros
    public Trabajador(String nombre, int mes, int año, double SalarioBruto, double SalarioNeto){
        this.nombre = nombre;
        this.mes = mes;
        this.año = año;
        this.SalarioBruto = SalarioBruto;
        this.SalarioNeto = SalarioNeto;
    }
    
    //geters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getSalarioBruto() {
        return SalarioBruto;
    }

    public void setSalarioBruto(double SalarioBruto) {
        this.SalarioBruto = SalarioBruto;
    }

    public double getSalarioNeto() {
        return SalarioNeto;
    }

    public void setSalarioNeto(double SalarioNeto) {
        this.SalarioNeto = SalarioNeto;
    }
    
    public double calculaSalarioBruto(String TipoEmpleado, double ventasMes, int horasExtra){
        double salarioBase=0;
        double prima=0;
        if (TipoEmpleado.equals("vendedor"))
            salarioBase=1000;
        else if (TipoEmpleado.equals("encargado"))
            salarioBase=1500;
        if (ventasMes>=1000)
            prima=100;
        else if (ventasMes>=1500)
            prima=200;
        return salarioBase+prima+(double)(horasExtra*20);
    }
    
    public double calculaSalarioNeto(double salarioBruto){
       if (salarioBruto<1000)
           return salarioBruto;
       else if (salarioBruto>1000 && salarioBruto<1500)
           return salarioBruto-(salarioBruto*0.16);
       else
           return salarioBruto-(salarioBruto*0.18);
    }
   
    
}
