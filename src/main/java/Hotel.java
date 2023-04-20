import java.util.InputMismatchException;
import java.util.Scanner;

public class Hotel {
    int habitaciones[][]= new int[10][4];

    public static int ValidarEntero(){
        Scanner teclado = new Scanner(System.in);
        int num = 0;

        try {
            num = teclado.nextInt();
        }catch (NumberFormatException ex){
            System.out.println("Debe escribir un numero");
        }catch(InputMismatchException e){
            System.out.println("Debe escribir un entero");
        }
        return num;
    }
    public static int Nhabitacion(){
        int num = 1;
            System.out.println("Habitacion a elegir");
            num = ValidarEntero();

        return num;
    }
    public static void RellPrimeraFila(int habitaciones[][]){
        for (int i = 0; i < habitaciones.length ; i++) {
            for (int j = 0; j < 1 ; j++) {
                habitaciones.
            }
        }
    }
}
