import java.util.Scanner;

public class ApoyoPuntoVenta {

    public static String gener_hora_llegada() {
        System.out.println("Opción 2");

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nHora de despegue (hh:mm): ");
        String horaDespegue = scanner.next();
        System.out.print("Duración (en minutos): ");
        int duracionMin = scanner.nextInt();

        String[] horasDespegue = horaDespegue.split(":");
        int hora = Integer.parseInt(horasDespegue[0]);
        int minutos = Integer.parseInt(horasDespegue[1]);

        int totalMin = hora * 60 + minutos + duracionMin;

        int horaFin = totalMin / 60;
        int minFin = totalMin % 60;

        return String.format("%02d:%02d", horaFin, minFin);
    }

    public static void gener_tabla_nombres() {
        System.out.println("Opción 3");

        String[] meses = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };


        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nIntroduzca el mes en formato numérico: ");
            int num_mes = scanner.nextInt();

            System.out.println("\nLa tabla se está generando...");
            int primer_mes = num_mes - 1;

            if (primer_mes >= 0 && num_mes <= 12) {
                String cadena_meses = "";

                for (int i = 0; i < meses.length; i++) {
                    cadena_meses += (meses[(primer_mes + i) % meses.length] + ", ");
                }

                System.out.println("\nEl resultado solicitado es:\n" + cadena_meses);
                break;
            }
            else {
                System.out.println("\nMes no válido.");
            }
        }
    }
}