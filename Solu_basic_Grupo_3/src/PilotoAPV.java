public class PilotoAPV {
    public static void main(String[] args) {
        String hora_llegada = ApoyoPuntoVenta.gener_hora_llegada();
        System.out.println("\nEl resultado solicitado de la misma es: " + hora_llegada + "\n");


        String cadena_meses = ApoyoPuntoVenta.gener_tabla_nombres();
        System.out.println("\nEl resultado solicitado es:\n" + cadena_meses);
    }
}