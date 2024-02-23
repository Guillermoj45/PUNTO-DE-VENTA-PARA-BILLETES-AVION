import java.util.Scanner;
import java.util.Locale;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Month;
import java.time.format.TextStyle;
public class ApoyoPuntoVenta {

    public static String transformaFecha(String[] args) {
//        System.out.println("Opción 1");

        //Recepción de valores como parámetros de ejecución
        String arg1 = args[0];
        String arg2 = args[1];
        String arg3 = args[2];

        System.out.println("\nSe ha recibido como parámetro de ejecución\n");
        System.out.println("Día: " + arg1);
        System.out.println("Mes: " + arg2);
        System.out.println("Año: " + arg3);


        //Formateo de la fecha
        String fechaBasica = String.join("/", arg1, arg2, arg3);
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(fechaBasica, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("d-MMMM-yyyy", new Locale("es", "ES"));
        String fechaSalida = date.format(outputFormatter);


        return fechaSalida;
    }


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
            } else {
                System.out.println("\nMes no válido.");
            }
        }
        return cadena_meses.substring(0, cadena_meses.length() - 2);
    }

    public static int numeroDiasMes() {

        //Introducir nombre del mes por teclado
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIntroduzca el mes en formato cadena: ");
        String nombreMes = scanner.next();

        //Traducir el nombre del mes y hallar su longitud
        int diasMes = 0;
        boolean mesValido = false;
        for (Month month : Month.values()) {
            if (month.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("es")).equalsIgnoreCase(nombreMes)) {
                diasMes = month.length(false);
                mesValido = true;
                break;
            }
        }
        if (mesValido = false) {
            System.out.print("\nMes no válido.\n");
        }
        return diasMes;
    }
}