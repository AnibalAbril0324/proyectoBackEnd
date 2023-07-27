package ups.edu.ec.ProyectoParqueadero.Negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CalculoCosto{

    private static final double TARIFA_POR_HORA = 2.50;

    /*public static void main(String[] args) {
        String horaEntradaStr = "10:15";
        String horaSalidaStr = "14:45";
        
        double totalAPagar = calcularTotalAPagar(horaEntradaStr, horaSalidaStr);
        System.out.println("Total a pagar: $" + totalAPagar);
    }
*/
    public static double calcularTotalAPagar(String horaEntradaStr, String horaSalidaStr) {
      
    	/*SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            Date horaEntrada = sdf.parse(horaEntradaStr);
            Date horaSalida = sdf.parse(horaSalidaStr);

            long duracionEstacionamientoMillis = horaSalida.getTime() - horaEntrada.getTime();
            long duracionHoras = TimeUnit.MILLISECONDS.toHours(duracionEstacionamientoMillis);

        
            if (duracionEstacionamientoMillis % 3600000 != 0) {
                duracionHoras++;
            }

            double totalAPagar = duracionHoras * TARIFA_POR_HORA;
            return totalAPagar;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0.0;
        }*/
    	return 0.0;
    }
}

