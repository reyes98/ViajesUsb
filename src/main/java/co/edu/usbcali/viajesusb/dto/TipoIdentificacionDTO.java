/**  
 * @Title:  TipoIdentificacionDTO.java   
 * @Package co.edu.usbcali.viajesusb.dto   
 * @Description: description   
 * @author: Reyes98    
 * @date:   4/10/2021 8:56:30 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**   
 * @ClassName:  TipoIdentificacionDTO   
 * @Description: TODO   
 * @author: Reyes98   
 * @date:   4/10/2021 8:56:30 p. m.      
 * @Copyright:  USB
 */
@Data
public class TipoIdentificacionDTO implements Serializable{

	/**   
	 * @Fields serialVersionUID: TODO (what does this variable mean)   
	 */
	private static final long serialVersionUID = 1L;
	
	private long idTiid;
	private String codigo;
	private String nombre;
	private Date fechaCreacion;	
	private Date fechaModificacion;
	private String usuCreador;	
	private String usuModificador;
	private String estado;

}
