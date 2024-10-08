import java.util.Scanner;

public class Simulador{
    public static void main (String [] args){
        Scanner scanner = new Scanner (System.in);
        Empleado [] empleadoArreglo = new Empleado [5];
        
        int id_EmpleadoMain;
        String nombreMain;
        float salarioMain;
        
        for (int i = 0; empleadoArreglo.length > i; i++){
            System.out.println ("Ingrese el id (utilizar números del 1 al 5) del empleado : ");
            id_EmpleadoMain = scanner.nextInt();
            
            System.out.println ("Ingrese el nombre del empleado : ");
            nombreMain = scanner.nextLine();
            
            System.out.println ("Ingrese el salario del empleado: ");
            salarioMain = scanner.nextFloat();
        }
        
        
        
        
    }
}
