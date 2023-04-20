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
            System.out.print( i+1 + "; ");
            for (int j = 0; j < habitaciones[i].length; j++) {
                System.out.print(habitaciones[i][j] + "; ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int habitaciones[][] = new int[10][3];
        ImpMatriz(habitaciones);
    }
    public static void MenuRellenarHabitacion(int habitaciones[][]){
        int num = Nhabitacion();
        int disponibilidad = DisponibilidadDeHabitacion(habitaciones, num);
        if (disponibilidad == 0){
            RellenarHabitacion(habitaciones, num);
        }else {
            System.out.println("La habitacion esta ocupada o reservada");
        }
    }
    public static void RellenarHabitacion(int habitaciones[][], int num){
        RellComida(habitaciones, num);
        RellDias(habitaciones, num);
        RellDisponibildad(habitaciones, num);
    }

    public static void RellDisponibildad(int[][] habitaciones, int num) {
        System.out.println("Disponibildad");
        System.out.println("[0]Disponible");
        System.out.println("[1]Reservada");
        System.out.println("[2]Ocupada");

        int opcion = ValidarEntero();
        habitaciones[num][0] =opcion;
    }

    public static void RellDias(int[][] habitaciones, int num) {
        System.out.println("Numero de dias que se va a quedar la persona");
        int dias = ValidarEntero();
        habitaciones[num][2] = dias;
    }

    public static void RellComida(int[][] habitaciones, int num) {
        System.out.println("Desea comida");
        System.out.println("[1]Si");
        System.out.println("[2]No");
        int a = 1;
        habitaciones[num][1] = a;
    }
    public static int DisponibilidadDeHabitacion(int[][] habitaciones, int num){
        int disponibilidad = habitaciones[num][0];
        return disponibilidad;
    }
}