/**  
 * @Title:  DetallePlanDTO.java   
 * @Package co.edu.usbcali.viajesusb.dto   
 * @Description: description   
 * @author: Reyes98    
 * @date:   11/11/2021 3:36:25 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @ClassName: DetallePlanDTO
 * @Description: TODO
 * @author: Reyes98
 * @date: 11/11/2021 3:36:25 p. m.
 * @Copyright: USB
 */
@Data
public class DetallePlanDTO implements Serializable {

	/**
	 * @Fields serialVersionUID: TODO (what does this variable mean)
	 */
	private static final long serialVersionUID = 1277794147733310453L;

	private long idDepl;
	private String alimentacion;
	private String hospedaje;
	private String transporte;
	private String traslados;
	private double valor;
	private int cantidadNoches;
	private int cantidadDias;	
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String usuCreador;
	private String usuModificador;
	private String estado;
	private Long idPlan;
	private Long idDest;

}
