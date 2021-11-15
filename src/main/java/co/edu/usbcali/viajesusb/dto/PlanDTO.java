/**  
 * @Title:  PlanDTO.java   
 * @Package co.edu.usbcali.viajesusb.dto   
 * @Description: description   
 * @author: Reyes98    
 * @date:   1/11/2021 1:35:15 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @ClassName: PlanDTO
 * @Description: TODO
 * @author: Reyes98
 * @date: 1/11/2021 1:35:15 p. m.
 * @Copyright: USB
 */
@Data
public class PlanDTO implements Serializable {
	/**   
	 * @Fields serialVersionUID: TODO (what does this variable mean)   
	 */
	private static final long serialVersionUID = 1009073465993027839L;
	private long idPlan;
	private String codigo;
	private String nombre;
	private String descripcionSolicitud;
	private int cantidadPersonas;
	private Date fechaSolicitud;
	private Date fechaInicioViaje;
	private Date fechaFinViaje;
	private double valorTotal;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String usuCreador;
	private String usuModificador;
	private String estado;
	private Long idClie;
	private Long idUsua;
}
