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

	public Long idTide;
	
	public String codigo;
	
	public String nombre;
	
	public String descripcion;
	
	public Date fechaCreacion;
	
	public Date fechaModificacion;
	
	public String usuCreador;
	
	public String usuModificador;
	
	public String estado;

}
