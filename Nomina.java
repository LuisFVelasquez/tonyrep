//EL CALIFICADOR GENERAR ERROR SI USTED NO IMPLEMENTA TODOS LOS MTODOS ESPECIFICADOS EN EL ENUNCIADO
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
public class Trabajador {

    //Inserte acá los atributos
    
    private String nombre;
    private String CC;
    private double salarioPorHora;
    private int horasTrabajadas;
    private int diaNacimiento;
    private int mesNacimiento;
    private int yearNacimiento;
    
    //Inserte acá el método constructor

    public Trabajador(
        String nombre,
        String CC,
        double salarioPorHora,
        int horasTrabajadas,
        int diaNacimiento,
        int mesNacimiento,
        int yearNacimiento) {
            this.nombre = nombre;
            this.CC = CC;
            this.horasTrabajadas = horasTrabajadas;
            if (diaNacimiento > 0 && diaNacimiento < 32)
                this.diaNacimiento = diaNacimiento;
            else this.diaNacimiento = 0;
            if (mesNacimiento > 0 && mesNacimiento < 13)
                this.mesNacimiento = mesNacimiento;
            else this.mesNacimiento = 0;
            if (yearNacimiento > 1900 && yearNacimiento < 3001)
                this.yearNacimiento = yearNacimiento;
            else this.yearNacimiento = 0;
    }
    
    //Inserte acá los SETTERS Y GETTERS
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }     
    public void setCC (String CC){
        this.CC = CC;
    }
    public void setSalarioPorHora (double salarioPorHora){
        this.salarioPorHora = salarioPorHora;
    }
    public void setHorasTrabajadas(int horasTrabajadas){
        this.horasTrabajadas = horasTrabajadas;
    }
    public void setDiaNacimiento (int diaNacimiento){
        if (diaNacimiento > 0 && diaNacimiento < 32)
            {this.diaNacimiento = diaNacimiento;}
        else diaNacimiento = 0;
    }
    public void setMesNacimiento (int mesNacimiento){
        if(mesNacimiento > 0 && mesNacimiento < 13)
            {this.mesNacimiento = mesNacimiento;}
        else this.mesNacimiento = 0;
    }
    public void setYearNacimiento (int yearNacimiento){
        if (yearNacimiento > 1900 && yearNacimiento < 3001)
            {this.yearNacimiento = yearNacimiento;}
        else this.yearNacimiento = 0;
    }
    
    public String getNombre(){
        return nombre;
    }     
    public String getCC (){
        return CC;
    }
    public double getSalarioPorHora (){
        return salarioPorHora;
    }
    public int getHorasTrabajadas (){
        return horasTrabajadas;
    }
    public int getDiaNacimiento (){
        return diaNacimiento;
    }
    public int getMesNacimiento (){
        return mesNacimiento;
    }
     public int getYearNacimiento (){
        return yearNacimiento;
    }
    
    //Inserte acá los métodos (NO LOS GETTER Y SETTERS)
    
    public double salarioQuincenal(){
        return (double) this.getHorasTrabajadas() * this.getSalarioPorHora();
    }
        
    
    //*************************************N O  E L I M I N A R  E S T E  M É T O D O*************************************
    public int calcularEdad(){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd");
        int diaActual = Integer.valueOf(myDateObj.format(myFormatObj));
        
        DateTimeFormatter myFormatObj2 = DateTimeFormatter.ofPattern("MM");
        int mesActual = Integer.valueOf(myDateObj.format(myFormatObj2));
        
        DateTimeFormatter myFormatObj3 = DateTimeFormatter.ofPattern("yyyy");
        int yearActual = Integer.valueOf(myDateObj.format(myFormatObj3));
        
        if(mesActual > mesNacimiento || mesActual == mesNacimiento && diaActual >= diaNacimiento)
            return yearActual - yearNacimiento;
        
        return yearActual - yearNacimiento - 1;     
    }
}
public class Nomina {

    //Inserte acá los atributos
    
    ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();

    //Inserte acá el método constructor

    Nomina(ArrayList<Trabajador> trabajadores){
        this.trabajadores = trabajadores;
    }
    
    //Inserte acá los SETTERS Y GETTERS

    public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    } 
    public ArrayList<Trabajador> getTrabajadores(){
        return trabajadores;
    }

    //Inserte ac los mtodos (NO LOS GETTER Y SETTERS)

    public void agregarTrabajador (Trabajador t){
		
        Trabajador tNuevo = new Trabajador();
	tNuevo = t;
		
        boolean tHallado = false;
        /*for (int i=0; i < trabajadores.size(); i++){
            if (trabajadores.get(i).CC == tNuevo.CC)
                tHallado = true;
        */}
        for (Trabajador t : trabajadores){
            if (t.get().CC == tNuevo.CC)
                tHallado = true;
        }
        if (tHallado == false){
            trabajadores.add(tNuevo);
        }
    }
    
    public void eliminarTrabajador (String ID){
        
        
        for (int i = 0; i < trabajadores.size(); i++){
             if (trabajadores.get(i).CC == ID){
                trabajadores.remove(i);
                break;
            }
        }
    }
    public double calcularSalarioQuincenalNomina(){
        double sumaNomina = 0;
        int numEmpleados = 0;
        for (int i = 0; i < trabajadores.size(); i ++){
            sumaNomina = sumaNomina + (double) trabajadores.get(i).horasTrabajadas * trabajadores.get(i).salarioPorHora;
            numEmpleados +=1;
        }
        return (double) (sumaNomina);
        
    }
    public double promedioEdadNomina(){
        int sumaEdades = 0;
        int numEmpleados = 0;
        for (int i = 0; i < trabajadores.size(); i++){
            sumaEdades = sumaEdades + trabajadores.get(i).CalcularEdad();
        }
        return (double) (sumaEdades / numEmpleados);
    }
    public double desviacionEstandarEdadNomina(){
        double promedio = promedioEdadNomina();
        int n = trabajadores.size();
        double sumadelta = 0;
        for (int ix = 0; ix < trabajadores.size(); ix++){
            sumadelta += Math.pow(trabajadores.get(ix).calcularEdad() - promedio, 2);
        }
        return (double) (Math.sqrt(sumadelta / n));
        
    }
    public double salarioQuincenalTrabajador(String ID){
		
        for (int ixx = 0; ixx < trabajadores.size(); ixx++){
            if (trabajadores.get(ixx).CC == ID){
                return (double) (trabajadores.get(ixx).horasTrabajadas * trabajadores.get(ixx).salarioPorHora);
                break;
            }
        }
    }
}
