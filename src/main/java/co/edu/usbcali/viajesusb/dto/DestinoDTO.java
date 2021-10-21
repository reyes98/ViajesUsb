/**  
 * @Title:  DestinoDTO.java   
 * @Package co.edu.usbcali.viajesusb.dto   
 * @Description: description   
 * @author: Reyes98    
 * @date:   28/09/2021 11:14:52 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**   
 * @ClassName:  DestinoDTO   
 * @Description: TODO   
 * @author: Reyes98   
 * @date:   28/09/2021 11:14:52 a. m.      
 * @Copyright:  USB
 */
@Data
public class DestinoDTO implements Serializable{

	/**   
	 * @Fields serialVersionUID: TODO (what does this variable mean)   
	 */
	private static final long serialVersionUID = 1788451459550469775L;

	public Long idDest;
	
	public String codigo;
	
	public String nombre;
	
	public String descripcion;
	
	public String tierra;
	
	public String aire;
	
	public String mar;
	
	public Date fechaCreacion;
	
	public Date fechaModificacion;
	
	public String usuCreador;
	
	public String usuModificador;
	
	public String estado;
	
	public Long idTide;
	public String codigoTipoDestino;
	public String estadoTipoDestino;
	public String nombreTipoDestino;


}
