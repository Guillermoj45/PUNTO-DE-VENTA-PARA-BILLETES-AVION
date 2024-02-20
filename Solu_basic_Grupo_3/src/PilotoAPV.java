import java.util.Scanner;

public class PilotoAPV {
    public static void main(String[] args) {
        int eleccion = 1;
        do {
            System.out.println("\t\t\t\t\t\t\033[1mPROGRAMA BILLETE AVIÓN\033[0m");
            System.out.println("\t\t\t\t\t\t\033[1m----------------------\033[0m");
            System.out.println("\t\t\t\t\033[1mMENÚ\033[0m");
            System.out.println("1.-Transformación fecha suministrada como parámetro");
            System.out.println("2.-Generación de la hora de llegada");
            System.out.println("3.-Generación automatizada de tabla de meses");
            System.out.println("4.-Obtención de los días correspondientes de un mes");
            System.out.println("5.-Recopilación información de un vuelo");
            System.out.println("6.-Salir");
            System.out.print("Opción:");
            Scanner entrada = new Scanner(System.in);
            eleccion = entrada.nextInt();

            switch (eleccion) {
                case 1:
                    System.out.println("Opción 1");
                    break;
                case 2:
                    System.out.println("Opción 2");
                    break;
                case 3:
                    System.out.println("Opción 3");
                    break;
                case 4:
                    System.out.println("Opción 4");
                    break;
                case 5:
                    System.out.println("Opción 5");
                    break;
                case 6:
                    System.out.println("¡Hasta pronto!");
            }
        }
        while (eleccion != 6);
    }
}