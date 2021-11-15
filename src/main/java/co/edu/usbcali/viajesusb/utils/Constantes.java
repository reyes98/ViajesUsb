/**  
 * @Title:  Constantes.java   
 * @Package co.edu.usbcali.viajesusb.utils   
 * @Description: description   
 * @author: Reyes98    
 * @date:   11/09/2021 10:41:45 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

/**
 * @ClassName: Constantes
 * @Description: Constantes usadas en la aplicación
 * @author: Reyes98
 * @date: 11/09/2021 10:41:45 a. m.
 * @Copyright: USB
 */
public interface Constantes {
	// Parametros
	public final static int EDAD_MINIMA= 18;
	
	// Respuestas
	public final static String SI = "S";
	public final static String NO = "N";

	// Estados
	public final static String ACTIVO = "A";
	public final static String INACTIVO = "I";

	// Patrones
	public final static  String PATRON_CORREO = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
	public final static  String PATRON_NUMERO= "\\d*";
	public final static  String PATRON_NUMERO_IDENTIFICACION= "^\\d+(\\.\\d+)*$";
	public final static Pattern PATTERN_CORREO = Pattern.compile(PATRON_CORREO, Pattern.CASE_INSENSITIVE);
	
	//Parametros contraseñas
	public final static String MIN_LENGHT="8";
    public final static String MAX_LENGHT="20";
    public final static String ONE_DIGIT = "(?=.*[0-9])";  //(?=.*[0-9]) al menos un digito
    public final static String LOWER_CASE = "(?=.*[a-z])";  //(?=.*[a-z]) al menos una letra minuscula
    public final static String UPPER_CASE = "(?=.*[A-Z])";  //(?=.*[A-Z]) al menos una letra mayuscula
    public final static String NO_SPACE = "(?=\\S+$)";  //(?=\\S+$) sin espacios en la cadena
    public final static String MIN_CHAR = ".{" + MIN_LENGHT + ",}";  //.{8,} al menos  8 letras
    public final static String MIN_MAX_CHAR = ".{" + MIN_LENGHT + "," + MAX_LENGHT + "}";  //.{8,20} representa el rango de letras
    public final static String PATRON_PASSWORD = ONE_DIGIT + LOWER_CASE + UPPER_CASE + NO_SPACE + MIN_MAX_CHAR;
	

	
	/**   
	 * @Title: ahora   
	 * @Description: TODO 
	 * @param: @return la fecha actual     
	 * @return: Date      
	 * @throws   
	 */
	public static Date ahora() {
		return Calendar.getInstance().getTime();
	}
	
	/**
	 * Retorna una fecha inicial con horas, minutos y segundos: 00:00:00
	 * 
	 * @author Frank Edward Daza González
	 * @date Nov 20, 2017
	 * @param date
	 * @return Date
	 * @throws Exception
	 */
	public static Date buildStartDate(Date date) throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		return calendar.getTime();
	}
	
	/**
	 * Retorna una fecha final con horas, minutos y segundos: 23:59:59
	 * 
	 * @author Frank Edward Daza González
	 * @date Nov 20, 2017
	 * @param date
	 * @return Date
	 * @throws Exception
	 */
	public static Date buildFinalDate(Date date) throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		
		return calendar.getTime();
	}
	
	public static int calcularEdad(Date nac) {
		
		Calendar fechaNacimiento = new GregorianCalendar(nac.getYear()+1900, nac.getMonth(), nac.getDay());
		Calendar ahora = Calendar.getInstance();

		long edadEnDias = (ahora.getTimeInMillis() - fechaNacimiento.getTimeInMillis())
		                        / 1000 / 60 / 60 / 24; 
		return Double.valueOf(edadEnDias / 365.25d).intValue();
	}
}
