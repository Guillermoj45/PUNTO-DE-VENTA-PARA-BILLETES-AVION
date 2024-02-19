import java.util.Scanner;
import java.util.Locale;
import java.time.LocalTime;
import java.time.LocalDate;
//import java.text.ParseException;
//import java.util.Date;
//import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
public class ApoyoPuntoVenta {

    public static String transformaFecha(String[] args) {
//        System.out.println("Opción 1");

        String[] meses = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };

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

//        String fechaBasica = String.join("/", arg1, arg2, arg3);
//        SimpleDateFormat inputFormatter = new SimpleDateFormat("dd/MM/yyyy");
//        Date date = inputFormatter.parse(fechaBasica);
//        SimpleDateFormat outputFormatter = new SimpleDateFormat("d-MMMM-yyyy", new Locale("es", "ES"));
//        String fechaSalida = outputFormatter.format(date);

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
            }
            else {
                System.out.println("\nMes no válido.");
            }
        }
        return cadena_meses.substring(0, cadena_meses.length() - 2);
    }

    public static int diaMaximoMes() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIntroduzca el mes en formato cadena: ");
        String mesCadena = scanner.next();


        HashMap<String, Integer> mesesDiasMaximos = new HashMap<>();
        mesesDiasMaximos.put("Enero", 31);
        mesesDiasMaximos.put("Febrero", 28);
        mesesDiasMaximos.put("Marzo", 31);
        mesesDiasMaximos.put("Abril", 30);
        mesesDiasMaximos.put("Mayo", 31);
        mesesDiasMaximos.put("Junio", 30);
        mesesDiasMaximos.put("Julio", 31);
        mesesDiasMaximos.put("Agosto", 31);
        mesesDiasMaximos.put("Septiembre", 30);
        mesesDiasMaximos.put("Octubre", 31);
        mesesDiasMaximos.put("Noviembre", 30);
        mesesDiasMaximos.put("Diciembre", 31);

        int diaMaximo = mesesDiasMaximos.get(mesCadena);

        return diaMaximo;
    }
}