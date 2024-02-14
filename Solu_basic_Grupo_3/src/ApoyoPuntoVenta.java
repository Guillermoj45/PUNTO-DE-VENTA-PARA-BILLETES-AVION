import java.util.Scanner;

public class ApoyoPuntoVenta {

    public static String gener_hora_llegada() {
        System.out.println("Opción 2");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Hora de despegue (hh:mm): ");
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
}