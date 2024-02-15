import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ApoyoPuntoVenta {

    public static String gener_hora_llegada() {
        System.out.println("Opción 2");

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nHora de despegue (hh:mm): ");
        String hora_despegue = scanner.next();
        System.out.print("Duración (en minutos): ");
        int duracion_min = scanner.nextInt();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime hora_despegue_fin = LocalTime.parse(hora_despegue, formatter);

        LocalTime hora_llegada = hora_despegue_fin.plusMinutes(duracion_min);

        return hora_llegada.format(formatter);
    }

    public static String gener_tabla_nombres() {
        System.out.println("Opción 3");

        String[] meses = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };

        String cadena_meses = "";

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nIntroduzca el mes en formato numérico: ");
            int num_mes = scanner.nextInt();

            System.out.println("\nLa tabla se está generando...");
            int primer_mes = num_mes - 1;

            if (primer_mes >= 0 && num_mes <= 12) {

                for (int i = 0; i < meses.length; i++) {
                    cadena_meses += (meses[(primer_mes + i) % meses.length] + ", ");
                }

                break;
            }
            else {
                System.out.println("\nMes no válido.");
            }
        }
        return cadena_meses.substring(0, cadena_meses.length() - 2);
    }
}