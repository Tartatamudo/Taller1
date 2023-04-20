import java.util.InputMismatchException;
import java.util.Scanner;

public class Hotel {
    int habitaciones[][]= new int[10][3];

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

        return num -1;
    }

    public static void ImpMatriz(int habitaciones[][]){
        for (int i = 0; i < habitaciones.length; i++) {
            System.out.print(i+1 + "; ");
            for (int j = 0; j < habitaciones[i].length; j++) {
                System.out.print(habitaciones[i][j] + "; ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int habitaciones[][]= new int[10][3];
        ImpMatriz(habitaciones);
    }
    public static void RellenarFila(int habitaciones[][]){
        int num = Nhabitacion();
        RellComida(habitaciones, num);
        RellDias(habitaciones, num);
        RellDisponibildad(habitaciones, num);
    }

    private static void RellComida(int[][] habitaciones, int num) {
        System.out.println("Desea comida");
        System.out.println("[1]Si");
        System.out.println("[2]No");
        int opcion = ValidarEntero();
        habitaciones[num][2] = opcion;
    }
}
