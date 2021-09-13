//EL CALIFICADOR GENERAR ERROR SI USTED NO IMPLEMENTA TODOS LOS MTODOS ESPECIFICADOS EN EL ENUNCIADO
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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