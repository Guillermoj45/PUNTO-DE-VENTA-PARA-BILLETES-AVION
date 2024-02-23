import java.util.Scanner;

public class PilotoAPV {

    public static void main(String[] args) {
        System.out.println("\t\t\t\033[1mPROGRAMA BILLETE AVIÓN\033[0m");
        System.out.println("\t\t\t\033[1m----------------------\033[0m");
        int eleccion;
        do {
            System.out.println("\t\t\t\t\t\033[1mMENÚ\033[0m");
            System.out.println("1.-Transformación fecha suministrada como parámetro");
            System.out.println("2.-Generación de la hora de llegada");
            System.out.println("3.-Generación automatizada de tabla de meses");
            System.out.println("4.-Obtención de los días correspondientes de un mes");
            System.out.println("5.-Recopilación información de un vuelo");
            System.out.println("6.-Salir");
            System.out.print("\nOpción: ");
            Scanner entrada = new Scanner(System.in);
            try {
                eleccion = entrada.nextInt();
            } catch (Exception e) {
                eleccion = 0;
            }

            switch (eleccion) {
                case 1:
                    System.out.println("\nEl resultado solicitado de la misma es: " + ApoyoPuntoVenta.transformaFecha(args) + "\n");
                    System.out.println("\n");
                    break;
                case 2:
                    String hora_llegada = ApoyoPuntoVenta.gener_hora_llegada();
                    System.out.println("\nEl resultado solicitado de la misma es: " + hora_llegada + "\n");
                    System.out.println("\n");
                    break;
                case 3:
                    String cadena_meses = ApoyoPuntoVenta.gener_tabla_nombres();
                    System.out.println("\nEl resultado solicitado es:\n" + cadena_meses);
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.println("\nEl resultado solicitado es: " + ApoyoPuntoVenta.numeroDiasMes());
                    System.out.println("\n");
                    break;
                case 5:
                    Scanner input = new Scanner(System.in);
                    System.out.print("\n");
                    System.out.print("Origen: ");
                    String Ciudad = input.nextLine();
                    System.out.print("Destino: ");
                    String CiudadDest = input.nextLine();
                    System.out.println(ApoyoPuntoVenta.RecoDate(Ciudad,CiudadDest));
                    System.out.println("\n");
                    break;
                case 6:
                    System.out.println("\n");
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.print("\n");
                    System.out.print("Opción no válida.");
                    System.out.println("\n");
                    break;
            }
        }
        while (eleccion != 6);
    }
}