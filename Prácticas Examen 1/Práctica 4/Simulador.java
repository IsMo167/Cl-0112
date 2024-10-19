import java.util.Scanner;

public class Simulador{
    public static void main (String [] args){
        Scanner scanner = new Scanner (System.in);
        Empleado [] empleadoArreglo = new Empleado [3];
        
        int id_EmpleadoMain;
        String nombreMain;
        float salarioMain;
        
        for (int i = 0; empleadoArreglo.length > i; i++){
            System.out.print("Ingrese el id (utilizar números del 1 al 3) del empleado : ");
            id_EmpleadoMain = scanner.nextInt();
            scanner.nextLine();
            System.out.print ("Ingrese el nombre del empleado : ");
            nombreMain = scanner.nextLine();
            System.out.print ("Ingrese el salario del empleado: ");
            salarioMain = scanner.nextFloat();
            scanner.nextLine();
            empleadoArreglo[i] = new Empleado(id_EmpleadoMain, nombreMain, salarioMain);
        }
        
        System.out.println("\nDetalles de los empleados:");
        for (Empleado empleado : empleadoArreglo) {
            empleado.mostrar_Detalles();
        }
        
        
    }
}

