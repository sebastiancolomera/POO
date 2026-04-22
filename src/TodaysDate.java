import java.util.Calendar;
import java.util.GregorianCalendar;

public class TodaysDate {
    String time;
    public int day;
    private int month;
    protected int year;

    public void printDateAndTime() {
        GregorianCalendar fecha = new GregorianCalendar();
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
        
        time = hora + ":" + minuto + ":" + segundo;
        
        day = fecha.get(Calendar.DATE);
        month = fecha.get(Calendar.MONTH) + 1;
        year = fecha.get(Calendar.YEAR);
        
        System.out.println("Hora: " + time);
        System.out.println("Fecha: " + day + "/" + month + "/" + year);
    }
}