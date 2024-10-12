public class Empleado{
    private int id_Empleado;
    private String nombre;
    private float salario;
    
    private Empleado [] empleado;
    
    public Empleado (int id_Empleado, String nombre, float salario){
        this.id_Empleado = id_Empleado;
        this.nombre = nombre;
        this.salario = salario;
    }
    
    public void setId_Empleado (int id_Empleado){
        this.id_Empleado = id_Empleado;
    }
    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    public void setSalario (int salario){
        this.salario = salario;
    }
    public void setEmpleado (Empleado [] empleado){
        this.empleado = empleado;
    }
    
    public int getId_Empleado (){
        return id_Empleado;
    }
    public String getNombre (){
        return nombre;
    }
    public float getSalario (){
        return salario;
    }
    public Empleado[] getEmpleado (){
        return empleado;
    }
    
    public void mostrar_Detalles (){
        System.out.println ("El id del empleado es: " + id_Empleado);
        System.out.println ("El nombre del empleado es: " + nombre);
        System.out.println ("El salario del empleado es: " + salario);
    }
    
    
}