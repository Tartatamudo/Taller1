import java.util.InputMismatchException;
import java.util.Scanner;

public class bsdfbasdf {

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
    public static int Nhabitacion() {
        int num = 0;
        while ((num < 1) || (num > 10)) {
            System.out.println("Habitacion a elegir");
            num = ValidarEntero();
            if(num < 1 || num > 10){
                System.out.println("Debe elegir entre las 10 habitaciones");
            }
        }
        return num - 1;
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
        System.out.println("[0]Si");
        System.out.println("[1]No");
        int opcion = ValidarEntero();
        habitaciones[num][1] = opcion;
    }
    public static int DisponibilidadDeHabitacion(int[][] habitaciones, int num){
        int disponibilidad = habitaciones[num][0];
        return disponibilidad;
    }
    public static int CostoDia(int[][] habitaciones, int num){

        if (habitaciones[num][1] == 0){
            return  40000;
        }else if(habitaciones[num][1] == 1){
            return  30000;
        }
        return 0;
    }
    public static void Boleta(int [][] habitaciones){
        int num = Nhabitacion();
        int costo = CostoDia(habitaciones, num);

        int total =  costo *(habitaciones[num][2]);

        System.out.println("Habitacion:" + (num+1)  );
        System.out.println("Dias que estuvo:" + habitaciones[num][2]);
        System.out.println("Paga:" + total);
    }

    public static void MenuResetaerTodo(int[][] habitaciones){
        System.out.println("Ingrese contrseña");
        int contraseña = ValidarEntero();
        if(contraseña == 1234){
            ResetearTodo(habitaciones);
        }else{
            System.out.println("Contraseña erronea");
        }
    }
    public static void ResetearTodo(int[][] habitaciones){

        for (int i = 0; i < habitaciones.length; i++) {
            for (int j = 0; j < habitaciones[i].length; j++) {
                habitaciones[i][j] = 0;
            }
        }
    }
    public static void MenuConsultarDisponibilidad(int[][] habitaciones){
        int num = ValidarEntero();
        if(habitaciones[num][0] == 0){
            System.out.println("Esta dispobile");
        } else if (habitaciones[num][0] == 1) {
            System.out.println("Esta reservada");
        }else{
            System.out.println("Esta ocupada");
        }
    }
   public static void QuitarResOcup(int [][] habitaciones) {
        int num = Nhabitacion();
        habitaciones[num][0] = 0;
        habitaciones[num][1] = 0;
        habitaciones[num][2] = 0;

    }

    public static void menu() {
        int habitaciones[][] = new int[10][3];

        int eleccion = 1;

        while (eleccion < 5 && eleccion > 0) {
            System.out.println("ELiga lo que quiere hacer");
            System.out.println("[1]Rellenar Habitacion");
            System.out.println("[2]Consultar Estado de Habitacion");
            System.out.println("[3]Boleta");
            System.out.println("[4]Reiniciar hotel");
            System.out.println("[5]Quitar reserva o ocupado");
            System.out.println("Si desea salir oprima cualquier otro numero");

            eleccion = ValidarEntero();

            switch (eleccion) {
                case 1:
                    MenuRellenarHabitacion(habitaciones);
                    break;
                case 2:
                    MenuConsultarDisponibilidad(habitaciones);
                    break;
                case 3:
                    Boleta(habitaciones);
                    break;
                case 4:
                    MenuResetaerTodo(habitaciones);
                    break;
                case 5:
                    QuitarResOcup(habitaciones);
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
