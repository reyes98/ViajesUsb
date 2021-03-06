/**  
 * @Title:  TipoDestinoDTO.java   
 * @Package co.edu.usbcali.viajesusb.dto   
 * @Description: description   
 * @author: Reyes98    
 * @date:   28/09/2021 11:19:54 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**   
 * @ClassName:  TipoDestinoDTO   
 * @Description: TODO   
 * @author: Reyes98   
 * @date:   28/09/2021 11:19:54 a. m.      
 * @Copyright:  USB
 */
@Data
public class TipoDestinoDTO implements Serializable {

	/**   
	 * @Fields serialVersionUID: TODO (what does this variable mean)   
	 */
	private static final long serialVersionUID = 1L;
	private Long idTide;
	private String codigo;
	private String nombre;
	private String descripcion;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String usuCreador;
	private String usuModificador;
	private String estado;

}
